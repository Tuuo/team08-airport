package com.isoft.config;

/*
* 将传入的字符串去除首尾空格，并在去除空格后，如果结果是空字符串，则返回 null。
* 这样可以方便地处理字符串的空值情况
*/
public class StringUtil {
    public static String trimToNull(String str) {
        if (str == null) {
            return null;
        }
        String trimmed = str.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
}
