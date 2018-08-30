package com.joymates.soma.http.shouqiaba;

import com.blankj.utilcode.util.EncryptUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author yaming.rong
 */
public class MD5Util {

    public static String encryptMd5(String string) throws UnsupportedEncodingException {
        return encryptMd5(string, "UTF-8");
    }

    public static String encryptMd5(String string, String charSet) throws UnsupportedEncodingException {
        return EncryptUtils.encryptMD5ToString(string.getBytes(charSet));
//        return DigestUtils.md5Hex(string.getBytes(charSet));
    }

    /**
     * 计算字符串的MD5值
     *
     * @param signStr:签名字符串
     * @return
     */
    public static String getSign(String signStr) {
        try {
            return encryptMd5(signStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
