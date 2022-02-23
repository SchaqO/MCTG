package com.company.server;

import com.company.responses.UserControl;

import java.io.*;
import java.net.Socket;

public class Handler {

    Socket clientSocket;
    Request request;
    Response response;


    public Handler(Socket currentClient){

        clientSocket = currentClient;
        readSocket();
    }


    public void readSocket(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            RequestBuilder requestBuilder = new RequestBuilder();
            request = requestBuilder.build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }





        //switch case



        System.out.println(request.getContent());

        UserControl handler = new UserControl(request);
        response = handler.login();


        ///




        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            writer.write(response.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
