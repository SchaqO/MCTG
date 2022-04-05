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
        String userID = request.getAuth();
        if(userID == null){
            return new Response(400,"BAD","NO AUTH");
        }

        if(request.getAuth().equals("")){
            return new Response(400, "BAD", "NO TOKEN");
        }



        PackageDB packageDB = new PackageDB();
        UserDB userDB = new UserDB();

        if(userDB.getItemByToken(request.getAuth()) == null ){
            return new Response(400, "BAD", "NO USER");
        }

        if(packageDB.getAllPackages() == null) {
            return new Response(400, "BAD", "NO PACKAGE");
        }

        if(packageDB.getAllPackages().size() == 0) {
            return new Response(400, "BAD", "NO PACKAGE");
        }

     packageDB.sellPackage(request.getAuth(),packageDB.getAllPackages().get(0).getId());


        return new Response(200, "OK", "SOLD");
    }
}