package org.example.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request {

    Method method;
    String path;
    String protocol;

    Map<String, String> headers = new LinkedHashMap<>();

    String body;

    public enum Method {
        GET,
        POST
    }

}
