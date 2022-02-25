package com.company.control;

import com.company.control.respository.Get;
import com.company.db.UserDB;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;

public class StatControl implements Get {

    @Override
    public Response get(Request request) {

        if(request.getAuth() == ""){
            return new Response(400,"BAD","NO TOKEN");
        }

        UserDB userDB = new UserDB();
        User user = userDB.getItemByToken(request.getAuth());

        if(user == null){
            return new Response(400,"BAD","Show Stats here");
        }else{
            return new Response(200,"OK",user.isStatus()+"");
        }
    }
}
