import java.util.*;
import java.io.*;

public class List_MultiSort {

	public static void main(String[] args) throws IOException {
    	
    	ArrayList<Grade> al = new ArrayList<>(); 
    	
        try {
            BufferedReader in = new BufferedReader(new FileReader("DS_Sample2.txt"));
            String str;
            while ((str = in.readLine()) != null) {
            	String words[] = str.split(" ");
            	Grade g = new Grade(words[0],Integer.parseInt(words[1]),Integer.parseInt(words[2]),Integer.parseInt(words[3]));
            	al.add(g);
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e); // 에러가 있다면 메시지 출력
            System.exit(1);
        }
        

        // 국어 내림차순, 옛날 방식
        Collections.sort(al, (g1, g2) -> (g2.getKorean() - g1.getKorean()));
		
		// 국어 내림차순, 신규 방식 사용할 것
		al.sort(Comparator.comparing(Grade::getKorean).reversed());

		// 국어 내림차순, 같으면 이름 내림차순
		al.sort( Comparator.comparing(Grade::getKorean).reversed().thenComparing(Grade::getName)  );

		/* 조건 만들기 어려우면 람다 객체를 하나 만들어서 추가 */
		
		//Comparator<Grade> comp2 = Comparator.comparing(Grade::getName, String.CASE_INSENSITIVE_ORDER);	// 대소문자 무시
		Comparator<Grade> comp2 = Comparator.comparing(Grade::getName);
		
		Comparator<Grade> comp1 = Comparator.comparing(Grade::getEnglish).reversed().thenComparing(comp2);
		
		al.sort( Comparator.comparing(Grade::getKorean).reversed().thenComparing(comp1));

	   	for(Grade val:al)
				System.out.println(String.format("%5s %4d %4d %4d",val.getName(), val.getKorean(), val.getEnglish(), val.getMath()));
	    	System.out.println();

		// comparator 이용, 안좋은 방법
		Collections.sort(al, new GradeCompare());
		
     }
}

/*
	대소문자 구분없이 비교를 하시려면 
	Comparator 인터페이스 구현 방식에서는 compareTo 메소드 대신 compareToIgnoreCase 메소드를 사용하시면 됩니다. 
	그리고 아래의 comparing 메소드를 사용하시려면 
	Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER); 
	이런식으로 뒤에 오더를 추가해주면 됩니다. thenComparing 메소드에도 동일하게 적용됩니다.
*/
class GradeCompare implements Comparator<Grade> {

	@Override
	public int compare(Grade g1, Grade g2) {

		int ret = 0;
		
		if(g1.getKorean() == g2.getKorean()) {

			// compareToIgnoreCase 대소문자 구분 없음
			if(g1.getName().compareTo(g2.getName()) == 0) {		
				// 같을 경우 여기에 다른 조건 추가
				ret = 0;
			}
			else if(g1.getName().compareTo(g2.getName()) > 0) {
				ret = 1;
			}
			else if(g1.getName().compareTo(g2.getName()) < 0) {
				ret = -1;
			}
		}

		if(g1.getKorean() > g2.getKorean())
			ret = -1;

		if(g1.getKorean() < g2.getKorean())
			ret = 1;
		
		return ret;
	}
}

class Grade
{
    private String strName;
    private int Korean;
    private int English;
    private int Math; 

    public Grade(String str, int k, int e, int m)
    {
        strName = str;
        Korean = k;
        English = e;
        Math = m;
    }

    public String getName()
    {
        return strName;
    }
    public void setName(String strName)
    {
        this.strName = strName;
    }
    public int getKorean()
    {
        return Korean;
    }
    public void setProjectA(int n)
    {
        Korean = n;
    }
    public int getEnglish()
    {
        return English;
    }
    public void setProjectB(int n)
    {
        English = n;
    }
    public int getMath()
    {
        return Math;
    }
    public void setMath(int n)
    {
        Math = n;
    }
}
