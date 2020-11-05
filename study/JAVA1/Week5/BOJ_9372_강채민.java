import java.util.*;

public class 9372_ㅊㅁ {

	public static void main(String[] args) {
		
		/**
		 * 처음에는 트리 탐색 문제라고 생각
		 */
		
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for(int t = 0; t < T; t++) {
			
			int N = input.nextInt(); // 국가 수
			int M = input.nextInt(); // 비행기 종류
			
			int check [] = new int[N+1];
			
			int airplane[][] = new int [N+1][N+1];
			
			for(int i = 0; i < M; i++) {
				
				int m1 = input.nextInt();
				int m2 = input.nextInt();
				
				airplane[m1][m2] = 1;
				airplane[m2][m1] = 1;
			}
			
			int count = 0;
			
			/*for(int i = 1; i <= N; i++) {
				
				check[i] = 1; 
				
				for(int j = 1; j <= N; j++) {
					
					if(check[j] != 1 && airplane[i][j] == 1) {
						count = count + 1;
						check[j] = 1;
					}
						
				}
			}*/
			
			/**
			 * bfs
			 */
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i = 1; i <= N; i++) {
				
				if(check[i] == 1)
					continue;
				
				q.add(i);
				check[i] = 1;
				
				while(!q.isEmpty()) {
					
					int X = q.poll();
					
					count = count + 1;
					
					for(int j = 1; j <= N; j++) {
						
						if(check[j] == 1 || airplane[X][j] != 1)
							continue;
						
						q.add(j);
						check[j] = 1;
					}
				}
				
				
			}
			
			System.out.println(count - 1);
		}
	}

}
