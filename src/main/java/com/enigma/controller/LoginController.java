package com.enigma.controller;

import com.enigma.service.LoginService;
import com.enigma.service.impl.LoginServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class LoginController extends HttpServlet {
  private final LoginService loginService;

  public LoginController() {
    this.loginService = new LoginServiceImpl();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    if (loginService.login(userId, password)) {
      request.getSession().setAttribute("userId", userId);
      response.sendRedirect(request.getContextPath() + "/students");
    } else {
      request.setAttribute("error", "Invalid User ID or Password!");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
      dispatcher.forward(request, response);
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect(request.getContextPath() + "/index.jsp");
  }
}
