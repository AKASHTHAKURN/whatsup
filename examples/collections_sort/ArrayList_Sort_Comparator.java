package collections.sort;

import java.util.*;

/*
 * Comparator 인터페이스는를 구현하는 익명객체는 compare() 메소드를 오버라이딩 해야 합니다. 
 * compare() 메소드는 두 개의 인자를 받아서 비교 후 정수 반환 값을 반환 합니다. 
 * 이것도 역시 둘 이 같다면 0을 반환하고, 첫 번째 인자가 크다면 양수를, 두 번째 인자가 크다면 음수를 반환하면 됩니다. 
 * 이 예제에서는 날짜를 비교하여 오름차순으로 정렬합니다.
 * 
 * 반대로 정렬하려고 한다면 두 가지 방법이 있겠습니다. 
 * 첫 번째는 비교 메소드의 반환값의 음수, 양수 부호를 반대로 하면 되겠습니다. 
 * 두 번째는 오름 차순으로 정렬한 다음에 Collections.reverse() 메소드를 사용해서 순서를 뒤집으면 되겠습니다.
 */

public class ArrayList_Sort_Comparator {
    public static void main(String[] args) {

    	ArrayList<Board> bList = new ArrayList<Board>();
        
    	bList.add(new Board(1, "홍길동", "2016-01-02"));
        bList.add(new Board(2, "아무개", "2017-03-05"));
        bList.add(new Board(3, "김영희", "2015-12-15"));
        bList.add(new Board(4, "김철수", "2016-10-05"));

        // 두 번째 인자로 Comparator 객체를 익명객체로 만들어서 넘깁니다.
        Collections.sort(bList, new Comparator<Board>() {
            @Override
            public int compare(Board b1, Board b2) {

            	return b1.getDate().compareTo(b2.getDate());	// 문자열
  
            	//return String.valueOf(b1.getNum()).compareTo(String.valueOf(b2.getNum())) * -1;	// 정수
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
// 이번에는 저장될 객체가  Comparable 인터페이스를 구현하지 않습니다.
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
