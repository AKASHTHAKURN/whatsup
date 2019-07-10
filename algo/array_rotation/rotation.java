/*
 * 	행렬회전
 * 
 * 	2차원 배열크기
 * 	a[5][2]
 *  a.length = 5; // 행길이
 *  a[0].length = 2; // 열길이
 * 
 *  //여기서 상하좌우에 같은값이 있으면 다 1로 바꿔라 문제 (대각선까지)
 *  //모든좌표에서 상하좌우 판단하는 방법
 *  
 * 
 * 
 * */
public class rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]data = loadData();

		int [][] ba = loadData();
		int [][] bb= loadData();
		int [][] rr= loadData();
		
		//System.out.println(data.length);
		
		System.out.println();

		for(int i=0; i<data.length; i++) {
			
			for(int k=0; k<data[i].length; k++) {

				System.out.printf( "%2d ",   data[i][k]);
				
			}
			System.out.println();
			
		}
		System.out.println("=================================");
		System.out.println("180도 회전");
		
		for(int i=0; i<data.length; i++) {
			
			for(int k=0; k<data[i].length; k++) {
				
				ba[i][k] = data[i][data.length-1-k];
				System.out.printf( "%2d ",   ba[i][k]);
				
			}
			System.out.println();
			
		}
		System.out.println("=================================");
		System.out.println("대각선 회전");

		for(int i=0; i<data.length; i++) {
			
			for(int k=0; k<data[i].length; k++) {
				
				bb[i][k] = data[data.length-1-k][data.length-1-i];
				System.out.printf( "%2d ",   bb[i][k]);
				
			}
			System.out.println();
			
		}
		System.out.println("=================================");
		
		for(int i=0; i<data.length; i++) {
			
			for(int k=0; k<data[i].length; k++) {
				rr[i][k] = (ba[i][k] + bb[i][k]) % 10;
				System.out.printf( "%2d ",   rr[i][k]);
			}
			System.out.println();
		}
	}
	
	public static int[][] loadData(){
//		샘플1
		int [][]data = {{3, 7, 1, 9},
						{5, 2, 6, 8},
						{6, 4, 7, 1},
						{5, 7, 5, 4}};
		
//		샘플2
		/*int  [][]data = {{6, 3, 7, 2, 9},
				{8, 5, 3, 6, 7},
				{1, 6, 8, 7, 1},
				{4, 5, 7, 9, 4},
				{7, 6, 3, 7, 5}};*/
		
//		샘플3
		/*int [][]data = {{6,3, 7, 2, 9, 5, 3, 7},
				{3, 6, 8, 8, 5, 3, 6, 7},
				{1, 6, 4, 3, 8, 8, 7, 1},
				{6, 4, 5, 7, 5, 2, 9, 4},
				{7, 4, 8, 6, 3, 1, 7, 5},
				{5, 6, 3, 9, 8, 2, 7, 1},
				{6, 3, 5, 7, 8, 2, 6, 1},
				{2, 4, 4, 9, 6, 1, 2, 5}};*/
		
		
		return data;
	}

}
