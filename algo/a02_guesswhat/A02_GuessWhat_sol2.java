package algorithm.a02.guesswhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

public class A02_GuessWhat_sol2
{
		public static void main(String args[]) throws Exception	{
			int test_case; 
			int i; 
			int num; 
			int max;
			int grade;			
			int T;

			System.setIn(new FileInputStream("data/guesswhat_input.txt"));
			Scanner sc = new Scanner(System.in);
			T = sc.nextInt();
			for (test_case = 1; test_case<=T; test_case++)
			{
				Map<Integer, Integer> data = new HashMap<Integer, Integer>();				

				max = 0; // maximum count
				grade = 0;
				
				
				int cnt = sc.nextInt();
				
				for (i = 0; i < cnt; i++)
				{
					num = sc.nextInt();
					if (data.containsKey(num))
						data.put(num, data.get(num)+1);
					else
						data.put(num, 1);					
				}

				
				List<Integer> keylist = new ArrayList<>(data.keySet());
				Collections.sort(keylist);
				for (int stu : keylist) {
					int c = data.get(stu);
					if (max <= c) {
						max = c;
						grade = stu;
					}
				}

				System.out.println("#"+test_case+' '+ grade);
			}
			sc.close();
		}
	}