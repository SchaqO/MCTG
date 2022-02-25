package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Post;
import com.company.db.ProfileDB;
import com.company.db.UserDB;
import com.company.model.Profile;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

import javax.xml.namespace.QName;

//9.
public class UserControl implements Post, Get {


    private Gson gson = new Gson();

    // REGISTER
    @Override
    public Response post(Request request) {

        //10.
        // BODY --> JSON <-> JAVA OBJ

        User jsonUser = gson.fromJson(request.getBody(), User.class);

        if(jsonUser == null){
            return new Response(400,"BAD","FAILED");
        }

        User newUser = User.builder()
                .userToken(jsonUser.getUsername()+"-mtcgToken")
                .username(jsonUser.getUsername())
                .password(jsonUser.getPassword())
                .build();

        //11.
        //DATABASE
        UserDB userDB = new UserDB();

        // WENN ES SCHON EINEN EINTRAG GIBT
        if(userDB.getItemByToken(newUser.getUserToken())!= null){ return new Response(400,"BAD","FAILED");}


        //12. FINAL
        // JAVA OBJ --> DATABASE
        if(userDB.addItem(newUser) == null){
            return new Response(400,"BAD","FAILED");
        }else{
            Profile profile = Profile.builder()
                    .userToken(newUser.getUserToken())
                    .name(newUser.getUsername())
                    .build();
            ProfileDB profileDB = new ProfileDB();
            profileDB.addItem(profile);
            return new Response(200,"OK","Create account");
        }

    }

    @Override
    public Response get(Request request) {
        return new Response(400,"BAD","FAILED");
    }

}

