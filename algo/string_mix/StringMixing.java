
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

public class StringMixing {

	public static void main(String[] args) {
		String data = loadData();
		
		boolean run = true;
		
//while(run) {
	
		int offset = data.length();
		
		run = false;
		for (int i=0; i<data.length(); i++) {
			
			int count = 1;
			for (int k=1; k<data.length(); k++) {
		
				try {
					if (data.charAt(i) == data.charAt(i+k)) {
						count++;
					}
					else {
						if (count>0 && count%2 == 0) {
							// 문자열 잘라서 붙인다
							System.out.println(i + " "+ k + " " + count);

							StringBuilder sb = new StringBuilder(data);
						
							String sub = sb.substring(i, i+k/2);
							System.out.println(sub);

							sb.delete(i, i+k/2);
							//System.out.println(sb.toString());
							
							//sb.append(sub);
							//sb.insert(offset-1, sub);
							sb.insert(offset-sub.length(), sub);
							System.out.println(sb.toString());
							
							System.out.println(offset);
							offset = offset - sub.length();
							System.out.println(offset);
							
							
							
							data = sb.toString();
							
							//run = true;
							
							break;
						}
						
					}
				} catch (Exception e) {
					if (count>1 && count%2 == 0) {
						// 문자열 잘라서 붙인다
						// 문자열 잘라서 붙인다
						System.out.println(i + " "+ k + " " + count + "==========");

						StringBuilder sb = new StringBuilder(data);
					
						String sub = sb.substring(i, i+k/2);
						System.out.println(sub);

						sb.delete(i, i+k/2);
						//System.out.println(sb.toString());
						
						//sb.append(sub);
						sb.insert(offset-1, sub);
						System.out.println(sb.toString());
						offset = offset - sub.length();
						
						
						data = sb.toString();
						break;
					}
				}
			}	
//	}
			
		
		}	
				
		//# HAATCGVTXYXVTAAH
		//  HAATCAGTXVYXVTAH
		

	}
	
	
	public static String loadData() {
//		샘플1
		String sample = "HHAAAATTCGVVTXXY";
		
//		샘플2
//		String sample = "CCCCTTCGVVTXXY";
		
//		샘플3
//		String sample ="BBBBAAACFFTTY";
		
//		샘플4
//		Stringsample = "BBBBAAACFFTTYY";
		
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
