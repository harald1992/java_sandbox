package com.harald.jwtauthbff.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

/*
Looks for a cookie jwt in the cookie and if so saves it to the thread local variable so it can be used in the resttemplate interceptor to send it in the header as jwt.
 */
@Component
public class CookieJwtReaderInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // String jwt = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {

            String jwt = Arrays.stream(request.getCookies())
                    .filter(cookie -> "accessToken".equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
            CookieContextHolder.setCookie(jwt);
        }

        return true;
    }

}
