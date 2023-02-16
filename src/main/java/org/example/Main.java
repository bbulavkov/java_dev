package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.util.FileUtils.getHtmlPageByPath;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1000);
        System.out.println("Server started");

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connection received");

            executorService.submit(() -> handleConnection(socket));
        }
    }

    private static void handleConnection(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();

            String requestString = read(inputStream);
            System.out.println("Request string \n" + requestString);

            Request request = RequestParser.parse(requestString);
            System.out.println("Parsed request " + request);

            Response response = new Response();

            response.setStatusCode(200);
            response.setStatusString("Ok");
            response.setProtocol("HTTP/1.1");

            String body = "";

            try {
                body = getHtmlPageByPath(request.getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();

                response.setStatusCode(404);
                response.setStatusString("Not found");
            }

            response.setBody(body);

            Map<String, String> headers = new LinkedHashMap<>();
            headers.put("Content-Type", "text/html; charset=utf-8");
            headers.put("Content-Length", response.getBody().getBytes(StandardCharsets.UTF_8) + "");
            response.setHeaders(headers);

            System.out.println("Created response \n" + response);

            try (OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write(response.toString().getBytes(StandardCharsets.UTF_8));
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String read(InputStream inputStream) throws IOException, InterruptedException {
        Thread.sleep(100);

        byte[] buffer = new byte[1024 * 20];
        int len = 0;
        while (inputStream.available() > 0) {
            System.out.println("Got some bytes to process " + inputStream.available());

            int readBytes = inputStream.read(buffer, len, inputStream.available());
            len += readBytes;
            Thread.sleep(100);
        }
        return new String(buffer, 0, len);
    }
}