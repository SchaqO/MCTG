package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Put;
import com.company.db.UserDB;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

public class DeckControl implements Get, Put {

    private Gson gson = new Gson();


    @Override
    public Response get(Request request) {
        request.getAuth();
        return new Response(200,"OK","Create account");
    }

    @Override
    public Response put(Request request) {
        request.getAuth();
        return new Response(200,"OK","Create account");
    }

}
