package com.misho0501.servlets;

import com.misho0501.beans.User;
import helpers.CookieWorker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "WelcomeModal", urlPatterns = {"/welcomeModal"})
public class WelcomeModal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String welcomeCookie = getWelcomeCookie(request);
        Cookie cookie = new Cookie("welcome", String.format("%s+%s", welcomeCookie, user.getUsername()));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/user");
    }

    private String getWelcomeCookie(HttpServletRequest request) {
        Cookie cookie = CookieWorker.getWelcomeCookie(request);
        if (cookie != null) {
            return cookie.getValue();
        }
        return "";
    }
}
