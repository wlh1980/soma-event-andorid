package com.joymates.encryption;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;

import java.security.Provider;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.encryption
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/12 9:46
 * Remark：
 */
public class AndroidAESEncryptor {

    private static final String HEX = "0123456789ABCDEF";
    private static String CODING = "UTF-8";

    public AndroidAESEncryptor() {
    }

    public static String encrypt128(String seed, String cleartext, String coding) throws Exception {
        byte[] rawKey = getRawKey(128, seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes(TextUtils.isEmpty(coding) ? CODING : coding));
        return toHex(result);
    }

    public static String encrypt192(String seed, String cleartext, String coding) throws Exception {
        byte[] rawKey = getRawKey(192, seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes(TextUtils.isEmpty(coding) ? CODING : coding));
        return toHex(result);
    }

    public static String encrypt256(String seed, String cleartext, String coding) throws Exception {
        byte[] rawKey = getRawKey(256, seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes(TextUtils.isEmpty(coding) ? CODING : coding));
        return toHex(result);
    }

    public static String encrypt128(String seed, String cleartext) throws Exception {
        byte[] rawKey = getRawKey(128, seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes(CODING));
        return toHex(result);
    }

    public static String encrypt192(String seed, String cleartext) throws Exception {
        byte[] rawKey = getRawKey(192, seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes());
        return toHex(result);
    }

    public static String encrypt256(String seed, String cleartext) throws Exception {
        byte[] rawKey = getRawKey(256, seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes());
        return toHex(result);
    }

    public static String decrypt128(String seed, String encrypted, String coding) throws Exception {
        byte[] rawKey = getRawKey(128, seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result, TextUtils.isEmpty(coding) ? CODING : coding);
    }

    public static String decrypt192(String seed, String encrypted, String coding) throws Exception {
        byte[] rawKey = getRawKey(192, seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result, TextUtils.isEmpty(coding) ? CODING : coding);
    }

    public static String decrypt256(String seed, String encrypted, String coding) throws Exception {
        byte[] rawKey = getRawKey(256, seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result, TextUtils.isEmpty(coding) ? CODING : coding);
    }

    public static String decrypt128(String seed, String encrypted) throws Exception {
        byte[] rawKey = getRawKey(128, seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result, "utf-8");
    }

    public static String decrypt192(String seed, String encrypted) throws Exception {
        byte[] rawKey = getRawKey(192, seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result);
    }

    public static String decrypt256(String seed, String encrypted) throws Exception {
        byte[] rawKey = getRawKey(256, seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result, "utf-8");
    }

    @SuppressLint({"TrulyRandom"})
    private static byte[] getRawKey(int pattern, byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr;
        if (Build.VERSION.SDK_INT > 23) {
            sr = SecureRandom.getInstance("SHA1PRNG", new AndroidAESEncryptor.CryptoProvider());
        } else if (Build.VERSION.SDK_INT >= 17) {
            sr = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        } else {
            sr = SecureRandom.getInstance("SHA1PRNG");
        }

        sr.setSeed(seed);
        kgen.init(pattern, sr);
        SecretKey skey = kgen.generateKey();
        return skey.getEncoded();
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, skeySpec);
        return cipher.doFinal(clear);
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, skeySpec);
        return cipher.doFinal(encrypted);
    }

    public static String toHex(String txt) {
        return toHex(txt.getBytes());
    }

    public static String fromHex(String hex) {
        return new String(toByte(hex));
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];

        for(int i = 0; i < len; ++i) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }

        return result;
    }

    public static String toHex(byte[] buf) {
        if (buf == null) {
            return "";
        } else {
            StringBuffer result = new StringBuffer(2 * buf.length);

            for(int i = 0; i < buf.length; ++i) {
                appendHex(result, buf[i]);
            }

            return result.toString();
        }
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append("0123456789ABCDEF".charAt(b >> 4 & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }

    private static class CryptoProvider extends Provider {
        private CryptoProvider() {
            super("Crypto", 1.0D, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            this.put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            this.put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }
}
