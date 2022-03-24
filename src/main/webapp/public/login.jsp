<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <title>Вход</title>
    <link rel="stylesheet" href="../resources/css/forms.css">
</head>
<body>
<form action="login" method="post">
    <h1>Влезте в системата</h1>

    <%@include file="blocks/alerts.jsp" %>

    <div class="container">
        <div class="form-group">
            <label for="username">Потребителско име:</label>
            <input type="text" name="username" id="username" placeholder="Въведете потребителско име">
        </div>
        <div class="form-group">
            <label for="password">Парола:</label>
            <input type="password" name="password" id="password" placeholder="Въведете парола поне 8 символа">
        </div>

        <div class="form-group">
            <button type="submit">Вход</button>
        </div>
    </div>
</form>
</body>
</html>