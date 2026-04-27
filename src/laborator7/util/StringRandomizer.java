package laborator7.util;

import java.util.Random;

public class StringRandomizer {

    private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString(int length) {
        Random rand = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        return result.toString();
    }
}