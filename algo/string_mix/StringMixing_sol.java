import java.util.ArrayList;

public class StringMixing_sol {

	public static void main(String[] args) {
		String sample = loadData();

		String tmp1 = "";
		String tmp2 = "";
		String result = "";
		
//		String sample = "HHAAAATTCGVVTXXY";

		ArrayList<String> s1 = new ArrayList<>();

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
		    System.out.println("tmp1" + tmp1);
		    System.out.println("tmp2" + tmp2);
		    
		  }else {
			tmp1 += word;
		  }
		}
		result = tmp1 + tmp2;
		
		System.out.println(result); 		
		
	}
	
	
	public static String loadData() {
//		����1
		String sample = "HHAAAATTCGVVTXXY";
		
//		����2
//		String sample = "CCCCTTCGVVTXXY";
		
//		����3
//		String sample ="BBBBAAACFFTTY";
		
//		����4
//		String sample = "BBBBAAACFFTTYY";
		
		return sample;
	}

}





//# sample = "CCCCTTCGVVTXXY"
//# �־��� ���ڿ����� ������� ������ ���ڿ��� ���� ¦���̸� ������
//# �ڷ� �������� �Ѵ�. �ڷ� �������� ���ڿ��� ������ �߻��ϸ�
//# ������ �ڷ� �Ű��� ���ڿ��� �� ������ ������ ���̴�.
//# "CCCCTTCGVVTXXY"
//# "CCTTCGVVTXXYCC"
//# "CCTCGVVTXXYTCC"
//# "CCTCGVTXXYVTCC"
//# "CCTCGVTXYXVTCC"
//# �� ���� �������� ���Ӱ� �ڷ� �Ű����� ���ڿ��� �������� ������ �ٿ�����.
//�Է� ����
//����1
//String sample = "HHAAAATTCGVVTXXY";
//����2
//String sample = "CCCCTTCGVVTXXY";
//����3
//String sample ="BBBBAAACFFTTY";
//����4
//Stringsample = "BBBBAAACFFTTYY";

//# ��� ���
//# HAATCGVTXYXVTAAH
//# CCTCGVTXYXVTCC
//# BBAAACFTYTFBB
//# BBAAACFTYYTFBB