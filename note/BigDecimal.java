import java.math.BigDecimal;

/*
 * 실수 연산은 무조건 BigDecimal 사용해라
 */

public class BigDecimal_Exam {

	public static void main(String[] args) {

		// float  32bit, f 붙여야 한다
		// double 64bit, f 붙이면 안된다
		
		float f1 = 1.3f;
		float f2 = 0.3f;
		
		double num1 = 1.3; 
		double num2 = 0.3; 
		
		// 스트링으로 변환해서 대입해야 한다
		
		BigDecimal big = new BigDecimal(String.valueOf(num1)); 
		
		BigDecimal big2 = new BigDecimal(String.valueOf(num2)); 
		
		System.out.println(big.add(big2));

		System.out.println(big.subtract(big2));
		
		System.out.println(big.multiply(big2));

		// 나누기는 자릿수, 반올림 여부 지정해야 한다
		System.out.println(big.divide(big2, 2, BigDecimal.ROUND_HALF_UP));	// 소수점 자리수, 반올림
	}
}
