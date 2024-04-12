package org.harald;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 4200;
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: "+currentDirectory);

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // server.createContext("/", exchange -> {
        //             String path = "src/main/resources/static/index.html";
        //             File file = new File(path);
        //
        //             if (file.exists() && file.isFile()) {
        //                 String contentType = Files.probeContentType(file.toPath());
        //                 exchange.getResponseHeaders().set("Content-Type", contentType);
        //                 // System.out.println(contentType);
        //                 // exchange.getResponseHeaders().set("Content-Type", "text/html");
        //                 // exchange.getResponseHeaders().set("Content-Type", "application/javascript");
        //
        //                 exchange.sendResponseHeaders(200, file.length());
        //
        //                 try (OutputStream outputStream = exchange.getResponseBody()) {
        //                     Files.copy(file.toPath(), outputStream);
        //                 }
        //             } else {
        //                 String response = "File not found";
        //                 exchange.sendResponseHeaders(404, response.length());
        //                 try (OutputStream outputStream = exchange.getResponseBody()) {
        //                     outputStream.write(response.getBytes());
        //                 }
        //             }
        //         });

            server.createContext("/", exchange -> {
                System.out.println("Receiving request");
                String path = exchange.getRequestURI().getPath();
                if (path.equals("/")) {
                    path = "/index.html";
                }
                path = "src/main/resources/static" + path;

                System.out.println(path);
                File file = new File(path);

                if (file.exists() && file.isFile()) {
                    String contentType = Files.probeContentType(file.toPath());
                    exchange.getResponseHeaders().set("Content-Type", contentType);
                    // System.out.println(contentType);
                    // exchange.getResponseHeaders().set("Content-Type", "text/html");
                    // exchange.getResponseHeaders().set("Content-Type", "application/javascript");

                    exchange.sendResponseHeaders(200, file.length());

                    try (OutputStream outputStream = exchange.getResponseBody()) {
                        Files.copy(file.toPath(), outputStream);
                    }
                } else {
                    String response = "File not found";
                    exchange.sendResponseHeaders(404, response.length());
                    try (OutputStream outputStream = exchange.getResponseBody()) {
                        outputStream.write(response.getBytes());
                    }
                }
        });

        server.start();
        System.out.println("Server started on port " + port);
    }


}