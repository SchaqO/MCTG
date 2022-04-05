package com.company.control;

import com.company.control.respository.Post;
import com.company.db.DeckDB;
import com.company.db.StackDB;
import com.company.db.UserDB;
import com.company.model.Battle;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;

public class BattleControl implements Post {
    @Override
    public Response post(Request request) {
        String userID = request.getAuth();
        if(userID == null){
            return new Response(400,"BAD","NO AUTH");
        }

        UserDB userDB = new UserDB();
        DeckDB deckDB = new DeckDB();
        StackDB stackDB = new StackDB();

        User user =userDB.getItemByToken(userID);
        user.setDeck(deckDB.getItemByToken(userID));
        user.setStack(stackDB.getItemByToken(userID));


        System.out.println(user.toString());

        System.out.println("Battle Start");
        return new Response(400,"BAD","Show battle here");

    }


}
