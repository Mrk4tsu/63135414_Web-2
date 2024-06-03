package com.mrkatsu.nguyenducthang_dacn_webblogcanhan.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utilities {
    public static String Redirect(String redirect){
        return "redirect:/" + redirect;
    }
    public  static java.sql.Date getCurrentDate(){
        return new java.sql.Date(System.currentTimeMillis());
    }
    public static String toMetaTitle(String title) {
        return title.toLowerCase()
                .replace(" ", "-")
                .replaceAll("[^a-z0-9-]", "");
    }
    public static String md5(String pass){
        var hash = new BCryptPasswordEncoder().encode(pass);
        return hash;
    }
}
