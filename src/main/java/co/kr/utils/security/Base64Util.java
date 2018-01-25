package co.kr.utils.security;

import org.apache.commons.codec.binary.Base64;
 
public class Base64Util {
	
	public static void main(String[] args) throws Exception{
	
	}
	
	public static String getEncoding(String str) throws Exception{
		return new String(Base64.encodeBase64(str.getBytes()));
	}
	public static String getDecoding(String str) throws Exception {
		return new String(Base64.decodeBase64(str));
	}
	
}
