package com.company.control;

import com.company.control.respository.Post;
import com.company.server.Request;
import com.company.server.Response;

public class BattleControl implements Post {
    @Override
    public Response post(Request request) {
        return new Response(400,"BAD","EMPTY");

    }


}
