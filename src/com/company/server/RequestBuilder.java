package com.company.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//5. This takes the http request and changes it to variables for request (gives back request filled variables) for java to process further
public class RequestBuilder {

    public RequestBuilder(){}

    public Request build(BufferedReader in) {
        Request request = new Request();
        try {
        StringBuilder buffer = new StringBuilder();

        String inputLine;
        while (true) {

                if (!((inputLine = in.readLine()) != null && !inputLine.equals(""))) break;

            buffer.append(inputLine + "\n");
        }

        String header = buffer.toString();

            //System.out.println(header);
        if(header.contains("Authorization: Basic ")){
            String[] auth = header.split("Authorization: Basic ");
            request.setAuth(auth[1].replace(" ","").replace("\r","").replace("\n","@").split("@")[0]);

            //System.out.println(request.getAuth());
        }


        parseHeader(request, header);



        if (0 == request.getContentLength()) {
            return request;
        }



        char[] content = new char[request.getContentLength()];
        int read = in.read(content, 0, content.length);


        request.setBody(new String(content));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return request;
    }

    private static void parseHeader(Request request, String header) throws IOException {
        //System.out.println(header);

        parseMethodeAndRoute(request, header);
        // TODO parse parameters
        parseContentType(request, header);
        parseContentLength(request, header);
    }

    private static void parseMethodeAndRoute(Request request, String header) throws IOException {
        Pattern r = Pattern.compile("^([A-Z]+)\\s([^\\s]+)");
        Matcher m = r.matcher(header);

        if (!m.find()) {
            throw new IOException("No HTTP Request");
        }

        request.setMethod(m.group(1));
        request.setRoute(m.group(2));
    }




    private static void parseContentType(Request request, String header) {
        request.setContentType(getHttpHeader(header, "Content-Type"));
    }

    private static void parseContentLength(Request request, String header) {
        String contentLength = getHttpHeader(header, "Content-Length");

        if (null == contentLength) {
            return;
        }

        request.setContentLength(Integer.parseInt(contentLength));
    }

    private static String getHttpHeader(String header, String httpHeader) {
        Pattern r = Pattern.compile("^" + httpHeader + ":\\s(.+)", Pattern.MULTILINE);
        Matcher m = r.matcher(header);

        if (!m.find()) {
            return null;
        }

        return m.group(1);
    }
}
