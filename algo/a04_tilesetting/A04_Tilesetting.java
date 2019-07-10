package algorithm.a04.tilesetting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * <�̿ϼ�>
 * 
 * ��Ŭ���� ȣ���� ���
 * ��� ����� 0�� �Ǵ� ���ڸ� ã�´�
 * gcd �޼ҵ� ��밡��
 * 
 * 
 */
public class A04_Tilesetting {

    public static void main(String[] args) throws FileNotFoundException {
    	
    	int val1,val2;
        int a,b;
    	int r=1;
        int LCM;
        
        
        System.setIn(new FileInputStream("data/tilesetting_input.txt"));	
        Scanner scanner = new Scanner(System.in);
        
		int T = scanner.nextInt();

		
		for(int i=0; i<T; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			
        	//val1 = a;
        	//val2 = b;

        	val1 = Math.max(a, b);
        	val2 = Math.min(a, b);
        	
        	/*
	        if (a >= b) {
	        	val1 = a;
	        	val2 = b;
	        } else
	        	val2 = a;
	        	val1 = b;
			}	
	        */
	 
	        int count = 0; 
	        while(r>0) {
	             r = val1 % val2;
	             val1 = val2;
	             val2 = r;
	             //count++;
	        }

	        System.out.println("#"+(i+1) + " " + val1 + " " + a*b/val1/val1);
		
    	}
    	
    }
}	



/*
Scanner sc = new Scanner(System.in);

System.out.print("ù��° ���� �Է��Ͻÿ� : ");
val1 = sc.nextInt();
System.out.print("�ι�° ���� �Է��Ͻÿ� : ");
val2 = sc.nextInt();

int a = val1;
int b = val2;

//val1 = 30;
//val2 = 24;


int tmp1=val1,tmp2=val2;//�ּҰ������ ���ϱ� ���� �Է¹��� �� ����
if(val1<val2){//2��° �Է¼��� Ŭ ��� ū���� val1���� ����
    val1 = tmp2;
    val2 = tmp1;
 }

int count = 0; 
while(r>0){//��Ŭ���� ȣ������ �̿��� GCD(�ִ�����)���ϱ�
     r = val1 % val2;
     val1 = val2;
     val2 = r;
     count++;
  }

 
 LCM = tmp1* tmp2/val1;//LCM(�ּҰ����)���ϱ�
 System.out.println("GCD(�ִ�����) : "+ val1 + "," + a*b/val1/val1);
 System.out.println("LCM(�ּҰ����) : "+ LCM);
	*/