<%@ page import="com.misho0501.beans.Skill" %>
<jsp:useBean id="user" scope="session" type="com.misho0501.beans.User"/>
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
<form action="<%= request.getContextPath() %>/user/edit" method="post">
    <div class="main">
        <div class="container">
            <div class="section-1">
                <div class="actions">
                    <button
                            class="action"
                            id="basicInfoButton"
                    >
                        Запази
                    </button>
                </div>
                <div class="profile-image">
                    <img src="<%= user.getPhoto() != null ? user.getPhoto() : "../resources/images/male.svg" %>" alt="">
                </div>

                <div class="profile-info">
                    <h2>Профилна информация</h2>

                    <label>
                        Име:
                        <input type="text" name="name" placeholder="Име" id="name"
                               value="<%= user.getName() != null ? user.getName() : "" %>">
                    </label>

                    <label>
                        Работа:
                        <input type="text" name="jobTitle" placeholder="Работа:" id="jobTitle"
                               value="<%= user.getJob() != null ? user.getJob() : "" %>">
                    </label>

                    <label>
                        Описание:
                        <textarea name="description" id="description"
                                  placeholder="Описание:"><%= user.getDescription() != null ? user.getDescription() : "" %></textarea>
                    </label>
                </div>

                <div class="clear"></div>
            </div>

            <div class="section section-2">
                <div class="actions">
                    <button
                            id="skillsButton"
                            class="action"
                    >
                        Запази
                    </button>
                </div>

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

                        <input class="jobSkills" name="<%=jobSkill.getName()%>" type="range" min="1" max="100" value="<%= jobSkill.getPercent() %>">
                        </span>
                        <%}%>
                    </div>
                    <div class="col">
                        <%if (personalSkill != null) {%>
                        <p>
                            <%= personalSkill.getName() %>
                        </p>

                        <input class="personalSkills" name="<%= personalSkill.getName() %>" type="range" min="1" max="100" value="<%= personalSkill.getPercent() %>">
                        </span>
                        <%}%>
                    </div>
                </div>
                <%}%>
            </div>

            <div class="section section-3">
                <div class="actions">
                    <button
                            id="contactsButton"
                            class="action"
                    >
                        Запази
                    </button>
                </div>

                <div class="row">
                    <div class="col">
                        <p>Email</p>

                        <input type="text" name="email" value="<%= user.getEmail() != null ? user.getEmail() : "" %>" />
                    </div>
                    <div class="col">
                        <p>Град</p>

                        <input type="text" name="city"
                               value="<%= user.getLocation() != null && user.getLocation().getCity() != null ? user.getLocation().getCity() : "" %>"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <p>Телефон</p>

                        <input type="text" name="phone" value="<%= user.getPhone() != null ? user.getPhone() : "" %>"/>

                    </div>
                    <div class="col">
                        <p>Улица</p>

                        <input type="text" name="street"
                               value="<%= user.getLocation() != null && user.getLocation().getStreet() != null ? user.getLocation().getStreet() : "" %>"/>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<script src="<%= request.getContextPath() %>/resources/js/editUser.js"></script>
</body>
</html>