package com.company.server;

public class Response {

    private int status;
    private String reasonPhrase;
    private String contentType;
    private String content;

    public Response(int status, String reasonPhrase, String message) {
        this.content = message;
        this.status = status;
        this.reasonPhrase = reasonPhrase;
        contentType = "application/json";
    }


    @Override
    public String toString() {
        return "HTTP/1.1 " + status + " " + reasonPhrase + "\r\n" +
                "Content-Type: " + contentType + "\r\n" +
                "Content-Length: " + content.length() + "\r\n" +
                "\r\n" +
                content;
    }
}
