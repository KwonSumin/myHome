package co.kr.utils.security;

import java.security.MessageDigest;

public class SHA256Util {
	public static void main(String[] args) throws Exception{
		System.out.println(SHA256Util.getEncryption("tnals1459"));
	}
	public static String getEncryption(String str) throws Exception{
		StringBuffer hexString = new StringBuffer();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(str.getBytes("UTF-8"));
 
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
	}
	
}
