package tct_summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSort {

	public static void main(String[] args) {

		ListSortElement();
		
		ListSortObject();
	}
	
	public static void ListSortElement() {
    	
		/* 문자열 정렬 */
		ArrayList<String> al = new ArrayList<String>();
        
    	al.add("ahn");
    	al.add("Kim");
    	al.add("lee");
    	al.add("Park");
    	al.add("zakk");
    	al.set(0, "Ralph");	// 지정된 index 변경

        System.out.println("index[0] -> " + al.get(0));
        System.out.println(al.indexOf("Park"));

        // 오름차순
        Collections.sort(al);

        // 내림차순 -> 역정렬, must do ascending before
        Collections.reverse(al);	 

        Collections.sort(al, (g1, g2) -> g2.compareTo(g1));

        Collections.sort(al, (g1, g2) -> g1.compareToIgnoreCase(g2));
        
        for(String s : al) 
        	System.out.println(s);		

        /* 숫자 정렬 */
        ArrayList<Integer> li = new ArrayList<Integer>();
        
    	li.add(100);
    	li.add(222);
    	li.add(14);
    	li.add(4);

        // 오름차순 후 역정렬 -> 내림차순
        Collections.sort(li);
        Collections.reverse(li);	 

    	for(Integer s : li) 
        	System.out.println(s);		

	}
	
	public static void ListSortObject() {
		
    	ArrayList<Board> bList = new ArrayList<Board>();
        
    	bList.add(new Board(1, "김철수", "2016-01-02"));
        bList.add(new Board(2, "아무개", "2017-03-05"));
        bList.add(new Board(3, "김영희", "2015-12-15"));
        bList.add(new Board(4, "김철수", "2016-10-05"));

        Collections.sort(bList, (g1, g2) -> g1.getName().compareTo(g2.getName()));

        Collections.sort(bList, (g1, g2) -> g1.getDate().compareTo(g2.getDate()));
        
        Collections.sort(bList, (g1, g2) -> g1.getNum() - g2.getNum());

		/* comparing 사용할 것 */
        // 이름순 정렬, 같은면 생일 빠른순
        bList.sort(Comparator.comparing(Board::getName).thenComparing(Board::getDate));
        
        for(Board b : bList)
            System.out.println(b);
	}
}

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
