<%@ page import="com.misho0501.beans.Skill" %>
<%@ page import="com.misho0501.beans.User" %>
<%
    User user = (User) request.getAttribute("user");
    User sessionUser = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <title>Профил</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/modal.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/nav.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/profile.css">
</head>
<body>
<%@include file="../blocks/nav.jsp" %>
<div class="main">
    <div class="container">
        <div class="section-1">
            <% if (user.equals(sessionUser)) { %>
            <div class="actions">
                <a
                    class="action"
                    href="<%= request.getContextPath() %>/user/edit"
                >
                    Редактирай
                </a>
            </div>
            <% } %>

            <div class="profile-image">
                <img src="<%= user.getPhoto() != null ? user.getPhoto() : request.getContextPath() + "/resources/images/male.svg" %>" alt="">
            </div>

            <div class="profile-info">
                <h2>Профилна информация</h2>

                <p>Име: <%= user.getName() != null ? user.getName() : "" %>
                </p>

                <p>Работа: <%= user.getJob() != null ? user.getJob() : "" %>
                </p>

                <p>
                    Описание: <%= user.getDescription() != null ? user.getDescription() : "" %>
                </p>
            </div>

            <div class="clear"></div>
        </div>

        <div class="section section-2">
            <div class="row">
                <div class="col">
                    <h3>Професионални</h3>
                </div>
                <div class="col">
                    <h3>Личности</h3>
                </div>
            </div>

            <%
                int length = Math.max(user.getJobSkills().size(), user.getPersonalSkills().size());

                for (int i = 0; i < length; i++) {
                    Skill jobSkill = null, personalSkill = null;

                    if (i < user.getJobSkills().size()) {
                        jobSkill = user.getJobSkills().get(i);
                    }

                    if (i < user.getPersonalSkills().size()) {
                        personalSkill = user.getPersonalSkills().get(i);
                    }
            %>
            <div class="row">
                <div class="col">
                    <%if (jobSkill != null) {%>
                    <p>
                        <%= jobSkill.getName() %>
                    </p>

                    <span class="progress-bar">
                        <span class="progress" style="width: <%= jobSkill.getPercent() %>%"></span>
                    </span>
                    <%}%>
                </div>
                <div class="col">
                    <%if (personalSkill != null) {%>
                    <p>
                        <%= personalSkill.getName() %>
                    </p>

                    <span class="progress-bar">
                        <span class="progress" style="width: <%= personalSkill.getPercent() %>%"></span>
                    </span>
                    <%}%>
                </div>
            </div>
            <%}%>
        </div>

        <div class="section section-3">
            <div class="row">
                <div class="col">
                    <p>Email</p>

                    <%if (user.getEmail() != null) {%>
                    <a href="mailto:<%= user.getEmail() %>" class="alt-text">
                        <%= user.getEmail() %>
                    </a>
                    <%}%>
                </div>
                <div class="col">
                    <p>Град</p>

                    <%if (user.getLocation() != null && user.getLocation().getCity() != null) {%>
                    <p class="alt-text">
                        <%= user.getLocation().getCity() %>
                    </p>
                    <%}%>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <p>Телефон</p>

                    <%if (user.getPhone() != null) {%>
                    <a href="#" class="alt-text">
                        <%= user.getPhone() %>
                    </a>
                    <%}%>
                </div>
                <div class="col">
                    <p>Улица</p>

                    <%if (user.getLocation() != null && user.getLocation().getStreet() != null) {%>
                    <p class="alt-text">
                        <%= user.getLocation().getStreet() %>
                    </p>
                    <%}%>
                </div>
            </div>

        </div>
    </div>
</div>

<%@include file="../blocks/welcomeModal.jsp" %>
</body>
</html>