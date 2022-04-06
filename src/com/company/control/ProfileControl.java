package com.company.control;

import com.company.control.respository.Get;
import com.company.control.respository.Put;
import com.company.db.ProfileDB;
import com.company.db.UserDB;
import com.company.model.Profile;
import com.company.model.User;
import com.company.server.Request;
import com.company.server.Response;
import com.google.gson.Gson;

public class ProfileControl implements Get, Put{
    private Gson gson = new Gson();

    @Override
    public Response get(Request request) {
        ProfileDB profileDB = new ProfileDB();

        Profile profile = profileDB.getItemByToken(request.getAuth());

        if(profile == null){
            return new Response(400,"BAD","NO PROFILE INFORMATION YET");
        }

       /*if(!request.getRoute().contains(request.getAuth())){
            return new Response(400,"BAD","NO MATCHING TOKEN AND NAME");
        }*/
        String route = request.getRoute().replace("/users/","");
        String auth = request.getAuth().replace("-mtcgToken", "");
        if(!route.equals(auth)){
            return new Response(400,"BAD","NO MATCHING TOKEN AND NAME");
        }

        return new Response(200,"OK", profile.toString());
    }

    @Override
    public Response put(Request request) {
        UserDB userDB = new UserDB();
        String userID = request.getAuth();

        if(userDB.getItemByToken(userID) == null){
            return new Response(400,"BAD","NO PROFILE");
        }
        if(userID == null){
            return new Response(400,"BAD","NO AUTH");
        }

        Profile profile = gson.fromJson(request.getBody(), Profile.class);
        profile.setUserToken(userID);


        ProfileDB profileDB = new ProfileDB();

        profile = profileDB.update(profile);
        if(profile == null) {
            return new Response(400,"BAD","NO PROFILE");
        }


        //System.out.println(request.getBody());
        return new Response(200,"OK","User edited");
    }
}
