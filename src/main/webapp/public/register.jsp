<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <title>Регистрация</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/nav.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/forms.css">
</head>
<body>
<%@include file="blocks/nav.jsp" %>
<div class="main">
    <form method="post" action="<%= request.getContextPath() %>/register">
        <h1>Създаване на профил</h1>

        <%@include file="blocks/alerts.jsp" %>

        <div class="container">
            <div class="form-group">
                <label for="name">Име:</label>
                <input type="text" name="name" id="name" placeholder="Въведете име за контакт"
                       value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>">
            </div>
            <div class="form-group">
                <label for="username">Потребителско име:</label>
                <input type="text" name="username" id="username" placeholder="Въведете потребителско име"
                       value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>">
            </div>
            <div class="form-group">
                <label for="password">Парола:</label>
                <input type="password" name="password" id="password" placeholder="Въведете парола поне 8 символа">
            </div>
            <div class="form-group">
                <label for="passwordConfirm">Повтори парола:</label>
                <input type="password" name="passwordConfirm" id="passwordConfirm"
                       placeholder="Въведете парола поне 8 символа">
            </div>
            <div class="form-group">
                <button type="submit">Регистрация</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>