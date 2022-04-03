package com.company.util;

import com.company.model.Battle;
import com.company.model.card.AbstractCard;

import java.util.ArrayList;

public class BattleLogic {

    public Battle start(Battle battle) {
        return this.battleStart(battle);
    }

    public Battle battleStart(Battle battle){
        ArrayList<String> deck1 = new ArrayList<>();
        String card1 = battle.getPlayer1().getDeck().getCardId1();
        String card2 = battle.getPlayer1().getDeck().getCardId2();
        String card3 = battle.getPlayer1().getDeck().getCardId3();
        String card4 = battle.getPlayer1().getDeck().getCardId4();
        deck1.add(card1);
        deck1.add(card2);
        deck1.add(card3);
        deck1.add(card4);

        ArrayList<String> deck2 = new ArrayList<>();
        String card11 = battle.getPlayer2().getDeck().getCardId1();
        String card22 = battle.getPlayer2().getDeck().getCardId2();
        String card33 = battle.getPlayer2().getDeck().getCardId3();
        String card44 = battle.getPlayer2().getDeck().getCardId4();
        deck2.add(card1);
        deck2.add(card2);
        deck2.add(card3);
        deck2.add(card4);


        return null;

    }
}
