

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DS2_map_object {
    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	HashMap<String, Effort> m = new HashMap<String, Effort> ();
        
    	BufferedReader br = new BufferedReader(new FileReader("DS_Sample2.csv"));
        
        String line;
        while ((line = br.readLine()) != null) {
        
        	String[] words = line.split(",");
            
        	String key = words[1];

            if (!m.containsKey(key))
            {
                   Effort ef = new Effort(words[2], Double.parseDouble(words[3]), Double.parseDouble(words[4]), Double.parseDouble(words[5]));
                   m.put(key, ef);
            }
            else 
            {
            	//
           		// ef 객체에 값을 넣는다	-> put 안하고 직접 객체에 값을 넣는다
           	   	// 객체는 이미 map에 들어가있고 객체의 값만 변경한다
               	//
            	m.get(key).AddA(Double.parseDouble(words[3]));
               	m.get(key).AddB(Double.parseDouble(words[4]));
               	m.get(key).AddC(Double.parseDouble(words[5]));
            }
        }
        	
        if(br != null) 
        	br.close();
        
        for( String key : m.keySet() ){
        	double total = m.get(key).getdA() + m.get(key).getdB() + m.get(key).getdC();
        	
        	//
        	// 소수점 1자 표시위해 printf 사용
        	// %.1f -> 소수점 두자리 표시
        	// 반올림 System.out.println(Math.round(pie*100)/100.0); //결과 : 3.14
        	//
        	System.out.println( String.format("%s	%s	%.1f	%.1f	%.1f	->	%.1f", key, m.get(key).getStrName(), m.get(key).getdA(), m.get(key).getdB(), m.get(key).getdC(), total));
            
        }        
    }
}

class Effort {
	private String strName;
	private double dA;
	private double dB;
	private double dC;
	
	public Effort(String str, double a, double b, double c){
		strName = str;
		dA = a;
		dB = b;
		dC = c;
	}
	
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public double getdA() {
		return dA;
	}
	public void setdA(double dA) {
		this.dA = dA;
	}
	public double getdB() {
		return dB;
	}
	public void setdB(double dB) {
		this.dB = dB;
	}
	public double getdC() {
		return dC;
	}
	public void setdC(double dC) {
		this.dC = dC;
	}
	public void AddA(double d)
	{
		dA += d;
	}
	public void AddB(double d)
	{
		dB += d;
	}
	public void AddC(double d)
	{
		dC += d;
	}
}