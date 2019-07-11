package ssp.string_proc;

public class StaticMathEx {

	public static void main(String[] args) {

		// static double random()
		// 0.0 ~ 1.0 범위의 임의의 double 값을 반환한다.
		// 1.0d은 범위에 포함되지 않음 (0 <= x < 1.0) 
		
		double d = Math.random();
		System.out.println(d);

		// 0 ~ 9
		for(int i=0; i<100; i++) {
			int n = (int)(Math.random()*10); // 0~9
			System.out.println(n);
		}

		// 1 ~ 46
		// 46 - 1 = 45에다가 +1 
		for(int i=0; i<100; i++) {
			int n = (int)(Math.random()*46 + 1);
			System.out.println(n);
		}

		// 25 ~ 46
		// 46-25 = 21+1, + 25
		System.out.println("================");
		for(int i=0; i<100; i++) {
			int n = (int)(Math.random()*22 + 25);
			if (n <=25 || n>=46)
				System.out.println(n);
		}

	}

}
