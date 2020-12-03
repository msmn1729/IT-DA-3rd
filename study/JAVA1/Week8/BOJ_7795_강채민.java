import java.util.*;

public class 7795_ㅊㅁ {

	public static void main(String[] args) {
		
		/**
		 * 아 진짜 왜안돼 진짜 
		 */
		
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for(int t = 0; t < T; t++) {
			
			int N = input.nextInt();
			int M = input.nextInt();
			
			int A [] = new int [N];
			int B [] = new int [M];
			
			for(int a = 0; a < N; a++)
				A[a] = input.nextInt();
			
			for(int b = 0; b < M; b++)
				B[b] = input.nextInt();
			
			Arrays.sort(A);
			Arrays.sort(B);
			//Arrays.sort(B, Collections.reverseOrder());
			
			
			int count = 0;
			
			for(int i = 0; i < A.length; i++)
				System.out.print(A[i] + " ");
			
			for(int i = 0; i < A.length; i++) {
				/*
				for(int j = 0; j < M; j++) {
					
					if(A[i] > B[j])
						count++;
				}
				*/
				
				int j = 0;
				
				while(A[i] > B[j] && j < B.length) {
					j++;
				}
					
				
				count = count + j;
				
				System.out.println("i " + i + " " + count);
			}
			
			System.out.println(count);
		}
	}

}
