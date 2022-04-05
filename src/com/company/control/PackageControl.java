package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Post;
import com.company.db.CardDB;
import com.company.db.PackageDB;
import com.company.model.Packages;
import com.company.model.card.AbstractCard;
import com.company.model.card.CardElement;
import com.company.model.card.CardType;
import com.company.model.card.MonsterCard;
import com.company.server.Request;
import com.company.server.Response;
import com.company.util.HashGenerator;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class PackageControl implements Post, Get {

    HashGenerator hash = new HashGenerator();
    String hashID = hash.hashString();

    Gson gson;
    public PackageControl() {
        this.gson = new Gson();
    }

    @Override
    public Response post(Request request) {

        if(!request.getAuth().equals("admin-mtcgToken")) {
            return new Response(400, "BAD", "NO ADMIN");
        };

        CardDB cardDB = new CardDB();

        String bodyString = request.getBody();
        JsonElement bodyElements = new JsonParser().parse(bodyString);
        JsonArray bodyCards = bodyElements.getAsJsonArray();
        ArrayList<AbstractCard> cardList = new ArrayList<>();
        AbstractCard cardInsert;
        ArrayList<String> cardIDs = new ArrayList<>();


        for(int i = 0; i < bodyCards.size();i++){
            cardInsert = gson.fromJson(bodyCards.get(i),MonsterCard.class);

            if(cardInsert.getCardName().toString().matches("Water(.*)")){
                cardInsert.setCardElement(CardElement.WATER);
            }

            else if(cardInsert.getCardName().toString().matches("Fire(.*)")) {
                cardInsert.setCardElement(CardElement.FIRE);
            }else{
                cardInsert.setCardElement(CardElement.NORMAL);
            }

            if(cardInsert.getCardName().toString().matches("(.*)Spell(.*)")){
                cardInsert.setCardtype(CardType.SPELL);
            }else{
                cardInsert.setCardtype(CardType.MONSTER);
            }

             cardList.add(cardInsert);
             cardDB.addItem(cardInsert);
             cardIDs.add(cardInsert.getCardID());

        }

        Packages packages = Packages.builder()
                .id(hashID)
                .cardIdPackage(cardIDs)
                .build();


        PackageDB packageDB = new PackageDB();
        packageDB.addItem(packages);




        return new Response(400,"BAD","PACKAGE CREATED");

    }

    @Override
    public Response get(Request request) {
        return new Response(400,"BAD","EMPTY");
    }
}
