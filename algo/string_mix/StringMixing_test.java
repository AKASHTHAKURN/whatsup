
/*
 * *** ������ ���ڿ��� �����ض�, ���ڷ� �ҷ��� �ȵǴ� ��� �ִ�
-> ���ڵ� ���ڷ� ó���ض�
-> ���ڿ��� ������ ����� ������ 
 * 
 * 
 */

/*
 * ���� ���ڿ����� ã�� ���
 * buf�� �������� ������ ���´�
 * 
 * 
 */

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
						// �ڷ� ������
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





