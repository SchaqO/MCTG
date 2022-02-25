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
            return new Response(400,"BAD","NO PROFILE");
        }


        return new Response(200,"OK",profile.getImage() + " " + profile.getDescription() + " " +profile.getName());
    }

    @Override
    public Response put(Request request) {
        request.getAuth();
        //System.out.println(request.getBody());
        return new Response(200,"OK","User edited");
    }
}
