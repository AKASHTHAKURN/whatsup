
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
							// ���ڿ� �߶� ���δ�
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
						// ���ڿ� �߶� ���δ�
						// ���ڿ� �߶� ���δ�
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
//		����1
		String sample = "HHAAAATTCGVVTXXY";
		
//		����2
//		String sample = "CCCCTTCGVVTXXY";
		
//		����3
//		String sample ="BBBBAAACFFTTY";
		
//		����4
//		Stringsample = "BBBBAAACFFTTYY";
		
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
