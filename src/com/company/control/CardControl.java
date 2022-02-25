package com.company.control;

import com.company.control.respository.Get;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

public class CardControl implements Get {
    private Gson gson = new Gson();


    @Override
    public Response get(Request request) {
        request.getAuth();
        return new Response(200,"OK","Create account");
    }
}
