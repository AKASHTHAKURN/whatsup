package tct_summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
.hashset 클래스 정렬 -> list로 변환하여 collections.sort
.treeset 클래스 정렬은 클래스에 comparable 구현

List : 순서있음, 데이터 중복 허용
Set : 순서없음, 데이터 중복 불가
Map : key, value 저장, Key 중복불가, value 중복 허용

Set
- HashSet 중복불허, 입력순서 보장하지 않음
- TreeSet 중복불허, 오름차순 정렬
- LinkedHashSet 중복불허, 입력된 순서를 보장

*/

import java.util.Set;
import java.util.TreeSet;



public class SetSort {

	public static void main(String[] args) {

		SetSortElement();
		
		HashSetSort();

		TreeSetSort();
		
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
		
		// 선언 때 역정렬로 선언
		TreeSet<Integer> ts = new TreeSet<Integer>(Collections.reverseOrder());

		ts.add(7);
		ts.add(1);
		ts.add(3);
		ts.add(5);

		for(Integer s : ts)
			System.out.println(s);		
	}

	public static void HashSetSort() {
		HashSet<Board> ts = new HashSet<Board>();
	
		ts.add(new Board(1, "홍길동", "2016-01-02"));
		ts.add(new Board(2, "이경진", "2017-03-05"));
		ts.add(new Board(7, "이경진", "2018-03-05"));
		ts.add(new Board(3, "박나래", "2015-12-15"));
		ts.add(new Board(4, "김철수", "2016-10-05"));
	
		for(Board board : ts)
		    System.out.println(board);		
		System.out.println();
	
		ArrayList<Board> li = new ArrayList<>(ts);
		
		Collections.sort(li, (g1, g2) -> g1.getName().compareTo(g2.getName()));
		
		for(Board board : li)
		    System.out.println(board);		
		System.out.println();
	}

	public static void TreeSetSort() {
		
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

    // 여기서 어떻게 정렬할 건지 선언
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
