package org.example.notes.util;

import com.github.javafaker.Faker;

public class NamesGenerator {
    public static String[] generateRandomNames(int count) {
        String[] res = new String[count];

        for (int i = 0; i < count; i++) {
            Faker faker = new Faker();
            String fullName = faker.name().fullName();
            res[i] = fullName;
        }
        return res;
    }
}
