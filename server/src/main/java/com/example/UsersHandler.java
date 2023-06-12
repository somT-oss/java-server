package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UsersHandler implements HttpHandler {

    public List<Hashtable<String, String>> users() {
        
        List<Hashtable<String, String>> list = new ArrayList<Hashtable<String, String>>();
        Hashtable<String, String> dict = new Hashtable<String, String>();
        dict.put("name", "Somto");
        dict.put("age", "22");
        dict.put("class", "year2");
        list.add(dict);
        return list;
    
    }
    public void handle(HttpExchange exchange ) throws IOException {
        String response = "This is my test page";
        exchange.getResponseHeaders();
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
    
}
