package org.example.util;

public class RandomNumberGenerator {

    public static int[] generate(int count) {

        int min = 0;
        int max = 120;

        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = (int) ((Math.random() * (max - min)) + min);
        }
        return numbers;
    }
}
