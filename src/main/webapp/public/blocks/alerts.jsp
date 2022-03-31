<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String error = (String) request.getAttribute("error") != null ? (String) request.getAttribute("error") : request.getParameter("error");
    String success = (String) (request.getAttribute("success") != null ? request.getAttribute("success") : request.getParameter("success"));

    if (error != null) {
%>
<div class="alert error">
    <%= error %>
</div>
<% } %>

<% if (success != null) { %>
<div class="alert success">
    <%= success %>
</div>
<% } %>