package ssp.string_proc;

import java.io.UnsupportedEncodingException;

public class String_Process {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String s;	
		String s1;	
		String s2;
		int idx1;
		int idx2;
		boolean b;
		boolean b2;
		boolean b3;
		
		s = "Hello";
		
		s = new String("Hello");
		
		char[] cb = {'H','e','l','l','o'};
		s = new String(cb);
		
		StringBuffer sb = new StringBuffer("Hello");
		s = new String(sb);
	
		// 9) charAt
		s = "Hello";
		char ch = s.charAt(1); // index�� 0���� ����
		System.out.println("9) " + ch); // e
	
		// ���� �ڵ尪�� ��ȯ (�ƽ�Ű�ڵ�, �����ڵ� ���)
		int index = s.charAt(0);
		System.out.println(index);
		
		// 10) concat : ���ڿ� �ڿ� �����δ�
		s = "Hello";
		s2 = s.concat(" World");
		System.out.println("10) " + s2);
		
		// 11) endswith : ������ ���ڿ�(surfix)�� �������� �˻�
		String file = "Hello.txt";
		b = file.endsWith("txt");
		System.out.println("11) " + b);
		
		// 12) boolean equals(Object obj)
		s = "Hello";
		s2 = "hello";
		b = s.equals(s2);
		System.out.println("12) " + b);
		
		// 13) boolean equalsIgnoreCase(String str)
		b = s.equalsIgnoreCase(s2);
		System.out.println("13) " + b);
	
//	indexOf	 
// 		������ ����(��) ���ԵǾ� ������ ��ġ�ϴ� �ε����� ��ȯ
//		int indexOf(String str), ������ -1 return
		s = "ABCDEFG";
		idx1 = s.indexOf("CD");				// 2
		System.out.println("14) " + idx1);
		
		// 15) String intern()
		// ���ڿ��� constant pool�� ����Ѵ�. �̹� constant pool�� ���� ������ ���ڿ��� ������� 
		// �� ���ڿ�(String �ν��Ͻ�)�� �ּҰ��� ��ȯ�Ѵ�
		s = new String("abc");
		s2 = new String("abc");
		b = (s==s2);
		b2 = s.equals(s2);
		b3 = (s.intern()==s2.intern());
		System.out.println("15) " + b + b2 + b3);
		
		// 16) int lastIndexOf(int ch)
		s = "java.lang.Object";
		idx1 = s.lastIndexOf('.');
		idx2 = s.indexOf('.');
		System.out.println("16) " + idx1);
		
		// 17) int lastIndexOf(String str);
		s = "java.java.java";
		idx1 = s.lastIndexOf("java");
		idx2 = s.indexOf("java");
		System.out.println("17) " + idx1 + "," + idx2);
		
		// 18) int length()
		s = "hello";
		int length = s.length();
		System.out.println("18) " + length);
		
		//19) String replace(char old, char nw)
		s = "hello";
		s1 = s.replace('h', 'c');
		System.out.println("19) " + s1);
		
//	replaceAll - ���ڿ� ġȯ
//		String replaceAll(String regex, String replacement)
// 		regex�� ��ġ�ϴ� ���ڿ��� replacement ���ڿ��� ġȯ

		s = "AABBAABBAABB";
		s1 = s.replaceAll("BB", "bbb");
		System.out.println("20) " + s1);

//	replaceAll - Ư������ ����		
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		String str = "azA*Z019 ������***6�� ��µ� iphone5����% �̻����� �ʴ���";
		str = str.replaceAll(match, "");	// ���� ������ �ƴϰ� null "" ��

		
// 	split
//		String[] spilt(String regex)
// 		���ڿ��� ������ �и���(regex)�� ������ ���ڿ� �迭�� ��� ��ȯ
		s = "dog,cat,bear";
		String[] arr = s.split(",");
		System.out.println("21) ");
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);

		s = "dog::cat::bear";
		arr = s.split("::");
		System.out.println("21) ");
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		
		// 22) String[] spilt(String regex, int limit)
		// ������ ������ŭ ������ ���ڿ� �迭�� ��ȯ
		s = "dog,cat,bear,deer";
		arr = s.split(",", 4);			// ä��ٰ� ������ ������ �и����� �ʰ� ������ �迭�� �ִ´�
		System.out.println("22) ");		// foreach
		for(String stmp : arr)			
			System.out.println(stmp);

		// 22-1) join -> split�� �ݴ�
		s = String.join("-", arr);
		System.out.println("22-1) " + s);

		
		// 23) boolean startsWith(String prefix)
		// 23) boolean startsWith(String prefix, int offset) // �ɼ�
		// �־��� ���ڿ��� �����ϴ��� �˻�
		s = "java.lang.object";
		b = s.startsWith("java");
		System.out.println("23) " + b);
		b = s.startsWith("lang", 5);
		System.out.println("23) " + b);
		

// 	24. substring  
//		���ڿ� �̾Ƴ���
//		String substring(int begin)  ������ġ���� ���ڿ��� �̾Ƴ���
//		String substring(int begin, int end)  
//		������ġ���� ����ġ ������ ���ڿ��� �̾Ƴ��� (begin <= x < end)		

		s = "java.lang.object";
		s1 = s.substring(10);				// object
		s2 = s.substring(5, 9);				// lang  (5 <= x < 9)
		System.out.println("24) " + s1 + " " + s2);
		

		// 25) String toLowerCase()
		s = "HELLO 5D";
		s1 = s.toLowerCase();
		System.out.println("25) " + s1);

		// 26) String toUpperCase()
		s = "hello 5Dx";
		s1 = s.toUpperCase();
		System.out.println("26) " + s1);
		
		// 27) String toString
		// String �ν��Ͻ��� ����Ǿ��ִ� ���ڿ��� ��ȯ�Ѵ�
		// *** ���� �������̵��ؼ� ���
		s = "hello";
		s1 = s.toString();
		System.out.println("27) " + s1);

//	trim		
// 		���ڿ��� �հ� �ڿ� �ִ� ������ ���ش�. ���ڿ� �߰��� �ִ� ������ ���ŵ��� �ʴ´�		
		s = "   Hello world   ";
		s1 = s.trim();
		System.out.println("28) " + s1);

		// 29) ���� ���ڵ� ��ȯ
		str = "��";

		// ���� -> �����ڵ�
		byte[] bArr  = str.getBytes("UTF-8");
		byte[] bArr2 = str.getBytes("CP949");

		// �����ڵ� -> ����
		System.out.println("UTF-8:" + new String(bArr,  "UTF-8"));
		System.out.println("CP949:" + new String(bArr2, "CP949"));

		
		// String.format() -> printf �� ���� ���
		s = String.format("%d ���ϱ� %d�� %d �Դϴ�.", 3,5,3+5);
		System.out.println("30) " + s);
		System.out.println(String.format("%-12s %3d %3d %3d","Tommy Lee", 100, 80, 10));
		System.out.println(String.format("%-12s %3d %3d %3d","Jake E. Lee", 100, 80, 10));
		
		// %s      : ASDF
		// %10s    : _____ASDF
		// %-10s   : ASDF_____
		// %10.3s  : ______ASD
		// %-10.3s : ASD______
		// %05d    : 00123
		// %-5d    : 123__
		// %-10.3f : 123.457__
		// 10.3E   : _1235E+02
		
		
		// 31) string to char array
		String inputData = "hello my name is taejin";
		char[] stringToCharArray = inputData.toCharArray();
		System.out.println("31) string to char array");
		for(char c : stringToCharArray) {
			System.out.println(c);
		}
		
		// 32) char array to string
		System.out.println("32) char arrary to string");
		inputData = String.valueOf(stringToCharArray);
		System.out.println(inputData);

		/*
		 * ��Ʈ�� ó�� �� read size ��ŭ�� ��ȯ �� ���
		 */
		char[] buf = new char[30];
		int size = 5;
		String answer = String.valueOf(buf, 0, size); // data, offset, count
	
        /* ���ڿ� ���Կ��� Ȯ��(�˻�)��� - contains, indexOf, matches */ 
		{
	        String txt1 = "�����ٶ�" ;
	        String txt2 = "�ش� ������ �׽�Ʈ �Դϴ�" ;
	        String txt3 = "������ 29,000�� �Դϴ�" ;
	        
	        // contains�� �̿��� ���(true, false ��ȯ)
	        if(txt1.contains("����"))
	            System.out.println("���ڿ� ����!");
	        else
	            System.out.println("���ڿ� ����!");
	         
	        // indexOf�� �̿��� ��� (������ġ ��ȯ, ������ -1 ��ȯ)
	        if(txt2.indexOf("�׽�Ʈ") > -1)
	            System.out.println("���ڿ� ����!");
	        else
	            System.out.println("���ڿ� ����!");
	         
	        // matches�� �̿��� ��� (true, false ��ȯ)
	        if(txt2.matches(".*�׽�Ʈ.*"))
	            System.out.println("���ڿ� ����!");
	        else
	            System.out.println("���ڿ� ����!");
	         
	        // matches�� �̿��Ͽ� ���� ǥ�������� ���ڿ��� ���ڰ� �ִ��� Ȯ��
	        if(txt3.matches(".*[0-9].*"))
	            System.out.println("���� ����!");
	        else
	            System.out.println("���� ����!");
		} /* ���ڿ� ���Կ��� Ȯ�� */

		/*
		 * ���ڹ迭�� ���ڹ迭�� ����, ������ ��ġ��
		 */
		int arrSum = 0;
		size = 10; // int
		int [][] sortedArray = new int[size][size];
		int [][] temp = new int[size][size];
		for(int i=0; i<size; i++) {
			System.arraycopy( sortedArray[i], 0, temp[i], 0, size );
		}
		
		/*
		 * String, Char �ʱ�ȭ 
		 */
		String sts = new String();			// ���ڿ��� �ʱ�ȭ �� ""
		System.out.println(sts.length());	// -> 0 �׷��� ũ��� 0
		
		char[] chArr = new char[10];		// �ι��ڷ� �ʱ�ȭ �� '\u0000'
		System.out.println((int)chArr[0]);	// -> 0
		
		/*
		 * String �� char (+) ������ �ȴ�
		 */
		String st = "I am ";
		st += 'a';
		System.out.println(st);

		/*
		 * char -> String ��ȯ
		 */
		String stringValueOf = String.valueOf('c');
		
		/* end of code */
		
	}

}
