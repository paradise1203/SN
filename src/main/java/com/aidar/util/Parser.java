package com.aidar.util;

public class Parser {

    public static String parseId(String s) {
        String res = "";
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if ('0' <= c && c <= '9')
                res += Character.toString(c);
        }
        return res;
    }

}
