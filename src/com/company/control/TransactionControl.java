package com.company.control;

import com.company.control.respository.Post;
import com.company.db.*;
import com.company.model.Packages;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;

public class TransactionControl implements Post {

    @Override
    public Response post(Request request) {


        if(request.getAuth().equals("")){
            return new Response(400, "BAD", "NO TOKEN");
        }

        UserDB userDB = new UserDB();
        TransactionDB tradingDB = new TransactionDB();
        PackageDB packageDB = new PackageDB();
        User user = userDB.getItemByToken(request.getAuth());
        Packages pack = packageDB.getItemByToken(tradingDB.getFirstItem());
        StackDB stackDB = new StackDB();


        if(user == null ){
            return new Response(400, "BAD", "NO USER");
        }

        if(pack == null ){
            return new Response(400, "BAD", "NO PACKAGE");
        }

        stackDB.addCardToStack(user.getUserToken(),pack.getCardId1());
        stackDB.addCardToStack(user.getUserToken(),pack.getCardId2());
        stackDB.addCardToStack(user.getUserToken(),pack.getCardId3());
        stackDB.addCardToStack(user.getUserToken(),pack.getCardId4());
        stackDB.addCardToStack(user.getUserToken(),pack.getCardId5());
        packageDB.deleteItemById(pack.getId());

        return new Response(200, "OK", "SOLD");
    }
}