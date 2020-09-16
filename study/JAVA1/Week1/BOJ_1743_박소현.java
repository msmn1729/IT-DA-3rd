package itda_2020;

import java.io.*;
import java.util.*;

public class BOJ_1743_박소현 {
	private static int N,M,K;
	static int array[][];
	private static boolean visit[][];
	public static int[] dx = {0,0,1,-1}; 
	public static int[] dy = {1,-1,0,0};
	static int count = 0;
	static int result = 0 ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();
		array = new int [N+1][M+1];
		visit = new boolean[N+1][M+1];
	
		
		for (int i = 0; i < K ; i++ ) { 
			int x = scan.nextInt();
			int y = scan.nextInt();
			array[x][y] = 1;
 		}
		
		for (int i = 0; i < N ; i++ ) { 
			for (int j = 0; j < M ; j++ ) { 
				if(array[i][j] == 1 && !visit[i][j]) {
					dfs(i,j,count,result);
					
				}
				System.out.print(result);
			}
 		}
	
		System.out.print(result);
		
	}
	
	
	static void dfs(int x, int y, int count, int ret) {//시작 노드, 카운트, 결과
		
		visit[y][x] = true;
		for (int i = 0; i<4;i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (0<=nextX && 0<=nextY && nextX<N+1 && nextY<N+1 &&!visit[nextX][nextY]&& array[nextY][nextX]==1) {
				//visit[nextY][nextX] = true; 
				count++;
				dfs(nextX,nextY,count,result);  
				//count --;
				//visit[nextY][nextX] = false; 
				
			}
		}
		if (result < count) {result = count;}
		
	
	}
}
