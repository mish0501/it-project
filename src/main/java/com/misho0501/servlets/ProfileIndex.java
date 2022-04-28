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

@WebServlet(name = "ProfileIndex", urlPatterns = {"/user"})
public class ProfileIndex extends HttpServlet {
    Repository repository;

    public void init() {
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = null;
        if (username != null && !username.isEmpty()) {
            user = repository.getUserByUsername(username);
        }

        if (user == null) {
            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect(request.getContextPath() + "/login?error=" + URLEncoder.encode("Трябва да сте логнати, за да видите страницата", "UTF-8"));
                return;
            } else {
                user = (User) request.getSession().getAttribute("user");
            }
        }

        request.setAttribute("user", user);

        request.getRequestDispatcher("/public/user/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
