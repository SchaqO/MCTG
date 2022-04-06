package com.company.control;

import com.company.control.respository.Post;
import com.company.db.BattleDB;
import com.company.db.DeckDB;
import com.company.db.StackDB;
import com.company.db.UserDB;
import com.company.model.Battle;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;
import com.company.util.BattleLogic;

public class BattleControl implements Post {
    @Override
    public Response post(Request request) {
        String userID = request.getAuth();
        if(userID == null){
            return new Response(400,"BAD","NO AUTH");
        }

        BattleLogic battleLogic = new BattleLogic();

        UserDB userDB = new UserDB();
        DeckDB deckDB = new DeckDB();
        StackDB stackDB = new StackDB();

        User user = userDB.getItemByToken(userID);
        user.setDeck(deckDB.getItemByToken(userID));
        user.setStack(stackDB.getItemByToken(userID));
        Battle battle = Battle.builder()
                .player1(user)
                .player2(user)
                .build();

        System.out.println("Start Bat1");
        battle = battleLogic.battleStart(battle);



        return new Response(400,"BAD",battle.toString());

    }


}
