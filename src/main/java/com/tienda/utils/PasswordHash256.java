package com.tienda.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordHash256 {
    public static String gereratedSalt(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz0123456789 ";
        StringBuilder salt = new StringBuilder("");

        Random aleattor = new Random();
        for (int i = 0; i < 16; i++)
            salt.append(characters.charAt(aleattor.nextInt(61)));
        return salt.toString();
    }
    public static String generatedHash(String salt,String password){
        String input = salt + password;
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] bytes = sha256.digest(input.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();

        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
