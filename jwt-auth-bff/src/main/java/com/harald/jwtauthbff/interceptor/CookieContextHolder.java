package com.harald.jwtauthbff.interceptor;

public class CookieContextHolder {
    private static final ThreadLocal<String> cookieHolder = new ThreadLocal<>();    // variable just in this thread. And all api calls reate another thread in spring.
    public static void setCookie(String jwt) {
        System.out.println("JWT SET:  " + jwt);
        cookieHolder.set(jwt);
    }
    public static String getCookie() {
        System.out.println("JWT GET: " + cookieHolder.get());
        return cookieHolder.get();
    }

    public static void clear() {
        cookieHolder.remove();
    }
}