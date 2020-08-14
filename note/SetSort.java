package collections.sort;

/*
.hashset 클래스 정렬 -> list로 변환하여 collections.sort
.treeset 클래스 정렬은 클래스에 comparable 구현
*/

import java.util.Set;
import java.util.TreeSet;

public class SetSort {

	public static void main(String[] args) {

		SetSortElement();
		
		SetSortObject();
		
	}

	public static void SetSortElement() {

		TreeSet<String> sl = new TreeSet<String>();
		
		sl.add("ddd");
		sl.add("aaa");
		sl.add("xxx");
		sl.add("fff");

		// already sorted ascending
		for(String s : sl) 
           		System.out.println(s);
		System.out.println();

		// descending
		Set<String> intsReverse = (TreeSet<String>) sl.descendingSet(); 

		for(String s : intsReverse) 
            		System.out.println(s);
		System.out.println();
		
		// 역정렬
		TreeSet<Integer> ts = new TreeSet<Integer>(Collections.reverseOrder());

		ts.add(7);
		ts.add(1);
		ts.add(3);
		ts.add(5);

		for(Integer s : ts)
			System.out.println(s);		
	}

	public static void SetSortObject() {
		
		TreeSet<Board3> ts = new TreeSet<Board3>();

		ts.add(new Board3(1, "홍길동", "2016-01-02"));
		ts.add(new Board3(2, "이경진", "2017-03-05"));
		ts.add(new Board3(7, "이경진", "2018-03-05"));
		ts.add(new Board3(3, "박나래", "2015-12-15"));
		ts.add(new Board3(4, "김철수", "2016-10-05"));

		for(Board3 board : ts)
		    System.out.println(board);		
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

    	return this.name.compareTo(board.name);									
    	
    	//return this.date.compareTo(board.date) * (-1);
    	
    	//return this.num - board.num;
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
