package net.ptnkjke.utils;

import java.util.Random;

/**
 * Created by dalopatin on 07.07.2014.
 */
public class Utils {

    public static String getRandomName() {
        String alpha = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            int num = r.nextInt(15);
            sb.append(alpha.charAt(num));
        }

        return sb.toString();
    }
}
