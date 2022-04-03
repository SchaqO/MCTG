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



        PackageDB packageDB = new PackageDB();
        UserDB userDB = new UserDB();

        if(userDB.getItemByToken(request.getAuth()) == null ){
            return new Response(400, "BAD", "NO USER");
        }

        // TODO: 04-Apr-22 TOKEN PACKAGE ArrayList --> mit allen PAckageIDs aus der Datenbank
        //  PackageDB -> Arraylist getAllPackgeIDs();
        if(packageDB.getItemByToken("123") == null ){
            return new Response(400, "BAD", "NO PACKAGE");
        }


        packageDB.sellPackage(request.getAuth(),"123");


        return new Response(200, "OK", "SOLD");
    }
}