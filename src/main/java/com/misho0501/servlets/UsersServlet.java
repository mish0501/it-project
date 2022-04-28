package com.misho0501.servlets;

import com.misho0501.beans.User;
import com.misho0501.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {
    private Repository repository;

    public void init() {
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashSet<User> users = repository.getUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/public/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
