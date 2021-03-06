package ssp.string_proc;

public class ConvertStringNumber {

	public static void main(String[] args) {
		
		/****** Summary **************************/
		
		// 기본형 -> 문자열
		String str;
		str = String.valueOf(100);
		str = String.valueOf(10.5);
		
		
		// 문자열 -> 기본형
		int n1 = Integer.valueOf("1024");
		int n2 = Integer.parseInt("1966");
		
		/*****************************************/
		
		/*
		 * 기본형 -> 문자열
		 */
		// static String valueOf(Object o)
		// boolean b, char c, int i, long l, float f, double d, Objec o
		// 문자열로 변환하여 반환한다, 참조변수에는 toString()을 호출한 결과를 반환한다
		System.out.println(String.valueOf(true));		// boolean
		System.out.println(String.valueOf('a'));		// char
		System.out.println(String.valueOf(100));		// int
		System.out.println(String.valueOf(100L));		// long
		System.out.println(String.valueOf(10.1f));		// float
		System.out.println(String.valueOf(10.1d));		// double
		
		/*
		 * 정수형을 진수변환하여 -> 문자열
		 */
		// public static String toHexString(int i)
		// 정수를 16진수 정수로 변환
		// 스트링 배열 초기화 방법
		String[] st = new String[3];
		st[0] = Integer.toHexString(255).toUpperCase();
		st[1] = Integer.toBinaryString(100);
		st[2] = Integer.toOctalString(16);
		for(String ss : st) System.out.println(ss);

		/*
		 * 문자열 -> 정수형
		 */
		int i1	= Integer.valueOf("255");
		int i2 	= Integer.valueOf("ff", 16);	// radix

		System.out.println("i2 = " + i2);
		
		/*
		 * 문자열 -> 기본형
		 */
		int 	i 	= Integer.parseInt("1024");
		boolean b 	= Boolean.parseBoolean("true"); 
		byte 	bt 	= Byte.parseByte("10");
		short 	s 	= Short.parseShort("20");
		long 	l 	= Long.parseLong("50000000");
		float	f 	= Float.parseFloat("10.2");
		double	d 	= Double.parseDouble("10.2");
		
		/*
		 * 문자 -> 기본형, 문자는 substring을 사용하여 String 한글자로 만들어서 처리하는게 좋다
		 */
		i = Character.digit('5', 10); // radix, 숫자가 아닐경우 -1로 변환됨

		/*
		 * 날짜 변환
		 */
		java.util.Date dt = new java.util.Date();
		String date = String.valueOf(dt);
		System.out.println(dt);
	}
}
