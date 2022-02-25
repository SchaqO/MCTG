package com.test;

import com.company.server.ServerPort;
import com.company.server.Response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TestResponse")
public class TestResponse {

    Response response = new Response(20, "OK", "Test worked");

    @Test
    @DisplayName("testStatus")
    void testStatus(){
        assertEquals(20, response.getStatus());
    }

    @Test
    @DisplayName("testReasonPhrase")
    void testReasonPhrase(){
        assertEquals("OK", response.getReasonPhrase());
    }

    @Test
    @DisplayName("testMessage")
    void testMessage(){
        assertEquals("Test worked", response.getContent());
    }

    @Test
    @DisplayName("testContentType")
    void testContentType(){
        assertEquals("application/json", response.getContentType());
    }

}
