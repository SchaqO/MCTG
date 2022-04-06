package com.company.util;

import com.company.db.CardDB;
import com.company.db.UserDB;
import com.company.model.Battle;
import com.company.model.Deck;
import com.company.model.User;
import com.company.model.card.AbstractCard;
import com.company.model.card.CardElement;
import com.company.model.card.CardName;
import com.company.model.card.CardType;

import java.util.ArrayList;

public class BattleLogic {

    LoggerBattle loggerBattle = LoggerBattle.getInstance();

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




    int dmgA = deckB.get(0).getCardDmg();
    int dmgB = deckA.get(0).getCardDmg();



    int count = 0;
    int Player1 = 0;
    int Player2 = 0;

    int deckANum = 0;
    int deckBNum = 0;
    while(count < 101) {







       if(deckA.size() == 0) {
       break;
       }

        if(deckB.size() == 0) {
            break;
        }

        // randoGenerator  -->  zahl A
        deckANum = 3;

        // randoGenerator  -->  zahl B
        deckBNum = 3;


        if (deckA.get(deckANum).getCardElement() == CardElement.WATER && deckB.get(deckBNum).getCardElement() == CardElement.FIRE) {
            loggerBattle.logMsg("Water is more effective against water");
            if ((dmgA * 2) > (dmgB / 2)) {
               deckA.add(deckB.get(deckBNum));
               Player1++;
            }
            if ((dmgA * 2) < (dmgB / 2)) {
                deckB.add(deckA.get(deckANum));
                Player2++;
            }
        }
    /*if(elementB == CardElement.WATER.toString() && elementA == CardElement.FIRE.toString()){
        loggerBattle.logMsg("Water is more effective against water");
        if((dmgB*2) > (dmgA/2)){
            //return dmgA;
        }
        if((dmgB*2) < (dmgA/2)){
            //return dmgB;
        }
        return null;
    }*/


        if (nameA == CardName.Goblin.toString() && nameB == CardName.Dragon.toString()) {
            loggerBattle.logMsg("Goblins cannot attack Dragons because they are too afraid.");
            //return nameB;
        }
        if (nameB == CardName.Goblin.toString() && nameA == CardName.Dragon.toString()) {
            loggerBattle.logMsg("Goblins cannot attack Dragons because they are too afraid.");
            //return nameA;
        }

        if (nameA == CardName.Wizard.toString() && nameB == CardName.Ork.toString()) {
            loggerBattle.logMsg("Wizards control orcs so Orks cannot damage Wizards.");
        }
        if (nameB == CardName.Wizard.toString() && nameA == CardName.Ork.toString()) {
            loggerBattle.logMsg("Wizards control orcs so Orks cannot damage Wizards.");
        }

        if (nameA == CardName.Knight.toString() && nameB == CardName.WaterSpell.toString()) {
            loggerBattle.logMsg("The Knight's armor is too heavy, he instantly drowns.");
        }
        if (nameB == CardName.Knight.toString() && nameA == CardName.WaterSpell.toString()) {
            loggerBattle.logMsg("The Knight's armor is too heavy, he instantly drowns.");
        }

        if (nameA == CardName.Kraken.toString() && nameB == CardType.SPELL.toString()) {
            loggerBattle.logMsg("Kraken is immune to spells.");
        }
        if (nameB == CardName.Kraken.toString() && nameA == CardType.SPELL.toString()) {
            loggerBattle.logMsg("Kraken is immune to spells.");
        }

        if (nameA == CardName.FireElves.toString() && nameB == CardName.Dragon.toString()) {
            loggerBattle.logMsg("FireElves knows the dragon and can therefore evade the attacks");
        }
        if (nameB == CardName.FireElves.toString() && nameA == CardName.Dragon.toString()) {
            loggerBattle.logMsg("FireElves knows the dragon and can therefore evade the attacks");
        }



        count++;
    }



if(Player1 > Player2){

    battle.setWinner(battle.getPlayer1());
}else{
    battle.setWinner(battle.getPlayer2());

}

        return battle;
    }






    public AbstractCard logic(AbstractCard card1, AbstractCard card2){
        /*if(card1 == CardName.Dragon.toString() && card2 == CardName.Goblin.toString()){
            loggerBattle.logMsg("Goblins are too afraid of Dragons to attack");
            return card1;
        }*/
        return null;
    }


}
