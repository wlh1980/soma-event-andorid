package com.joymates.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.encryption
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/12 11:52
 * Remark：
 */
public class AesUtil {


    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    private String sKey = "funfan.com201809";//key，加密的key
    private String ivParameter = "1201230125462244";//偏移量,4*4矩阵
    private static AesUtil instance = null;

    private AesUtil() {

    }

    public static AesUtil getInstance() {
        if (instance == null)
            instance = new AesUtil();
        return instance;
    }

    /**
     * 加密
     *
     * @param encData   要加密的内容
     * @param secretKey 加密的秘钥
     * @param vector    偏移量
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encrypt(String encData, String secretKey, String vector) throws Exception {
        if (secretKey == null) {
            return null;
        }
        if (secretKey.length() != 16) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = secretKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(encData.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted).replaceAll("\r|\n", "");// 此处使用BASE64做转码。
    }


    /**
     * 加密
     *
     * @param sSrc 要加密的内容
     * @return 加密后的字符串
     * @throws Exception
     */
    public String encrypt(String sSrc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted).replaceAll("\r|\n", "");// 此处使用BASE64做转码。
    }

    /**
     * 解密
     *
     * @param sSrc 要解密的内容
     * @return 解密后的字符串
     * @throws Exception
     */
    public String decrypt(String sSrc) throws Exception {
        byte[] raw = sKey.getBytes("ASCII");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, "utf-8");
    }

    /**
     * 解密
     *
     * @param sSrc 要解密的内容
     * @param key  解密要秘钥
     * @param ivs  偏移量
     * @return 解密后的字符串
     * @throws Exception
     */
    public String decrypt(String sSrc, String key, String ivs) throws Exception {
        try {
            byte[] raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivs.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, "utf-8");
        } catch (Exception ex) {
            return null;
        }
    }

}
