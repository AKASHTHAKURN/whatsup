package collections.sort;

import java.util.*;
import java.io.*;

public class List_MultiSort {

	public static void main(String[] args) throws IOException {
    	
    	ArrayList<Grade> al = new ArrayList<>(); 
    	
        try {
            BufferedReader in = new BufferedReader(new FileReader("DS_Sample1.txt"));
            String str;
            while ((str = in.readLine()) != null) {
            	String words[] = str.split(" ");
            	Grade g = new Grade(words[0],Integer.parseInt(words[1]),Integer.parseInt(words[2]),Integer.parseInt(words[3]));
            	al.add(g);
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e); // ������ �ִٸ� �޽��� ���
            System.exit(1);
        }
        
		Collections.sort(al, (g1, g2) -> (g2.getKorean() - g1.getKorean()));
		
		// ���� ������������
		al.sort(Comparator.comparing(Grade::getKorean).reversed());

		// ���� ���� ��� �̸� ������ ����
		al.sort( Comparator.comparing(Grade::getKorean).reversed().thenComparing(Grade::getName)  );
		
		// ���� ���� ��� �̸� ������ ���� 
		// ������ ������ ���� ��ü�� �ϳ� ���� �߰�
		Comparator<Grade> reversedNameComparator = Comparator.comparing(Grade::getName).reversed();
		al.sort( Comparator.comparing(Grade::getKorean).reversed().thenComparing(reversedNameComparator));

		// comparator �̿�
		Collections.sort(al, new GradeCompare());
		
    	for(Grade val:al)
			System.out.println(String.format("%5s %4d %4d %4d",val.getName(), val.getKorean(), val.getEnglish(), val.getMath()));
    }
}

/*
	��ҹ��� ���о��� �񱳸� �Ͻ÷��� 
	Comparator �������̽� ���� ��Ŀ����� compareTo �޼ҵ� ��� compareToIgnoreCase �޼ҵ带 ����Ͻø� �˴ϴ�. 
	�׸��� �Ʒ��� comparing �޼ҵ带 ����Ͻ÷��� 
	Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER); 
	�̷������� �ڿ� ������ �߰����ָ� �˴ϴ�. thenComparing �޼ҵ忡�� �����ϰ� ����˴ϴ�.
*/
class GradeCompare implements Comparator<Grade> {

	@Override
	public int compare(Grade g1, Grade g2) {

		int ret = 0;
		
		if(g1.getKorean() == g2.getKorean()) {

			// compareToIgnoreCase ��ҹ��� ���� ����
			if(g1.getName().compareTo(g2.getName()) == 0) {		
				// ���� ��� ���⿡ �ٸ� ���� �߰�
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

/*
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
*/