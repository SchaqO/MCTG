package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Post;
import com.company.db.CardDB;
import com.company.db.PackageDB;
import com.company.model.Packages;
import com.company.model.card.*;
import com.company.server.Request;
import com.company.server.Response;

import java.util.ArrayList;

public class PackageControl implements Post, Get {
    @Override
    public Response post(Request request) {

        if(!request.getAuth().equals("admin-mtcgToken")){
            return new Response(400,"BAD","Created");
        };

        ArrayList<String> CardIdList = new ArrayList<>();
        CardDB carddb = new CardDB();
        for(int i = 0; i < 5; i++){
            AbstractCard abstractCard = new MonsterCard("id", CardName.valueOf("Dragon"), Integer.valueOf("10"), CardElement.valueOf("Fire"));
            carddb.addItem(abstractCard);
            CardIdList.add(abstractCard.getCardID());
        }
        PackageDB packagedb = new PackageDB();
        Packages packages = Packages.builder()
                .id("1")
                .cardId1(CardIdList.get(0))
                .cardId2(CardIdList.get(1))
                .cardId3(CardIdList.get(2))
                .cardId4(CardIdList.get(3))
                .cardId5(CardIdList.get(4))
                .build();
        packagedb.addItem(packages);






        return new Response(400,"BAD","EMPTY");

    }

    @Override
    public Response get(Request request) {
        return new Response(400,"BAD","EMPTY");
    }
}
