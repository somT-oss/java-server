package com.example;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.HttpServer;



public class App {  

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
    
    Integer port = 9000;

    try {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", port), 0);    
        server.createContext("/", new RootHandler());
        server.createContext("/get", new EchoGetHandler());
        server.createContext("/post", new EchoPostHandler());
        server.start();

    } catch (Exception e) {
        e.printStackTrace();
    }; 

    UsersHandler newUser = new UsersHandler();

    System.out.println(newUser.users());
    
    logger.info("Server has started on port: " + port);

    }

}
