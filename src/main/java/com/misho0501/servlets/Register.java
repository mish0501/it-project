package com.misho0501.servlets;

import com.misho0501.beans.User;
import com.misho0501.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    Repository repository;

    public void init(){
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/public/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");

        if (repository.hasExist(username)) {
            request.setAttribute("error", "Username already exists.");
            request.getRequestDispatcher("/public/register.jsp").forward(request, response);
            return;
        }

        if (password.equals(passwordConfirm)) {
            User user = new User(name, username, password);

            repository.addUser(user);

            response.sendRedirect("/login");
        } else {
            request.setAttribute("error", "Passwords do not match.");
            request.getRequestDispatcher("/public/register.jsp").forward(request, response);
        }
    }
}