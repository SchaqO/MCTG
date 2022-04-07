package com.company.control;

import com.company.control.respository.Get;
import com.company.db.UserDB;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ScoreControl implements Get {


    @Override
    public Response get(Request request) {

        if(request.getAuth() == ""){
            return new Response(400,"BAD","NO TOKEN");
        }

        UserDB userDB = new UserDB();
        User user = userDB.getItemByToken(request.getAuth());

        if(user == null){
            return new Response(400,"BAD","Show score here");
        }else{
            return new Response(200,"OK",user.getElo()+"");
        }
    }

}
