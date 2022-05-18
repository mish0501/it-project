package com.misho0501.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "AuthFilter", servletNames = {
        "Logout", "ProfileIndex", "ProfileEdit", "WelcomeModal"
})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Map<String, String[]> params = request.getParameterMap();

        if (session.getAttribute("user") == null && !params.containsKey("username")) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
