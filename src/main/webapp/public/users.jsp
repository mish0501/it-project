<%@ page import="com.misho0501.beans.User" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <title>Вход</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/nav.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/forms.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/tables.css">
</head>
<body>
<%@include file="blocks/nav.jsp" %>
<div class="main">
    <table>
        <thead>
        <tr>
            <th>Име</th>
            <th>Работа</th>
            <th>Описание</th>
        </tr>
        </thead>
        <tbody>
        <%
            Set<User> users = (Set<User>) request.getAttribute("users");
            for (User user : users) {
        %>
        <tr>
            <td>
                <a href="<%= request.getContextPath() %>/user?username=<%= user.getUsername() %>">
                    <%= user.getName() %>
                </a>
            </td>
            <td>
                <%= user.getJob() %>
            </td>
            <td>
                <%= user.getDescription() %>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>