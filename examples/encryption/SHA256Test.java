package ssp.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Test {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		String input = new String("This is ������ hahaha");
		
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256"); 
		
		byte[] result = mDigest.digest(input.getBytes()); 
		
		StringBuffer sb = new StringBuffer(); 
		
		for (int i = 0; i < result.length; i++) { 
			sb.append(Integer.toString((result[i] & 0xFF) + 0x100, 16).substring(1));	// ù��° ���� "1" �� ���� 
			System.out.println(sb.toString());
		}
		
		System.out.println(input);
		System.out.println(sb.toString());
	}

}
