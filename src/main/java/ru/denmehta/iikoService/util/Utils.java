package ru.denmehta.iikoService.util;

import java.util.Random;

public class Utils {

    public static String generateCode(int length) {
        Random random = new Random();
        String code = "";

        for (int i = 0; i < length; i++) {
            code += random.nextInt(10);
        }
        return code;
    }
}
