package org.example.nguyenducthang_dacn_webblogcanhan.utils;

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
}
