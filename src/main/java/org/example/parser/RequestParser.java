package org.example.parser;

import org.example.dto.Request;

import java.util.StringJoiner;

public class RequestParser {

    public static Request parse(String requestString) {
        Request request = new Request();
        String[] lines = requestString.split("\n");

        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace("\r", "");
        }

        String startingLine = lines[0];

        parseStartingLine(startingLine, request);


        for (int i = 1; i < lines.length; i++) {
            String currentLine = lines[i];

            if (currentLine.equals("")) {
                parseBody(lines, request, i);
            } else {
                parseHeaders(currentLine, request);
            }
        }

        return request;
    }

    private static void parseBody(String[] lines, Request request, int currentIndex) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (int i = currentIndex; i < lines.length; i++) {
            stringJoiner.add(lines[i]);
        }
        request.setBody(stringJoiner.toString());
    }

    private static void parseHeaders(String line, Request request) {
        String[] keyValuePair = line.split(": ");

        request.getHeaders().put(
                keyValuePair[0],
                keyValuePair[1]);

    }


    private static void parseStartingLine(String startingLine, Request request) {
        String[] split = startingLine.split(" ");

        request.setMethod(Request.Method.valueOf(split[0]));
        request.setPath(split[1]);
        request.setProtocol(split[2]);
    }
}
