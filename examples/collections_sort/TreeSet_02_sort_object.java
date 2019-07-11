package collections.sort;

import java.util.*;

/*
 * 
 * 	TreeSet 으로 Object의 특정 Element를 정렬하기 위해서는 
 *  반드시 클래스에 Comparable 인터페이스 상속받아 compareTo를 오버라이딩 해야 한다 !!!
 * 
 * 	Object 중복제거 기준은 compareTo로 지정된 항목이 중복되면 제거됨
 * 
 */

public class TreeSet_02_sort_object {

	public static <T> void main(String[] args) {


		TreeSet<Board3> ts = new TreeSet<Board3>();

    	ts.add(new Board3(1, "홍길동", "2016-01-02"));
    	ts.add(new Board3(2, "이경진", "2017-03-05"));
    	ts.add(new Board3(7, "이경진", "2018-03-05"));
    	ts.add(new Board3(3, "박나래", "2015-12-15"));
    	ts.add(new Board3(4, "김철수", "2016-10-05"));

        for(Board3 board : ts)
            System.out.println(board);
        
/*
 *  객체일 때 subSet은 어떻게 사용하는가?
 */
        
        /*
        NavigableSet<Integer> result3 = ts.subSet(50, true, 100, false);
        System.out.println("50 이상 100 미만 사이의 점수 검색");
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
    	// 문자정렬
    	//return this.name.compareTo(board.name);									
    	// return this.date.compareTo(board.date) * (-1);
    	
    	// 정수정렬	
    	return this.num - board.num;
    }

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