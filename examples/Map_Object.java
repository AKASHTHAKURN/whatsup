package my.java.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Exam_Map_Object {

	public static void main(String[] args) throws IOException {

		Map<String, MenMonth> m = new HashMap<>();
		
		FileReader fileReader = new FileReader("DS_Sample2.csv");
		BufferedReader br = new BufferedReader(fileReader);
		
		String line;
		while((line = br.readLine()) != null) {
			
			String str[] = line.split(","); 
			
			if(m.containsKey(str[2])) {
				MenMonth mm = m.get(str[2]);
				mm.addA(Double.parseDouble(str[3]));
				mm.addB(Double.parseDouble(str[4]));
				mm.addC(Double.parseDouble(str[5]));
				mm.addSum();
				
				/* 객체에 직접 값을 넣으므로 put 필요가 없다 */
				//m.put(str[2], mm);
			
			} else {
				m.put(str[2], new MenMonth( Double.parseDouble(str[3]), Double.parseDouble(str[4]), Double.parseDouble(str[5]) ));
			}
		}

		for(String s : m.keySet()) {
			/* 소수점 자리수 제한을 위해 printf 사용, float 연산 오류도 없다 */

			// %s      : ASDF
			// %10s    : _____ASDF
			// %-10s   : ASDF_____
			// %10.3s  : ______ASD
			// %-10.3s : ASD______
			// %05d    : 00123
			// %-5d    : 123__
			// %-10.3f : 123.457__
			// 10.3E   : _1235E+02
			
			System.out.printf("%-4s %4.1f %4.1f %4.1f -> %4.1f\n", s,  m.get(s).getA(), m.get(s).getB(), m.get(s).getC(), m.get(s).getSum());
			//System.out.println(String.format("%-4s %4.1f %4.1f %4.1f -> %4.1f", s,  m.get(s).getA(), m.get(s).getB(), m.get(s).getC(), m.get(s).getSum()));
		}
	}
}

class MenMonth {
	
	private double a;
	private double b;
	private double c;
	private double sum;
	
	MenMonth(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.sum = a+b+c;
	}
	
	public double getA() {
		return this.a;
	}
	public double getB() {
		return this.b;
	}
	public double getC() {
		return this.c;
	}
	public double getSum() {
		return this.sum;
	}

	
	public void addA(double val) {
		this.a += val;
	}
	public void addB(double val) {
		this.b += val;
	}
	public void addC(double val) {
		this.c += val;
	}
	public void addSum() {
		this.sum = this.a + this.b + this.c;
	}
	
}