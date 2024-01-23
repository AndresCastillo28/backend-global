package com.example.demo.utils;

import java.util.Random;

public class GuideNumberGenerator {

    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int GUIDE_NUMBER_LENGTH = 10;
    private static Random random = new Random();

    public static String generateGuideNumber() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < GUIDE_NUMBER_LENGTH; i++) {
            int characterIndex = random.nextInt(ALPHANUMERIC_STRING.length());
            builder.append(ALPHANUMERIC_STRING.charAt(characterIndex));
        }
        return builder.toString();
    }
}