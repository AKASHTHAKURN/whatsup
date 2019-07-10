package algorithm.a04.tilesetting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * <미완성>
 * 
 * 유클리드 호제법 사용
 * 계속 나누어서 0이 되는 숫자를 찾는다
 * gcd 메소드 사용가능
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

System.out.print("첫번째 수를 입력하시오 : ");
val1 = sc.nextInt();
System.out.print("두번째 수를 입력하시오 : ");
val2 = sc.nextInt();

int a = val1;
int b = val2;

//val1 = 30;
//val2 = 24;


int tmp1=val1,tmp2=val2;//최소공배수를 구하기 위해 입력받은 값 저장
if(val1<val2){//2번째 입력수가 클 경우 큰수를 val1으로 변경
    val1 = tmp2;
    val2 = tmp1;
 }

int count = 0; 
while(r>0){//유클리드 호제법을 이용한 GCD(최대공약수)구하기
     r = val1 % val2;
     val1 = val2;
     val2 = r;
     count++;
  }

 
 LCM = tmp1* tmp2/val1;//LCM(최소공배수)구하기
 System.out.println("GCD(최대공약수) : "+ val1 + "," + a*b/val1/val1);
 System.out.println("LCM(최소공배수) : "+ LCM);
	*/