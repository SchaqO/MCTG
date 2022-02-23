package com.company.responses;

import com.company.server.Request;
import com.company.server.Response;

public class UserControl {

    Request request = null;
    public UserControl(Request request){
        this.request = request;
    }

    public Response login(){
        String json = request.getContent();

        System.out.println(json);
        return new Response();
    }
}
