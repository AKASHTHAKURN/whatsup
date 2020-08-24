package tct_summary;

import java.io.*;
import java.util.*;

public class CommonLibrary {

	public static void main(String[] args) {
		
		System.out.println(convIntString(232, 5));

		System.out.println(convStringInt("00333"));
		
		System.out.println(convTime("10:00:00", 0));
		
		System.out.println(convTimeToSec("00:01:10"));
		
		System.out.println(convSecToTime(54010));
	}
	
	//=============================================================//
	
	// "00:01:10" -> 70 sec
	public static int convTimeToSec(String strTime) 
	{
		String[] dat = strTime.split(":");
		int val = Integer.valueOf(dat[0])*3600 + Integer.valueOf(dat[1])*60 + Integer.valueOf(dat[2]);

		return val;
	}
	
	// 시간을 변환
	public static String convSecToTime(int remainSec) 
	{
		int val = remainSec;
		
		String a1, a2, a3;
		
		a1 = String.valueOf(val/3600);
		if(a1.length()<2)
			a1 = "0" + a1;

		a2 = String.valueOf(val%3600/60);
		if(a2.length()<2)
			a2 = "0" + a2;

		a3 = String.valueOf(val%3600%60);
		if(a3.length()<2)
			a3 = "0" + a3;
		
		return a1 + ":" + a2 + ":" + a3;
	}
	
	// 시간을 변환
	public static String convTime(String base, int remainSec) 
	{
		//if(remainSec ==0)
		//	return "00:00:00";
		
		String[] dat = base.split(":");
		int val = Integer.valueOf(dat[0])*3600 + Integer.valueOf(dat[1])*60 + Integer.valueOf(dat[2]) + remainSec;
		
		String a1, a2, a3;
		
		a1 = String.valueOf(val/3600);
		if(a1.length()<2)
			a1 = "0" + a1;

		a2 = String.valueOf(val%3600/60);
		if(a2.length()<2)
			a2 = "0" + a2;

		a3 = String.valueOf(val%3600%60);
		if(a3.length()<2)
			a3 = "0" + a3;
		
		return a1 + ":" + a2 + ":" + a3;
	}
	
	// "0"으로 fill in,
	// fillString("232", 5) -> "00232" 
	public static String fillString(String str, int cnt) 
	{
		if(str.length() >= cnt)
			return str;
		
		int size = cnt-str.length();
		
		for(int i=0; i<size; i++)
		{
			str = "0" + str;
		}		

		return str;
	}
	
	// int 232 -> string 00232, n 자리수
	public static String convIntString(int num, int radix) 
	{
		String str = String.valueOf(num);
		String temp = "";
		
		if(str.length() < radix) {
			for(int i=0; i<radix-str.length(); i++)
				temp += "0";
		}
		
		return  temp + str;
	}
	
	public static int convStringInt(String str) 
	{
		return (Integer.valueOf(str));
	}

	/*
	 * 사이니지에 정보를 출력, list 정보를 sinage.exe 에 스트림 출력 하는 
	 */
	public static void sendSignage(ArrayList<String> list) 
	{
		Process process = null;
		String[] cmd = new String[] {"SIGNAGE"};

		try {
			process = new ProcessBuilder(cmd).start();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()) ); // signage.exe 에 스트림출력 하는 설정
			
			for(int i=0; i<list.size(); i++) {
				bufferedWriter.write(list.get(i) + "\r\n");	
			}
			
			bufferedWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}	
}
// end of file
