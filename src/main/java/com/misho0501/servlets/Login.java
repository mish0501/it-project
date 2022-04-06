package com.misho0501.servlets;

import com.misho0501.beans.User;
import com.misho0501.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login", "/index.html", "/index.jsp"})
public class Login extends HttpServlet {
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

        request.getRequestDispatcher("/public/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = repository.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);

            response.sendRedirect("/profile");
        } else {
            request.setAttribute("error", "Невалидни потребителско име или парола");
            request.getRequestDispatcher("/public/login.jsp").forward(request, response);
        }
    }
}
