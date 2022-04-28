<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="nav">
    <div class="container">
        <%
            if (request.getSession().getAttribute("user") == null) {
        %>
        <a class="nav-link" href="<%= request.getContextPath() %>/login">Вход</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/register">Регистрация</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/users">Потребители</a>
        <%
        } else {
        %>
        <a class="nav-link" href="<%= request.getContextPath() %>/users">Потребители</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/logout">Изход</a>
        <%
            }
        %>

    </div>
</div>
