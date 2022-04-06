package com.company.control;

import com.company.control.respository.Post;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

public class SessionControl implements Post {

    Gson gson = new Gson();

    @Override
    public Response post(Request request) {
     //   //10.
     //   // BODY --> JSON <-> JAVA OBJ
//
     //   User currentUser = gson.fromJson(request.getBody(), User.class);
//
     //   if(currentUser == null){
     //       return new Response(400,"BAD","FAILED");
     //   }
//
     //   //DATABASE
     //   UserDB userDB = new UserDB();
     //   currentUser = userDB.getItemByUsername(currentUser.getUsername(),currentUser.getPassword());
//
     //   // WENN ES SCHON EINEN EINTRAG GIBT
     //   if(currentUser == null){ return new Response(400,"BAD","USER NOT FOUND");}
     //   else{
            return new Response(200,"OK","t");
        }


}
