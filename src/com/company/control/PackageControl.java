package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Post;
import com.company.model.card.AbstractCard;
import com.company.model.card.MonsterCard;
import com.company.server.Request;
import com.company.server.Response;

public class PackageControl implements Post, Get {
    @Override
    public Response post(Request request) {

        if(!request.getAuth().equals("admin-mtcgToken")){
            return new Response(400,"BAD","NOT ALLOWED");
        };







        return new Response(400,"BAD","EMPTY");

    }

    @Override
    public Response get(Request request) {
        return new Response(400,"BAD","EMPTY");
    }
}
