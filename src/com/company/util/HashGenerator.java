package com.company.util;

import java.util.Random;

public class HashGenerator {

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
}
