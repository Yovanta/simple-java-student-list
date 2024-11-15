<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.enigma.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".student-id").click(function () {
                let studentName = $(this).data("name");
                alert("Student Name: " + studentName);
            });
        });
    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #343a40;
            margin-top: 20px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        thead {
            background-color: #6200ff;
            color: white;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #dee2e6;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a.student-id {
            color: #6200ff;
            text-decoration: none;
        }

        a.student-id:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Welcome, <%= request.getAttribute("userId") %>!</h1>

<table>
    <thead>
    <tr>
        <th>Department</th>
        <th>Student ID</th>
        <th>Marks</th>
        <th>Pass %</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        Map<String, Double> passPercentages = (Map<String, Double>) request.getAttribute("passPercentages");

        if (students != null) {
            String previousDepartment = null;
            int rowspanCount = 0;

            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                String currentDepartment = student.getDepartment();
                Double passPercentage = passPercentages.get(currentDepartment);

                // Determine if this row should display a new Pass % or rowspan
                boolean showPassPercentage = !currentDepartment.equals(previousDepartment);

                if (showPassPercentage) {
                    rowspanCount = (int) students.stream()
                            .filter(s -> s.getDepartment().equals(currentDepartment))
                            .count();
                }

    %>
    <tr>
        <td><%= student.getDepartment() %></td>
        <td>
            <a href="#" class="student-id" data-name="<%= student.getStudentName() %>"><%= student.getStudentId() %>
            </a>
        </td>
        <td><%= student.getMark() %></td>
        <% if (showPassPercentage) { %>
        <td rowspan="<%= rowspanCount %>"><%= passPercentage %>%</td>
        <% } %>
    </tr>
    <%
                previousDepartment = currentDepartment;
            }
        }
    %>
    </tbody>
</table>

</body>
</html>
