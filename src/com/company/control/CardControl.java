package com.company.control;

import com.company.control.respository.Get;
import com.company.db.StackDB;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CardControl implements Get {
    private Gson gson = new Gson();


    @Override
    public Response get(Request request) {
        String userid = request.getAuth();
        StackDB stackdb = new StackDB();
        if(stackdb.getAllCardsFromUser(userid) == null){
            return new Response(400,"BAD","BAD");
        };

        ArrayList<String> cards = stackdb.getAllCardsFromUser(userid).getCardIdList();

        if(cards == null){
            return new Response(400,"BAD","BAD");
        };


        return new Response(200,"OK",cards.toString());
    }
}
