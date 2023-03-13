package org.example.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

import java.util.List;

@Convert
public class AccountTypesToStringConverter implements
        AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return new Gson().toJson(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return new Gson().fromJson(dbData,
                new TypeToken<List<String>>() {
                }.getType());
    }
}
