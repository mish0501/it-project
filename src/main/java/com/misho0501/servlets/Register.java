package com.misho0501.servlets;

import com.misho0501.beans.User;
import com.misho0501.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    Repository repository;

    public void init() {
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        request.getRequestDispatcher("/public/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");

        if (repository.hasExist(username)) {
            request.setAttribute("error", "Потребителското име вече съществува.");
            request.setAttribute("name", name);
            request.setAttribute("username", username);
            request.getRequestDispatcher("/public/register.jsp").forward(request, response);
            return;
        }

        if (password.length() > 0 && password.equals(passwordConfirm) && name.length() > 0 && username.length() > 0) {
            User user = new User(name, username, password);

            repository.addUser(user);

            response.sendRedirect("/login?success=" + URLEncoder.encode("Успешна регистрация.", "UTF-8"));
        } else {
            request.setAttribute("error", "Паролите не съвпадат.");
            request.setAttribute("name", name);
            request.setAttribute("username", username);
            request.getRequestDispatcher("/public/register.jsp").forward(request, response);
        }
    }
}
