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

@WebServlet(name = "ProfileEdit", urlPatterns = {"/user/edit"})
public class ProfileEdit extends HttpServlet {
    Repository repository;

    public void init() {
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login?error=" + URLEncoder.encode("Трябва да сте логнати, за да видите страницата", "UTF-8"));
            return;
        }

        request.getRequestDispatcher("/public/user/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"),
                job = request.getParameter("jobTitle"),
                description = request.getParameter("description");

        User user = (User) request.getSession().getAttribute("user");

        user.update(name, job, description);

        response.sendRedirect(request.getContextPath() + "/user");
    }
}
