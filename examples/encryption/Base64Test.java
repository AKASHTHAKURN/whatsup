package ssp.encryption;

import java.util.Base64;
import java.util.Base64.Decoder; 
import java.util.Base64.Encoder;
import java.io.UnsupportedEncodingException;


/*
	인코딩은 다른데 결과는 동일하다 
	  -> UTF 인코딩, 그냥 인코딩 차이
	
	UTF-8
	a2ltIHRhZWppbiBpcyDquYDtg5zsp4QgbWUhKypeJQ==
	kim taejin is 김태진 me!+*^%

	
	a2ltIHRhZWppbiBpcyCx6MXCwfggbWUhKypeJQ==
	kim taejin is 김태진 me!+*^%
*/

public class Base64Test {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String dec = "AgBdAQABAAEAAQEwMDEBAUBAAAAAAADcAAAArUAMzM0+mZmaAAAA4wAAAAAAAAAAQnAAAD+zMzMAAAAAAAAAAD6ZmZoAAA2+AAAAAAAAAAAAAAAAAAAAAAAAMI0D";

		String dec1 = "9QESIpkpgwAAAIIVcAJdFdZAAIt7ImhuIjoiTEdVUExVU19JT1QiLCJyc3AiOiJBSV9BVVRPX0FDSyIsImJhdCI6Ik5PTkUiLCJhbGMiOiIwMCIsInN0YXRlIjoiMDAiLCJodGgiOiIxMDAiLCJsdGgiOiItMTAwIiwiYXRtIjoiMTQ0MCIsImFjdCI6IjIiLCJ2YWwiOiIyNi40MSJ9vX76";
		
		
		base64Decode(dec1);
		
		//base64UTF();
		//base64();
	}


	public static void base64Decode(String encodedString) throws UnsupportedEncodingException {

		System.out.println(encodedString);
		
		Decoder decoder = Base64.getDecoder(); 
		
		byte[] decodedBytes = decoder.decode(encodedString); 
		
		for(int i=0; i<decodedBytes.length; i++) {
			if ( i%16 == 0 ) System.out.println();
			System.out.printf("%02X ", decodedBytes[i]);
		}
		System.out.println();
		System.out.println();
		
		String decodedString = new String(decodedBytes);
		
		System.out.println(decodedString);
		
	}
	
	
	public static void base64UTF() throws UnsupportedEncodingException {

		String testString = "kim taejin is 김태진 me!+*^%";
		Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(testString.getBytes("UTF-8"));
		System.out.println(encodedString);

		Decoder decoder = Base64.getDecoder(); 
		byte[] decodedBytes = decoder.decode(encodedString); 
		String decodedString = new String(decodedBytes, "UTF-8");
		System.out.println(decodedString);
		
	}
	
	public static void base64() throws UnsupportedEncodingException {

		String testString = "kim taejin is 김태진 me!+*^%";
		byte[] target = testString.getBytes();
		Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(target);
		String encodedString = new String(encodedBytes);
		System.out.println(encodedString);
		
		Decoder decoder = Base64.getDecoder(); 
		byte[] decodedBytes = decoder.decode(encodedString); 
		String decodedString;
		decodedString = new String(decodedBytes);
		System.out.println(decodedString);
		
	}
	
}


