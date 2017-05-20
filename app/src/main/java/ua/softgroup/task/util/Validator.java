package ua.softgroup.task.util;

import java.util.regex.Pattern;

/**
 * Created by Слава on 19.05.2017.
 */

public class Validator {

    public static boolean validateEmail(String email) {
        String pattern = "^[0-9a-z_]+@[0-9a-z_]+\\.[a-z]{2,5}$";
        return Pattern.compile(pattern).matcher(email).matches();
    }

}
