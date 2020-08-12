/*

재귀함수란?
자기 자신을 특정 조건이 될 때까지 계속 호출하는 함수이다.
그래서 함수 안에 if조건문이 들어가 있고 끝나는 조건이 파라메터로 들어간다.
그리고 return에서 자기 자신을 호출한다

*/

public class RecursiveExam {

	public static void main(String[] args) {

		System.out.println(function(100));
		
		minus(10);

		System.out.println(factorial(10));
	}
	
	// 1~n까지 더하기, 리턴값이 있을 경우
	static int function(int n) {
		
		System.out.println("function : " + n);
		
		if (n==1) {
			return 1;
		}
		
		return (n + function(n-1));
		
	}

	// void 형태
	static void minus(int n) {
		
		if(n<=100) {
			
			System.out.println(n);
			
			minus(n+10);
			
		}
		
		
	}
	
	static int factorial(int n) {
		
		if (n==1)
			return 1;
		
		return (n * factorial(n-1));
	}
	
	
}
