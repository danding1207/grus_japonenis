package com.msc.lib.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by msc on 2016/8/3.
 */

public class EncryptUtils {

    private EncryptUtils() {
        throw new UnsupportedOperationException("u don't need creat me...");
    }

    /**
     * MD5加密
     */
    public static String encryptMD5(String data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return new BigInteger(md5.digest(data.getBytes())).toString(16);
    }

    /**
     * SHA加密
     */
    public static String encryptSHA(String data) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        return new BigInteger(sha.digest(data.getBytes())).toString(32);
    }

}
