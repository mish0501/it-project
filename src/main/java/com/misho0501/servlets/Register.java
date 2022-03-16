package com.misho0501.servlets;

import com.misho0501.beans.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/public/register.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        if (password.equals(passwordConfirm)) {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(password);

            request.getRequestDispatcher("/public/login.html").forward(request, response);
        } else {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("/public/register.html").forward(request, response);
        }
    }
}
