package com.company.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HashGenerator {

    //Um package IDs zu generieren
    public static Integer hashID(){
        Random random = new Random();
        Float f = random.nextFloat();
        int i = f.hashCode();

        return i;
    }

    public static String hashString(){
        hashID();

        return hashID().toString();
    }

    //Für den Deck shuffle
    public static int randomDeckNumber(int deckSize){
        int min = 0;
        int constant = 1;
        int v = (int)(Math.random()*(deckSize-min+constant)+min);
        return v;
    }

    //Für die Token Based Security
    public String hashMe(final String input) {

        String hashtext = null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Compute message digest of the input
        byte[] messageDigest = md.digest(input.getBytes());

        hashtext = convertToHex(messageDigest);

        return hashtext;
    }

    private String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
            hexText = "0".concat(hexText);
        }
        return hexText;
    }
}
