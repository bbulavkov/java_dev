package org.example.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response {
    int statusCode;

    String statusString;
    String protocol;

    Map<String, String> headers = new LinkedHashMap<>();

    String body;

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");

        stringJoiner.add(protocol + " " + statusCode + " " + statusString);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            stringJoiner.add(entry.getKey() + ": " + entry.getValue());
        }

        stringJoiner.add("");
        stringJoiner.add(body);

        return stringJoiner.toString();
    }
}
