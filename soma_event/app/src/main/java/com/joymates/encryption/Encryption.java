package com.joymates.encryption;


import android.util.Base64;


/**
 * ProjectName：smallGoal
 * PackageName：com.guaiguaide.http
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/3/28 14:24
 * Remark：
 */
public class Encryption {

    private final static String PUBLIC_KEY = "www.funfan.com.sg20180909";

//    public static String encryption(String URL, String token, String time) {
//        String aesString = "";
//        if (token == null || "".equals(token)) {
//            aesString = URL;
//        } else {
//            aesString = URL + "|" + token;
//        }
//
//        String md5String = EncryptUtils.encryptMD5ToString(time, PUBLIC_KEY);
//
//        byte[] aes = EncryptUtils.encryptAES2Base64(aesString.getBytes(), md5String.getBytes(), "AES", null);
//        String s = new String(aes);
//        return s;
//    }

    public static String encryptionNow(String content) {
        String md5String = HashKit.md5(PUBLIC_KEY);

        byte[] encrypt = AesKit.encrypt(content, md5String);

        String encode = Base64.encodeToString(encrypt, Base64.NO_WRAP);
        return encode;
    }


    public static String encryptionNow(String URL, String token, String time) {
        String aesString = "";
        if (token == null || "".equals(token)) {
            aesString = URL;
        } else {
            aesString = URL + "|" + token;
        }
        String md5String = HashKit.md5(time + PUBLIC_KEY);

        byte[] encrypt = AesKit.encrypt(aesString, md5String);

        String encode = Base64.encodeToString(encrypt, Base64.NO_WRAP);
        return encode;
    }


    public static String encryption(String URL, String token, String md5) {
        String aesString = "";
        if (token == null || "".equals(token)) {
            aesString = URL;
        } else {
            aesString = URL + "|" + token;
        }
//        String md5String = HashKit.md5(time + PUBLIC_KEY);

        byte[] encrypt = AesKit.encrypt(aesString, md5);

        String encode = Base64.encodeToString(encrypt, Base64.NO_WRAP);
        return encode;
    }


}
