
public class rotation_sol {

	public static void main(String[] args) {		
		int [][]data = loadData();
		
		System.out.println("원본 행렬");
		printArray(data);
		
		
		int [][]result = rotation(data);
		
		
		System.out.println("\n결과 행렬");
		printArray(result);
	}
	
	public static int[][] rotation(int [][]data){
		int size = data.length;
		
		int [][]new1 = new int[size][size];
		int [][]new2 = new int[size][size];
		int [][]result = new int[size][size];

		for (int i=0;i<size;i++) {
			for (int j=0; j<size;j++) {
				new1[i][j] = data[i][size - 1 - j];
				new2[i][j] = data[size - 1 - j][size - 1 - i];
			}
		}	
		System.out.println("\n180도 회전");
		printArray(new1);
		
		System.out.println("\n대각선 회전");
		printArray(new2);

		for (int i=0;i<size;i++) {
			for (int j=0; j<size;j++) {
		     result[i][j] = (new1[i][j] + new2[i][j]) % 10;
			}
		}
		
		return result;
	}
	
	public static void printArray(int [][]data) {
		for(int[] ary: data) {
			for (int v : ary) {
				System.out.print(v + " ");
			}
			System.out.println();	
		}
			
	}
	
	public static int[][] loadData(){
//		샘플1
		/*int [][]data = {{3, 7, 1, 9},
						{5, 2, 6, 8},
						{6, 4, 7, 1},
						{5, 7, 5, 4}};*/
		
//		샘플2
		/*int  [][]data = { {6, 3, 7, 2, 9},
							{8, 5, 3, 6, 7},
							{1, 6, 8, 7, 1},
							{4, 5, 7, 9, 4},
							{7, 6, 3, 7, 5}};*/
		
//		샘플3
		int [][]data = {  {6,3, 7, 2, 9, 5, 3, 7},
							{3, 6, 8, 8, 5, 3, 6, 7},
							{1, 6, 4, 3, 8, 8, 7, 1},
							{6, 4, 5, 7, 5, 2, 9, 4},
							{7, 4, 8, 6, 3, 1, 7, 5},
							{5, 6, 3, 9, 8, 2, 7, 1},
							{6, 3, 5, 7, 8, 2, 6, 1},
							{2, 4, 4, 9, 6, 1, 2, 5}};
		
		
		return data;
	}

}
