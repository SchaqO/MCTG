package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Put;
import com.company.db.DeckDB;
import com.company.db.UserDB;
import com.company.model.Deck;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

public class DeckControl implements Get, Put {

    private Gson gson = new Gson();



    @Override
    public Response get(Request request) {
        String userID = request.getAuth();

        UserDB userDB = new UserDB();
        if(userDB.getItemByToken(userID) == null){
            return new Response(400,"BAD","NO USER");
        }
        DeckDB deckDB = new DeckDB();
        Deck currentDeck = deckDB.getItemByToken(userID);


        if(currentDeck == null){
            return new Response(400,"BAD","NO DECK");
        }


        return new Response(200,"OK",currentDeck.toString());
    }

    @Override
    public Response put(Request request) {
        String userID = request.getAuth();

        UserDB userDB = new UserDB();
        if(userDB.getItemByToken(userID) == null){
            return new Response(400,"BAD","NO USER");
        }

        if(request.getBody() == null){
            return new Response(400,"BAD","NO USER");
        }

        String[] data = request.getBody().replace("[","").replace("]","").replace(" ","").replace("\"","").split(",");

        if(data.length < 4){
            return new Response(400,"BAD","DECK -NO 4 ");
        }
        DeckDB deckDB = new DeckDB();
        Deck deck = Deck.builder()
                .userToken(userID)
                .cardId1(data[0])
                .cardId2(data[1])
                .cardId3(data[2])
                .cardId4(data[3])
                .build();

        deck = deckDB.addItem(deck);
        if(deck == null){
            return new Response(400,"BAD","NO DECK");
        }

        return new Response(200,"OK","Configure Deck SUC");
    }

}
