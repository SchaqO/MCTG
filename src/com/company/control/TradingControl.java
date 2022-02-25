package com.company.control;

import com.company.control.respository.Delete;
import com.company.control.respository.Get;
import com.company.control.respository.Post;
import com.company.db.UserDB;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;

public class TradingControl implements Get, Post, Delete {


    @Override
    public Response post(Request request) {
        return new Response(400,"BAD","EMPTY");

    }

    @Override
    public Response get(Request request) {
        request.getAuth();
        return new Response(200,"OK","Trade deal checked");
    }

    @Override
    public Response delete(Request request) {
        request.getAuth();
        return new Response(200,"OK","Trade deleted");
    }


}
