
/*
 * *** 무조건 문자열로 생각해라, 숫자로 할려면 안되는 경우 있다
-> 숫자도 문자로 처리해라
-> 문자열은 원본이 상수기 때문에 
 * 
 * 
 */

/*
 * 같은 문자열인지 찾는 방법
 * buf에 같은문자 저장해 놓는다
 * 
 * 
 */

//# sample = "CCCCTTCGVVTXXY"
//# 주어진 문자열에서 순서대로 나열된 문자열의 수가 짝수이면 절반을
//# 뒤로 보내려고 한다. 뒤로 보내지는 문자열이 여러번 발생하면
//# 기존에 뒤로 옮겨진 문자열의 앞 쪽으로 나열할 것이다.
//# "CCCCTTCGVVTXXY"
//# "CCTTCGVVTXXYCC"
//# "CCTCGVVTXXYTCC"
//# "CCTCGVTXXYVTCC"
//# "CCTCGVTXYXVTCC"
//# 와 같은 형식으로 새롭게 뒤로 옮겨지는 문자열은 기존것의 앞으로 붙여진다.
//입력 샘플
//샘플1
//String sample = "HHAAAATTCGVVTXXY";
//샘플2
//String sample = "CCCCTTCGVVTXXY";
//샘플3
//String sample ="BBBBAAACFFTTY";
//샘플4
//Stringsample = "BBBBAAACFFTTYY";

//# 출력 결과
//# HAATCGVTXYXVTAAH
//# CCTCGVTXYXVTCC
//# BBAAACFTYTFBB
//# BBAAACFTYYTFBB


public class StringMixing_test {

	public static String loadData() {
		String sample = "HHAAAATTCGVVTXXY";
//		String sample = "CCCCTTCGVVTXXY";
//		String sample ="BBBBAAACFFTTY";
//		Stringsample = "BBBBAAACFFTTYY";
		
		return sample;
	}

	public static void main(String[] args) {
		String data = loadData();

		
		StringBuilder sb = new StringBuilder(data);
		
		int count = 0;
		for(int i=0; i<sb.length(); i++) {
			
			for(int k=i+1; k<sb.length(); k++) {
				if(sb.charAt(i) == sb.charAt(k)) {
					count++;
				} else {
					if(count%2 == 0) {
						// 뒤로 보내기
						char c = sb.charAt(i);
						sb.delete(i, count/2+1);
						
						for(int j=0; j<count/2; j++)
							sb.append(c);
						System.out.println(sb.toString());
					}
					count = 0;
					break;
				}
			}
		}

	}
	
	

}





