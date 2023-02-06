package org.example.notes.util;

public class AgeGenerator {

    public static int[] getRandomNumbers(int count) {
        int min = 0;
        int max = 100;
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {

            result[i] = (int) ((Math.random() * (max - min)) + min);
        }
        return result;
    }
}
