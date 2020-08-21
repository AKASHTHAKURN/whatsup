package tct_summary;

import java.math.BigDecimal;

// float 연산은 BigDecimal 사용
// double 연산은 일반 연산도 가능

public class BigDecimal_Exam {

	public static void main(String[] args) {

		// float  32bit, f 붙여야 한다
		// double 64bit, f 붙이면 안된다
		
		// float 일반 연산 에러 발생
		float f1 = 1.3f;
		float f2 = 0.3f;
		System.out.println(f1 + f2); 		// 1.5999999 -> error	
		
		// double 일반 연산은 정상
		double d1 = 1.3; 
		double d2 = 0.3; 
		
		System.out.println(d1 + d2);	// 1.6 
		System.out.println(d1 - d2);	// 1.0 
		System.out.println(d1 * d2);	// 0.39 
		System.out.println(d1 / d2);	// 0.39 
		System.out.printf("%.2f\n", d1 / d2);	// 4.33, 소수점 2자리에서 반올림
		
		System.out.println("=====================================");
		
		// 스트링으로 변환해서 대입해야 한다
		BigDecimal big1 = new BigDecimal(String.valueOf(f1)); 
		BigDecimal big2 = new BigDecimal(String.valueOf(f2)); 
		
		System.out.println(big1.add(big2));			// 1.6
		System.out.println(big1.subtract(big2));	// 1.0
		System.out.println(big1.multiply(big2));	// 0.39
		// 나누기는 자릿수, 반올림 여부 지정해야 한다
		// 소수점 자리수, 반올림
		System.out.println(big1.divide(big2, 2, BigDecimal.ROUND_HALF_UP));	// 4.33
	}
}
