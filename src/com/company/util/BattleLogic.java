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

    public Battle battleStart(Battle battle) {


        ArrayList<AbstractCard> deckA = new ArrayList<>();
        ArrayList<AbstractCard> deckB = new ArrayList<>();

        User userA = battle.getPlayer1();
        User userB = battle.getPlayer2();
        UserDB userDB = new UserDB();
        CardDB cardDB = new CardDB();

        if (userA.getDeck() == null) {
            return null;
        }
        if (userB.getDeck() == null) {
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


        int count = 0;
        int PlayerA = 0;
        int PlayerB = 100;

        int deckANum = 0;
        int deckBNum = 0;


        while (count < 101) {

            if (deckA.size() == 0) {
                break;
            }

            if (deckB.size() == 0) {
                break;
            }

            HashGenerator gene = new HashGenerator();
            // randoGenerator  -->  zahl A
            deckANum = gene.randomDeckNumber(deckA.size() - 1);

            // randoGenerator  -->  zahl B
            deckBNum = gene.randomDeckNumber(deckB.size() - 1);





            while (true) {


                if (deckA.get(deckANum).getCardElement().equals(CardElement.WATER) && deckB.get(deckBNum).getCardElement().equals(CardElement.FIRE)) {
                    //loggerBattle.logMsg("Water is more effective against water");
                    if ((deckA.get(deckANum).getCardDmg() * 2) > (deckB.get(deckBNum).getCardDmg() / 2)) {
                        deckA.add(deckB.get(deckBNum));
                        deckB.remove(deckBNum);
                        PlayerA++;
                        break;
                    }
                    if ((deckA.get(deckANum).getCardDmg() * 2) < (deckB.get(deckBNum).getCardDmg() / 2)) {
                        deckB.add(deckA.get(deckANum));
                        deckA.remove(deckANum);
                        PlayerB++;
                        break;
                    }
                }
                if (deckB.get(deckBNum).getCardElement() == CardElement.WATER && deckA.get(deckANum).getCardElement() == CardElement.FIRE) {
                    loggerBattle.logMsg("Water is more effective against water");
                    if ((deckB.get(deckBNum).getCardDmg() * 2) > (deckA.get(deckANum).getCardDmg() / 2)) {
                        deckB.add(deckA.get(deckANum));
                        deckA.remove(deckANum);
                        PlayerB++;
                        break;
                    }
                    if ((deckB.get(deckBNum).getCardDmg() * 2) < (deckA.get(deckANum).getCardDmg() / 2)) {
                        deckA.add(deckB.get(deckBNum));
                        deckB.remove(deckBNum);
                        PlayerA++;
                        break;
                    }
                }

                if (deckA.get(deckANum).getCardElement() == CardElement.NORMAL && deckB.get(deckBNum).getCardElement() == CardElement.WATER) {
                    loggerBattle.logMsg("Water has no effect on neutrality, normal wins.");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckB.get(deckBNum).getCardElement() == CardElement.NORMAL && deckA.get(deckANum).getCardElement() == CardElement.WATER) {
                    loggerBattle.logMsg("Water has no effect on neutrality, normal wins.");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }

                if (deckA.get(deckANum).getCardElement() == CardElement.FIRE && deckB.get(deckBNum).getCardElement() == CardElement.NORMAL) {
                    loggerBattle.logMsg("Fire is better than nothing! Fire wins.");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckB.get(deckBNum).getCardElement() == CardElement.FIRE && deckA.get(deckANum).getCardElement() == CardElement.NORMAL) {
                    loggerBattle.logMsg("Fire is better than nothing! Fire wins.");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }


                if (deckA.get(deckANum).getCardName() == CardName.Dragon && deckB.get(deckBNum).getCardName() == CardName.Goblin) {
                    loggerBattle.logMsg("Goblins cannot attack Dragons because they are too afraid.");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckB.get(deckBNum).getCardName() == CardName.Dragon && deckA.get(deckANum).getCardName() == CardName.Goblin) {
                    loggerBattle.logMsg("Goblins cannot attack Dragons because they are too afraid.");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }

                if (deckA.get(deckANum).getCardName() == CardName.Wizard && deckB.get(deckBNum).getCardName() == CardName.Ork) {
                    loggerBattle.logMsg("Ork cannot damage Wizard because he is being controlled.");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckB.get(deckBNum).getCardName() == CardName.Wizard && deckA.get(deckANum).getCardName() == CardName.Ork) {
                    loggerBattle.logMsg("Ork cannot damage Wizard because he is being controlled.");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }

                if (deckA.get(deckANum).getCardName() == CardName.WaterSpell && deckB.get(deckBNum).getCardName() == CardName.Knight) {
                    loggerBattle.logMsg("Knights armor is too heavy so he is drowning in water.");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckB.get(deckBNum).getCardName() == CardName.WaterSpell && deckA.get(deckANum).getCardName() == CardName.Knight) {
                    loggerBattle.logMsg("Knights armor is too heavy so he is drowning in water.");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }

                if (deckA.get(deckANum).getCardName() == CardName.Kraken && deckB.get(deckBNum).getCardtype().toString().contains("Spell")) {
                    loggerBattle.logMsg("Spells have no effect on Kraken.");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckB.get(deckBNum).getCardName() == CardName.Kraken && deckA.get(deckANum).getCardtype().toString().contains("Spell")) {
                    loggerBattle.logMsg("Spells have no effect on Kraken.");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }

                if (deckA.get(deckANum).getCardName() == CardName.FireElves && deckB.get(deckBNum).getCardName() == CardName.Dragon) {
                    loggerBattle.logMsg("Knights armor is too heavy so he is drowning in water.");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckB.get(deckBNum).getCardName() == CardName.FireElves && deckA.get(deckANum).getCardName() == CardName.Dragon) {
                    loggerBattle.logMsg("Knights armor is too heavy so he is drowning in water.");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }



                if (deckA.get(deckANum).getCardDmg() == deckB.get(deckBNum).getCardDmg()) {
                    loggerBattle.logMsg("Same power! Both players get a point");
                    PlayerA++;
                    PlayerB++;
                }
                if (deckA.get(deckANum).getCardDmg() > deckB.get(deckBNum).getCardDmg()) {
                    loggerBattle.logMsg("PlayerA has more damage. Point to PlayerA");
                    deckA.add(deckB.get(deckBNum));
                    deckB.remove(deckBNum);
                    PlayerA++;
                    break;
                }
                if (deckA.get(deckANum).getCardDmg() < deckB.get(deckBNum).getCardDmg()) {
                    loggerBattle.logMsg("PlayerB has more damage. Point to PlayerB");
                    deckB.add(deckA.get(deckANum));
                    deckA.remove(deckANum);
                    PlayerB++;
                    break;
                }

                PlayerA++;
                PlayerB++;
                break;
            }



        count++;

    }

        //GEWINNER WIRD ENTSCHIEDEN
        battle.setRound(count);
        if(PlayerA > PlayerB){
            battle.setWinner(battle.getPlayer1());
            userA.setElo(userA.getElo() + 10);
            userB.setElo(userB.getElo() - 5);
            loggerBattle.logMsg("WINNER "+userA.getUsername());
        }else{
            battle.setWinner(battle.getPlayer2());
            userB.setElo(userB.getElo() + 10);
            userA.setElo(userA.getElo() - 5);
            loggerBattle.logMsg("WINNER "+userB.getUsername());
        }

        userDB.update(userB);
        userDB.update(userA);
        battle.setPlayer1(userA);
        battle.setPlayer2(userB);



            return battle;
    }

}
