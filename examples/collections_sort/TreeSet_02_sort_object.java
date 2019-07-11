package collections.sort;

import java.util.*;

/*
 * 
 * 	TreeSet ���� Object�� Ư�� Element�� �����ϱ� ���ؼ��� 
 *  �ݵ�� Ŭ������ Comparable �������̽� ��ӹ޾� compareTo�� �������̵� �ؾ� �Ѵ� !!!
 * 
 * 	Object �ߺ����� ������ compareTo�� ������ �׸��� �ߺ��Ǹ� ���ŵ�
 * 
 */

public class TreeSet_02_sort_object {

	public static <T> void main(String[] args) {


		TreeSet<Board3> ts = new TreeSet<Board3>();

    	ts.add(new Board3(1, "ȫ�浿", "2016-01-02"));
    	ts.add(new Board3(2, "�̰���", "2017-03-05"));
    	ts.add(new Board3(7, "�̰���", "2018-03-05"));
    	ts.add(new Board3(3, "�ڳ���", "2015-12-15"));
    	ts.add(new Board3(4, "��ö��", "2016-10-05"));

        for(Board3 board : ts)
            System.out.println(board);
        
/*
 *  ��ü�� �� subSet�� ��� ����ϴ°�?
 */
        
        /*
        NavigableSet<Integer> result3 = ts.subSet(50, true, 100, false);
        System.out.println("50 �̻� 100 �̸� ������ ���� �˻�");
        System.out.println("===================");
        for(Integer score : result3){
            System.out.println(score);
        }
        */
        
    }
}

class Board3 implements Comparable<Board3> {
    private int num;
    private String name = "";
    private String date = "";

    public Board3(int num, String name, String date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }

    @Override
    public int compareTo(Board3 board) {
    	// ��������
    	//return this.name.compareTo(board.name);									
    	// return this.date.compareTo(board.date) * (-1);
    	
    	// ��������	
    	return this.num - board.num;
    }

    //  getter, setter�� �����մϴ�.
    public void setNum(int num) { this.num = num; }
    public int getNum() { return this.num; }
    public void setname(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setDate(String date) { this.date = date; }
    public String getDate() { return this.date; }

    // ��ü�� ������ ����մϴ�.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.num).append(" : ");
        sb.append(this.name).append(" : ");
        sb.append(this.date);
        return sb.toString();
    }
}