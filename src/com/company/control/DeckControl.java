package com.company.control;

import com.company.control.respository.Get;
import com.company.db.UserDB;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

public class DeckControl implements Get {

    private Gson gson = new Gson();

    // REGISTER
    @Override
    public Response get(Request request) {

            request.getAuth();


            return new Response(200,"OK","Create account");


    }

}
