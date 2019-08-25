package collections.sort;

import java.util.ArrayList;
import java.util.Collections;

public class ListSort {

	public static void main(String[] args) {

		ListSortElement();
		//ListSortObject();
	}
	
	public static void ListSortElement() {
    	
		ArrayList<String> al = new ArrayList<String>();
        
    	al.add("마해영");
    	al.add("최동원");
    	al.add("박찬호");
    	al.add("류현진");
    	al.add("김기태");
    	al.set(0, "마동탁");	// 지정된 index 변경

        System.out.println("index[0] -> " + al.get(0));
        System.out.println(al.indexOf("박찬호"));

        // ascending
        Collections.sort(al);

        // descending, must do ascending before
        //Collections.reverse(al);	 

        // or
        
        Collections.sort(al, (g1, g2) -> g2.compareTo(g1));
        
        for(String s : al) 
        	System.out.println(s);		
	}
	
	public static void ListSortObject() {

    	ArrayList<Board> bList = new ArrayList<Board>();
        
    	bList.add(new Board(1, "홍길동", "2016-01-02"));
        bList.add(new Board(2, "아무개", "2017-03-05"));
        bList.add(new Board(3, "김영희", "2015-12-15"));
        bList.add(new Board(4, "김철수", "2016-10-05"));

        Collections.sort(bList, (g1, g2) -> g1.getName().compareTo(g2.getName()));

        Collections.sort(bList, (g1, g2) -> g1.getDate().compareTo(g2.getDate()));
        
        Collections.sort(bList, (g1, g2) -> g1.getNum() - g2.getNum());

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