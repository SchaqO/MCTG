package com.company.server;


import com.company.control.*;
import com.company.model.User;

import java.io.*;
import java.lang.constant.DynamicCallSiteDesc;
import java.net.Socket;

public class Router {

    Socket clientSocket;
    Request request = null;
    Response response = null;


    public Router(Socket currentClient){
        //3. Addresse vom Client wird übergeben
        clientSocket = currentClient;
        readSocket();
    }


    //8. Gets redirected to Usercontrol or generally, Control methods.
    Response post(Request request){

        switch (request.getRoute()){
            case "/users": return new UserControl().post(request);
            case "/sessions": return new SessionControl().post(request);
            case "/packages": return new PackageControl().post(request);
            case "/transactions/packages": return new UserControl().post(request);
            case "/tradings": return new UserControl().post(request);
            case "/battles": return new BattleControl().post(request);

        }
        return new Response(404,"NOT FOUND", "ERROR");
    }
    Response get(Request request){
        if(request.getRoute().contains("/users/")){
            return new ProfileControl().get(request);
        }

        switch (request.getRoute()){
            case "/cards": return new CardControl().get(request);
            case "/deck": return new DeckControl().get(request);
            case "/stats": return new StatControl().get(request);
            case "/score": return new ScoreControl().get(request);
            case "/tradings": return new TradingControl().get(request);
        }
        return new Response(404,"NOT FOUND", "ERROR");
    }
    Response delete(Request request){
        switch (request.getRoute()){
            case "/users": return new UserControl().post(request);
            case "/tradings": return new TradingControl().delete(request);
        }
        return new Response(404,"NOT FOUND", "ERROR");
    }
    Response put(Request request){

        if(request.getRoute().contains("/users/")){
            return new ProfileControl().put(request);
        }

        switch (request.getRoute()){
            case "/deck": return new DeckControl().put(request);
        }
        return new Response(404,"NOT FOUND", "ERROR");
    }



    //7.
    Response mapping(Request request){

        switch (request.getMethod()){
            case "POST": return post(request);
            case "GET": return get(request);
            case "DELETE": return delete(request);
            case "PUT": return put(request);
        }

        return new Response(404,"NOT FOUND", "ERROR");
    }








    //4. Buffer makes it human readable, RequestBuilder takes data from the Buffer and changes it to String
    public void readSocket(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            RequestBuilder requestBuilder = new RequestBuilder();
            this.request = requestBuilder.build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //6. Response gets mapped to route
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
