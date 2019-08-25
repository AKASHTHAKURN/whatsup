import java.util.ArrayList;

public class StringMixing_sol {

	public static void main(String[] args) {

		String sample = "HHAAAATTCGVVTXXY";
		//String sample = loadData();

		String tmp1 = "";
		String tmp2 = "";
		String result = "";

		ArrayList<String> s1 = new ArrayList<>();

		/*
		 * 첫글자 str 에 추가해놓고 다음글자 비교
		 * 같은면 추가, 다르면 str 리스트에 넣고 다른글자를 str에 넣는다
		 */

		String str = "";
		str += sample.charAt(0);
		
		for (int i=1; i<sample.length();i++) {			
		
		  if (sample.charAt(i) != sample.charAt(i-1)) {
		    
			  s1.add(str);
			  str = sample.charAt(i)+"";
		  
			  if (i == sample.length()-1)
				  s1.add(str);
			
		  }else {
			  str += sample.charAt(i);
		  }
		  
		}	
		
		System.out.println(s1);
		
		for (String word : s1) {

			if(word.length()%2 == 0) {
		    
				tmp1 += word.substring(0,word.length()/2);
		    
				tmp2 = word.substring(word.length()/2) + tmp2;
		    
				System.out.println("tmp1 : " + tmp1);
				System.out.println("tmp2 : " + tmp2);
		    
			} else {
		    	
		    	tmp1 += word;
		    }
		}
		
		result = tmp1 + tmp2;
		
		System.out.println(result); 		
	}
	
	
	public static String loadData() {
//		샘플1
		String sample = "HHAAAATTCGVVTXXY";
		
//		샘플2
//		String sample = "CCCCTTCGVVTXXY";
		
//		샘플3
//		String sample ="BBBBAAACFFTTY";
		
//		샘플4
//		String sample = "BBBBAAACFFTTYY";
		
		return sample;
	}

}
/* result
[HH, AAAA, TT, C, G, VV, T, XX, Y]
tmp1 : H
tmp2 : H
tmp1 : HAA
tmp2 : AAH
tmp1 : HAAT
tmp2 : TAAH
tmp1 : HAATCGV
tmp2 : VTAAH
tmp1 : HAATCGVTX
tmp2 : XVTAAH
HAATCGVTXYXVTAAH
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
