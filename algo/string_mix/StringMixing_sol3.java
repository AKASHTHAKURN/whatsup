public class StringMixing_sol3 {

	public static void main(String[] args) {
		String sample = loadData();

		String tmp1 = "";
		String tmp2 = "";
		String result = "";		

		String str = "";			
		for (int i = 0; i < sample.length(); i++) {
			str += sample.charAt(i);

			if (i >= sample.length() - 1) {
				if (str.length() % 2 == 0) {
					tmp1 += str.substring(0, str.length() / 2);
					tmp2 = str.substring(str.length() / 2) + tmp2;
				} else {
					tmp1 += str;
				}
				break;
			}

			if (sample.charAt(i) != sample.charAt(i + 1)) {
				if (str.length() % 2 == 0) {
					tmp1 += str.substring(0, str.length() / 2);
					tmp2 = str.substring(str.length() / 2) + tmp2;
				} else {
					tmp1 += str;
				}
				str = "";
			}
		}	
		
		result = tmp1 + tmp2;
		
		System.out.println(result); 		
		
	}
	
	
	public static String loadData() {
//		샘플1
//		String sample = "HHAAAATTCGVVTXXY";
		
//		샘플2
//		String sample = "CCCCTTCGVVTXXY";
		
//		샘플3
//		String sample ="BBBBAAACFFTTY";
		
//		샘플4
		String sample = "BBBBAAACFFTTYY";
		
		return sample;
	}

}





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
