package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Post;
import com.company.db.UserDB;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

public class UserControl implements Post, Get {


    private Gson gson = new Gson();

    // Login
    @Override
    public Response post(Request request) {

        // BODY --> JSON <-> JAVA OBJ
        User newUser = gson.fromJson(request.getContent(), User.class);


        // JAVA OBJ --> DATABASE
        UserDB userDB = new UserDB();
        userDB.addItem(newUser);

        // CHECK USER - DATABASE
        if(userDB.getItemByToken(newUser + "mtcg-token") != null){
         return null;

        }else{
            return null;
        }
    }

    @Override
    public Response get(Request request) {

        request.getContent();
        System.out.println(request.getContent());
        //gson.fromJson("{}",User.class);
        User newUser = gson.fromJson(request.getContent(), User.class);

        System.out.println(newUser.getUsername());
        System.out.println("test");
        return null;
    }

}

