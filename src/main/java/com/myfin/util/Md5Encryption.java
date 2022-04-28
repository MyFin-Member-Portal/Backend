package com.myfin.util;

import java.security.MessageDigest;

/**
 * MD5 encryption tools class
 * @author Zihang Gao, Yuzhuo Ma
 */

public class Md5Encryption {

    private static final String SALT = "FIT4002_MyFin.com";

    public static String encode(String password) {
        password = password + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();

        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

//    public static void main(String[] args) {
//        String hashPass = Md5Encryption.encode("123456");
//        System.out.println(Md5Encryption.encode("123456"));
//    }
}
