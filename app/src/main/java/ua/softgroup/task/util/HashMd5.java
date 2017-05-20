package ua.softgroup.task.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Слава on 19.05.2017.
 */

public class HashMd5 {

    public static String makeHash(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(str.getBytes());
        BigInteger bigInt = new BigInteger(1, digest.digest());
        str = bigInt.toString(16);

        while(str.length() < 32 ){
            str = "0" + str;
        }
        return str;
    }
}
