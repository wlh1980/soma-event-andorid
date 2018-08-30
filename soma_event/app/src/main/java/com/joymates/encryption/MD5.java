package com.joymates.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	/**
	 * 密码的MD5加密
	 * @param plainText 需要加密的字符串
	 * @param type 加密方式 0 (32位); 1 (16位)
	 * @return
	 */
	public static String md5s(String plainText,int type) {
		
		String result = "";
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
			if(type == 0){ //32位的加密
				result = buf.toString();
			}else if(type == 1){ //16位的加密
				result = buf.toString().substring(8, 24);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return result;
	}
}
