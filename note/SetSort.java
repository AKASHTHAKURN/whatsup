package collections.sort;

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
	}

	public static void SetSortObject() {
		
		TreeSet<Board3> ts = new TreeSet<Board3>();

    	ts.add(new Board3(1, "È«±æµ¿", "2016-01-02"));
    	ts.add(new Board3(2, "ÀÌ°æÁø", "2017-03-05"));
    	ts.add(new Board3(7, "ÀÌ°æÁø", "2018-03-05"));
    	ts.add(new Board3(3, "¹Ú³ª·¡", "2015-12-15"));
    	ts.add(new Board3(4, "±èÃ¶¼ö", "2016-10-05"));

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
