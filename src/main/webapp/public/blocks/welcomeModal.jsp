<%@ page import="helpers.CookieWorker" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    boolean isVisible = (boolean) request.getAttribute("isVisible");
%>
<div class="modal <%= isVisible ? "modal-visible" : "" %>">
    <div class="modal-content">
        <div class="title">
            Добре дошли!
        </div>

        <div class="action">
            <form action="<%= request.getContextPath() %>/welcomeModal" method="post">
                <button class="modal-button" type="submit">Изключи</button>
            </form>
        </div>
    </div>
</div>