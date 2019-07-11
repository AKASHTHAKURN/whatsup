package collections.sort;

import java.util.*;

//
// �� ��� ������� ���� Lamda ����� ��
//

/*
 * Comparable �������̽��� �����ؼ� �������̵� �ؾ� �ϴ�  �޼ҵ尡 compareTo() �޼ҵ� �Դϴ�. 
 * �������� ��ȯ�ϴµ�, �ڽŰ� ���ڷ� �־��� �ڽŰ� ���� Ÿ���� ��ü�� ���Ͽ� 
 * ������ 0, �ڽ��� ũ�� ���, �ڽ��� ������ ������ ��ȯ�ϵ��� ����� �˴ϴ�. 
 * �� ���������� �̸��� ���Ͽ� ������������ �����մϴ�.
 */

public class ArrayList_Sort_Comparable {
    public static void main(String[] args) {
        // �׽�Ʈ�� �����͸� ����ϴ�.
        ArrayList<Board2> bList = new ArrayList<Board2>();
        bList.add(new Board2(1, "ȫ�浿", "2016-01-02"));
        bList.add(new Board2(2, "�̰���", "2017-03-05"));
        bList.add(new Board2(3, "�ڳ���", "2015-12-15"));
        bList.add(new Board2(4, "��ö��", "2016-10-05"));

        // ����Ʈ�� �����մϴ�.
        Collections.sort(bList);

        // ���ĵ� ����Ʈ�� ������
        //Collections.reverse(bList); 

        // ���ĵ� ������ ����� ���ϴ�.
        for(Board2 board : bList) {
            System.out.println(board);
        }
    }
}

// ����Ʈ�� ����� Ŭ���� �Դϴ�.
class Board2 implements Comparable<Board2> {
    private int num;
    private String name = "";
    private String date = "";

    public Board2(int num, String name, String date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }

    //==========================================================================================================
    /**
     * Comparable �������̽��� ���ǵ� compareTo �޼ҵ带 �������̵� �մϴ�.
     */
    @Override
    public int compareTo(Board2 board) {
    	
    	// -1 ���ϸ� �ݴ�� ����
    	return this.name.compareTo(board.name);									// ��������
    	
    	//return this.date.compareTo(board.date);		
    	
    	//return String.valueOf(this.num).compareTo(String.valueOf(board.num));		// ��������	
    }
    //==========================================================================================================

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