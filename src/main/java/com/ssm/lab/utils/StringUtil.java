package com.ssm.lab.utils;

/**
 *
 * @author Administrator
 */
public class StringUtil {

    //将转义字符转为HTML元素
    public static String convertStringToHtml(String contentC) {
        String content = contentC;
        if (content == null) {
            return "";
        }
        content = content.replaceAll("&amp;", "&");
        content = content.replaceAll("&lt;", "<");
        content = content.replaceAll("&gt;", ">");
        content = content.replaceAll("&quot;", "\"");
        content = content.replaceAll("\r&#10;", "　\n");
        content = content.replaceAll("&#10;", "　\n");
        content = content.replaceAll("&#032;", " ");
        content = content.replaceAll("&#039;", "'");
        content = content.replaceAll("&#033;", "!");

        return content;
    }

    //将HTML转为转义字符
    public static String convertHtmlToString(String contentC) {
        String content = contentC;
        if (content == null) {
            return "";
        }
        content = content.replaceAll("&", "&amp;");
        content = content.replaceAll("<", "&lt;");
        content = content.replaceAll(">", "&gt;");
        content = content.replaceAll("\"", "&quot;");
        content = content.replaceAll("\n\r", "&#10;");
        content = content.replaceAll("\r\n", "&#10;");
        content = content.replaceAll("\n", "&#10;");
        content = content.replaceAll(" ", "&#032;");
        content = content.replaceAll("'", "&#039;");
        content = content.replaceAll("!", "&#033;");

        return content;
    }
    
    public static String convertString(String content, int size) {
        if(content.length() > size) {
            return content.substring(0, size) + "...";
        } else {
            return content;
        }
    }

}
