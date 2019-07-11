package ssp.string_proc;

public class StaticMathEx {

	public static void main(String[] args) {

		// static double random()
		// 0.0 ~ 1.0 ������ ������ double ���� ��ȯ�Ѵ�.
		// 1.0d�� ������ ���Ե��� ���� (0 <= x < 1.0) 
		
		double d = Math.random();
		System.out.println(d);

		// 0 ~ 9
		for(int i=0; i<100; i++) {
			int n = (int)(Math.random()*10); // 0~9
			System.out.println(n);
		}

		// 1 ~ 46
		// 46 - 1 = 45���ٰ� +1 
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
