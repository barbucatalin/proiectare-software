package laborator7.util;

import java.util.Random;

public class PasswordMaker {

    private static PasswordMaker instance = null;

    private static int callingCount = 0;

    private String magicString;

    private PasswordMaker() {
        this.magicString = StringRandomizer.getRandomString(10);
    }

    public static PasswordMaker getInstance() {
        callingCount++;

        if (instance == null) {
            instance = new PasswordMaker();
        }

        return instance;
    }

    public static int getCallingCounts() {
        return callingCount;
    }

    public String getPassword() {
        Random rand = new Random();

        int randomLength = rand.nextInt(6) + 5;

        String randomPart = StringRandomizer.getRandomString(randomLength);

        return magicString + "_" + randomPart;
    }
}