<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Cookie[] cookies = request.getCookies();
    boolean isVisible = true;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("welcome")) {
                isVisible = false;
                break;
            }
        }
    }
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