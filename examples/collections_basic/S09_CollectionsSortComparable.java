package collections.sc;

import java.util.*;

/*
 * - �������ڰ� ������ ������ ����
 * - ���ĺ� �� ������ ��� �ϳ�
 */

public class S09_CollectionsSortComparable {
     
    public static void main(String[] args) {
       
    	List<Computer> computers = new ArrayList<Computer>();
        
    	/*
    	 * ��ü�� Ŭ�����̹Ƿ� new ����Ͽ� ����, �⺻���� new �ʿ����
    	 */
    	computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));
        
        Iterator i = computers.iterator();
        System.out.println("before");
        while(i.hasNext()){
            System.out.println(i.next());		// toString() �������̵� �� ���·� ��µ�
        }
        
        /*
         * Collections�� static Ŭ������ ���� ������ ó��
         * sort() ������ ���� comparable �������̽��� �����ؾ� �Ѵ�
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
     * Comparable �������̽��� �޼ҵ带 ����
     * int, String ���� ���� �����ϴ� ����� ���� �����ؾ� ��
     * ���⼭�� �������̹Ƿ� ũ�� ��� ������ ���� ������ 0 �� �ǰ� �����Ͽ���
     */
    public int compareTo(Object o) {
        return this.serial - ((Computer)o).serial;
    }
    
    public String toString(){
        return serial+" => "+owner;
    }
}
