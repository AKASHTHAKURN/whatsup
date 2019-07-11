package collections.sc;

import java.util.*;

/*
 * - 작은숫자가 앞으로 오도록 정렬
 * - 알파벳 순 정렬은 어떻게 하나
 */

public class S09_CollectionsSortComparable {
     
    public static void main(String[] args) {
       
    	List<Computer> computers = new ArrayList<Computer>();
        
    	/*
    	 * 객체가 클래스이므로 new 사용하여 생성, 기본형은 new 필요없음
    	 */
    	computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));
        
        Iterator i = computers.iterator();
        System.out.println("before");
        while(i.hasNext()){
            System.out.println(i.next());		// toString() 오버라이딩 한 형태로 출력됨
        }
        
        /*
         * Collections는 static 클래스로 여러 데이터 처리
         * sort() 실행을 위해 comparable 인터페이스를 구현해야 한다
         */
        Collections.sort(computers);			
        
        System.out.println("\nafter");
        
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}

class Computer implements Comparable{
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    
    /*
     * Comparable 인터페이스의 메소드를 구현
     * int, String 형에 따라 정렬하는 방식은 직접 설계해야 함
     * 여기서는 정수형이므로 크면 양수 작으면 음수 같으면 0 이 되게 구현하였음
     */
    public int compareTo(Object o) {
        return this.serial - ((Computer)o).serial;
    }
    
    public String toString(){
        return serial+" => "+owner;
    }
}
