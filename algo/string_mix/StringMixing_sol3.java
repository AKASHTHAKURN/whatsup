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
//		����1
//		String sample = "HHAAAATTCGVVTXXY";
		
//		����2
//		String sample = "CCCCTTCGVVTXXY";
		
//		����3
//		String sample ="BBBBAAACFFTTY";
		
//		����4
		String sample = "BBBBAAACFFTTYY";
		
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
