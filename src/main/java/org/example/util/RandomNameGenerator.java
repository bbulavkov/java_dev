package org.example.util;

import com.github.javafaker.Faker;

public class RandomNameGenerator {
    public static String[] generate(int count) {
        String[] names = new String[count];

        for (int i = 0; i < count; i++) {
            Faker faker = new Faker();
            String fullName = faker.name().fullName();
            names[i] = fullName;
        }

        return names;
    }
}
