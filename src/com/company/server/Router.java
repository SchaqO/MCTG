package com.company.server;


import com.company.control.UserControl;
import com.company.model.User;

import java.io.*;
import java.net.Socket;

public class Router {

    Socket clientSocket;
    Request request;
    Response response;


    public Router(Socket currentClient){
        clientSocket = currentClient;
        readSocket();
    }



    Response post(Request request){
        switch (request.getRoute()){
            case "/users": return new UserControl().post(request);
        }
        return null;
    }
    Response get(Request request){
        switch (request.getRoute()){
            case "/users": System.out.println("Hello world");
        }
        return null;
    }

    Response mapping(Request request){

        switch (request.getMethod()){
            case "POST": post(request);break;
            case "GET": get(request);break;
        }
        return null;
    }









    public void readSocket(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            RequestBuilder requestBuilder = new RequestBuilder();
            request = requestBuilder.build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

        response = mapping(request);


      //  System.out.println(request.getContent());




//        UserControl handler = new UserControl(request);
  //      response = handler.login();


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
