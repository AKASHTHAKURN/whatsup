package collections.sort;

import java.util.*;

/*
 * Comparator �������̽��¸� �����ϴ� �͸�ü�� compare() �޼ҵ带 �������̵� �ؾ� �մϴ�. 
 * compare() �޼ҵ�� �� ���� ���ڸ� �޾Ƽ� �� �� ���� ��ȯ ���� ��ȯ �մϴ�. 
 * �̰͵� ���� �� �� ���ٸ� 0�� ��ȯ�ϰ�, ù ��° ���ڰ� ũ�ٸ� �����, �� ��° ���ڰ� ũ�ٸ� ������ ��ȯ�ϸ� �˴ϴ�. 
 * �� ���������� ��¥�� ���Ͽ� ������������ �����մϴ�.
 * 
 * �ݴ�� �����Ϸ��� �Ѵٸ� �� ���� ����� �ְڽ��ϴ�. 
 * ù ��°�� �� �޼ҵ��� ��ȯ���� ����, ��� ��ȣ�� �ݴ�� �ϸ� �ǰڽ��ϴ�. 
 * �� ��°�� ���� �������� ������ ������ Collections.reverse() �޼ҵ带 ����ؼ� ������ �������� �ǰڽ��ϴ�.
 */

public class ArrayList_Sort_Comparator {
    public static void main(String[] args) {

    	ArrayList<Board> bList = new ArrayList<Board>();
        
    	bList.add(new Board(1, "ȫ�浿", "2016-01-02"));
        bList.add(new Board(2, "�ƹ���", "2017-03-05"));
        bList.add(new Board(3, "�迵��", "2015-12-15"));
        bList.add(new Board(4, "��ö��", "2016-10-05"));

        // �� ��° ���ڷ� Comparator ��ü�� �͸�ü�� ���� �ѱ�ϴ�.
        Collections.sort(bList, new Comparator<Board>() {
            @Override
            public int compare(Board b1, Board b2) {

            	return b1.getDate().compareTo(b2.getDate());	// ���ڿ�
  
            	//return String.valueOf(b1.getNum()).compareTo(String.valueOf(b2.getNum())) * -1;	// ����
            }
        });

        print_list(bList);

    }

    static void print_list(ArrayList<Board> bList) {
        for(Board b : bList) {
            System.out.println(b);
        }
    }

}

/*
// �̹����� ����� ��ü��  Comparable �������̽��� �������� �ʽ��ϴ�.
class Board {
	private int num;
	private String name = "";
	private String date = "";
	
	public Board(int num, String name, String date) {
		this.num = num;
		this.name = name;
		this.date = date;
	}
	
	public void setNum(int num) { this.num = num; }
	public int getNum() { return this.num; }
	public void setname(String name) { this.name = name; }
	public String getName() { return this.name; }
	public void setDate(String date) { this.date = date; }
	public String getDate() { return this.date; }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.num).append(" : ");
		sb.append(this.name).append(" : ");
		sb.append(this.date);
		return sb.toString();
	}
}
*/
