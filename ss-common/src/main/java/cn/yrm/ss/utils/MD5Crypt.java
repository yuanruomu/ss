package cn.yrm.ss.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Crypt {

    public static String encode(String s) {
        return encode(s, "");
    }

    public static String encode(String s, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] bytes = digest.digest(salt.getBytes());

            StringBuffer buf = new StringBuffer(bytes.length * 2);
            for (int i = 0; i < bytes.length; i++) {
                if (((int) bytes[i] & 0xff) < 0x10) {
                    buf.append("0");
                }
                buf.append(Long.toString((int) bytes[i] & 0xff, 16));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
            return null;
        }
    }
}
