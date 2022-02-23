package com.company.server;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferConvert {
    public Request read(BufferedReader blank){


        StringBuilder text = new StringBuilder();

        try {
            text.append(blank.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
