package com.enigma.controller;

import com.enigma.service.StudentService;
import com.enigma.service.impl.StudentServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/students")
public class StudentController extends HttpServlet {
  private final StudentService studentService;

  public StudentController() {
    this.studentService = new StudentServiceImpl();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userId = (String) request.getSession().getAttribute("userId");

    if (userId == null) {
      response.sendRedirect(request.getContextPath() + "/index");
      return;
    }

    request.setAttribute("students", studentService.getStudents());
    request.setAttribute("passPercentages", studentService.getPassPercentages());
    request.setAttribute("userId", userId);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/welcomePage.jsp");
    dispatcher.forward(request, response);
  }
}
