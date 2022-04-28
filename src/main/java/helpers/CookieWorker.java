package helpers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class CookieWorker {
    public static Cookie getWelcomeCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("welcome")) {
                return cookie;
            }
        }
        return null;
    }
}
