package com.company.util;

import com.company.db.CardDB;
import com.company.db.UserDB;
import com.company.model.Battle;
import com.company.model.Deck;
import com.company.model.User;
import com.company.model.card.AbstractCard;

import java.util.ArrayList;

public class BattleLogic {

    public Battle start(Battle battle) {
        return this.battleStart(battle);
    }

    public Battle battleStart(Battle battle){


    ArrayList<AbstractCard> deckA = new ArrayList<>();
    ArrayList<AbstractCard> deckB = new ArrayList<>();

    User userA = battle.getPlayer1();
    User userB = battle.getPlayer2();
    UserDB userDB = new UserDB();
    CardDB cardDB = new CardDB();

    if(userA.getDeck() == null){
        return null;
    }
    if(userB.getDeck() == null){
        return null;
    }

        deckA.add(cardDB.getItemByToken(userA.getDeck().getCardId1()));
        deckA.add(cardDB.getItemByToken(userA.getDeck().getCardId2()));
        deckA.add(cardDB.getItemByToken(userA.getDeck().getCardId3()));
        deckA.add(cardDB.getItemByToken(userA.getDeck().getCardId4()));


        deckB.add(cardDB.getItemByToken(userA.getDeck().getCardId1()));
        deckB.add(cardDB.getItemByToken(userA.getDeck().getCardId2()));
        deckB.add(cardDB.getItemByToken(userA.getDeck().getCardId3()));
        deckB.add(cardDB.getItemByToken(userA.getDeck().getCardId4()));


        String nameA = deckB.get(0).getCardName().toString();
        String nameB = deckA.get(0).getCardName().toString();

        if(nameA == "DRAGON" && nameB == "ORK"){
            //logic
        }






        return null;

    }
}
