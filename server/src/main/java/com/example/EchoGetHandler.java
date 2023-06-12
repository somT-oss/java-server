package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class EchoGetHandler implements HttpHandler {
    @Override

    public void handle(HttpExchange he) throws IOException {
        
        // parse request
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        URI requestedURI = he.getRequestURI();
        String query = requestedURI.getQuery();

        // pattern for accessing static method from ParseQuery class
        ParseQuery.parseQuery(query, parameters);

        // send response
        String response = "";
        for (String key : parameters.keySet()) {
            response += key + " = " + parameters.get(key) + "\n";
        }
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.toString().getBytes());

        os.close();
    }
    
}
