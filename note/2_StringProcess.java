/* 문자 처리 */

public class String_Process {

	public static void main(String[] args) throws Exception {

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
	
// charAt
		s = "Hello";
		char ch = s.charAt(1); // index는 0부터 시작
		System.out.println("9) " + ch); //e
	
		// 문자 코드값을 반환 (아스키코드, 유니코드 등등)
		int index = s.charAt(0); 
		System.out.println(index); //72
		
// 10) concat : 문자열 뒤에 덧붙인다
		s = "Hello";
		s2 = s.concat(" World");
		System.out.println("10) " + s2);
		
// 11) endswith : 지정된 문자열(surfix)로 끝나는지 검사
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
	
// indexOf	 
// 지정된 문자(열) 포함되어 있으면 위치하는 인덱스를 반환
// int indexOf(String str), 없으면 -1 return
		s = "ABCDEFG";
		idx1 = s.indexOf("CD");				// 2
		System.out.println("14) " + idx1);
		
		// 15) String intern()
		// 문자열을 constant pool에 등록한다. 이미 constant pool에 같은 내용의 문자열이 있을경우 
		// 그 문자열(String 인스턴스)의 주소값을 반환한다
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
		
//	replaceAll - 문자열 치환
//		String replaceAll(String regex, String replacement)
// 		regex와 일치하는 문자열을 replacement 문자열로 치환

		s = "AABBAABBAABB";
		s1 = s.replaceAll("BB", "bbb");
		System.out.println("20) " + s1);

// 	replaceAll - 숫자제거
		s = s.replaceAll("[0-9]", ""); 
		
//	replaceAll - 특수문자 제거		
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		String str = "azA*Z019 아이폰***6를 샀는데 iphone5보다% 이쁘지는 않더라";
		str = str.replaceAll(match, "");	// 주의 공백이 아니고 null "" 임

		
// 	split
//		String[] spilt(String regex)
// 		문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환
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
		// 지정된 갯수만큼 나누어 문자열 배열로 반환
		s = "dog,cat,bear,deer";
		arr = s.split(",", 4);			// 채우다가 나머지 갯수는 분리하지 않고 마지막 배열에 넣는다
		System.out.println("22) ");		// foreach
		for(String stmp : arr)			
			System.out.println(stmp);

		// 22-1) join -> split의 반대
		s = String.join("-", arr);
		System.out.println("22-1) " + s);

		
		// 23) boolean startsWith(String prefix)
		// 23) boolean startsWith(String prefix, int offset) // 옵셋
		// 주어진 문자열로 시작하는지 검사
		s = "java.lang.object";
		b = s.startsWith("java");
		System.out.println("23) " + b);
		b = s.startsWith("lang", 5);
		System.out.println("23) " + b);
		

// 	24. substring  
//		문자열 뽑아내기
//		String substring(int begin)  시작위치부터 문자열을 뽑아낸다
//		String substring(int begin, int end)  
//		시작위치부터 끝위치 전까지 문자열을 뽑아낸다 (begin <= x < end)		

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
		// String 인스턴스에 저장되어있는 문자열을 반환한다
		// *** 보통 오버라이드해서 사용
		s = "hello";
		s1 = s.toString();
		System.out.println("27) " + s1);

//	trim		
// 		문자열의 앞과 뒤에 있는 공백을 없앤다. 문자열 중간에 있는 공백은 제거되지 않는다		
		s = "   Hello world   ";
		s1 = s.trim();
		System.out.println("28) " + s1);

		// 29) 문자 인코딩 변환
		str = "가";

		// 문자 -> 문자코드
		byte[] bArr  = str.getBytes("UTF-8");
		byte[] bArr2 = str.getBytes("CP949");

		// 문자코드 -> 문자
		System.out.println("UTF-8:" + new String(bArr,  "UTF-8"));
		System.out.println("CP949:" + new String(bArr2, "CP949"));

		
		// String.format() -> printf 와 동일 기능
		s = String.format("%d 더하기 %d는 %d 입니다.", 3,5,3+5);
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
		 * 스트림 처리 시 read size 만큼만 변환 시 사용
		 */
		char[] buf = new char[30];
		int size = 5;
		String answer = String.valueOf(buf, 0, size); // data, offset, count
	
        /* 문자열 포함여부 확인(검색)방법 - contains, indexOf, matches */ 
		{
	        String txt1 = "가나다라" ;
	        String txt2 = "해당 내용은 테스트 입니다" ;
	        String txt3 = "가격은 29,000원 입니다" ;
	        
	        // contains를 이용한 방법(true, false 반환)
	        if(txt1.contains("나다"))
	            System.out.println("문자열 있음!");
	        else
	            System.out.println("문자열 없음!");
	         
	        // indexOf를 이용한 방법 (문자위치 반환, 없으면 -1 반환)
	        if(txt2.indexOf("테스트") > -1)
	            System.out.println("문자열 있음!");
	        else
	            System.out.println("문자열 없음!");
	         
	        // matches를 이용한 방법 (true, false 반환)
	        if(txt2.matches(".*테스트.*"))
	            System.out.println("문자열 있음!");
	        else
	            System.out.println("문자열 없음!");
	         
	        // matches를 이용하여 정규 표현식으로 문자열에 숫자가 있는지 확인
	        if(txt3.matches(".*[0-9].*"))
	            System.out.println("숫자 있음!");
	        else
	            System.out.println("숫자 없음!");
		} /* 문자열 포함여부 확인 */

		/*
		 * 문자배열을 문자배열로 복사, 지정된 위치로
		 */
		int arrSum = 0;
		size = 10; // int
		int [][] sortedArray = new int[size][size];
		int [][] temp = new int[size][size];
		for(int i=0; i<size; i++) {
			System.arraycopy( sortedArray[i], 0, temp[i], 0, size );
		}
		
		/*
		 * String, Char 초기화 
		 */
		String sts = new String();			// 빈문자열로 초기화 됨 ""
		System.out.println(sts.length());	// -> 0 그래서 크기는 0
		
		char[] chArr = new char[10];		// 널문자로 초기화 됨 '\u0000'
		System.out.println((int)chArr[0]);	// -> 0
		
		/*
		 * String 에 char (+) 연산이 된다
		 */
		String st = "I am ";
		st += 'a';
		System.out.println(st);

		/*
		 * char -> String 변환
		 */
		String stringValueOf = String.valueOf('c');
		
		/* end of code */
	}
}
