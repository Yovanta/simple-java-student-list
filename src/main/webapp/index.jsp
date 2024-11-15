<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#loginForm').submit(function (event) {
                let userId = $('#userId').val();
                let password = $('#password').val();

                if (userId === '' || password === '') {
                    alert('Both fields are required!');
                    event.preventDefault();
                }
            });
        });
    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background: #ffffff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            padding: 20px 40px;
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333333;
        }

        label {
            font-weight: bold;
            margin-bottom: 10px;
            display: block;
            color: #555555;
            text-align: left;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #cccccc;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #6200ff;
            color: #ffffff;
            font-size: 16px;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background-color: #6200ff;
        }

        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login Page</h2>
    <form id="loginForm" action="login" method="post">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" placeholder="Enter your User ID">

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your Password">

        <button type="submit">Login</button>

        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        <div class="error"><%= error %></div>
        <% } %>
    </form>
</div>
</body>
</html>
