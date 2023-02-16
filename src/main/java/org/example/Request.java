package org.example;

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

    enum Method {
        GET,
        POST
    }

}
