package collections.sort;

import java.util.*;

//
// 이 방식 사용하지 말고 Lamda 사용할 것
//

/*
 * Comparable 인터페이스를 구현해서 오버라이딩 해야 하는  메소드가 compareTo() 메소드 입니다. 
 * 정수값을 반환하는데, 자신과 인자로 주어진 자신과 같은 타입의 객체를 비교하여 
 * 같으면 0, 자신이 크면 양수, 자신이 작으면 음수를 반환하도록 만들면 됩니다. 
 * 이 예제에서는 이름을 비교하여 오름차순으로 정렬합니다.
 */

public class ArrayList_Sort_Comparable {
    public static void main(String[] args) {
        // 테스트용 데이터를 만듭니다.
        ArrayList<Board2> bList = new ArrayList<Board2>();
        bList.add(new Board2(1, "홍길동", "2016-01-02"));
        bList.add(new Board2(2, "이경진", "2017-03-05"));
        bList.add(new Board2(3, "박나래", "2015-12-15"));
        bList.add(new Board2(4, "김철수", "2016-10-05"));

        // 리스트를 정렬합니다.
        Collections.sort(bList);

        // 정렬된 리스트를 역정렬
        //Collections.reverse(bList); 

        // 정렬된 내용을 출력해 봅니다.
        for(Board2 board : bList) {
            System.out.println(board);
        }
    }
}

// 리스트에 저장될 클래스 입니다.
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
     * Comparable 인터페이스에 정의된 compareTo 메소드를 오버라이드 합니다.
     */
    @Override
    public int compareTo(Board2 board) {
    	
    	// -1 곱하면 반대로 정렬
    	return this.name.compareTo(board.name);									// 문자정렬
    	
    	//return this.date.compareTo(board.date);		
    	
    	//return String.valueOf(this.num).compareTo(String.valueOf(board.num));		// 정수정렬	
    }
    //==========================================================================================================

    //  getter, setter를 정의합니다.
    public void setNum(int num) { this.num = num; }
    public int getNum() { return this.num; }
    public void setname(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setDate(String date) { this.date = date; }
    public String getDate() { return this.date; }

    // 객체의 내용을 출력합니다.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.num).append(" : ");
        sb.append(this.name).append(" : ");
        sb.append(this.date);
        return sb.toString();
    }
}