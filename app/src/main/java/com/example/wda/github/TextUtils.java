package com.example.wda.github;

import android.util.Patterns;

import java.util.regex.Pattern;

public class TextUtils {
    private static Pattern emailAdressPattern;

    public static Pattern getEmailAdressPattern() {
        if (emailAdressPattern == null) {
            emailAdressPattern = Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                            "\\@" +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                            "(" +
                            "\\." +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                            ")+"
            );
        }

        return emailAdressPattern;
    }

    public static boolean isEmail(String text){
        return getEmailAdressPattern().matcher(text).matches();
    }

    static boolean areStringsEqual(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
}
