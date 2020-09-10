package itda_2020;


import java.io.*;
import java.util.*;

public class BOJ_1405_박소현 {
	private static int N;
	private static double direction[];
	private static boolean visit[][];
	public static int[] dx = {0,0,1,-1}; 
	public static int[] dy = {1,-1,0,0};
	static int count = 0;
	static double result;
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		direction = new double[4];
		visit = new boolean[30][30];
		N = scan.nextInt();
		for (int i = 0; i < 4 ; i++ ) { 
			direction[i] = scan.nextInt()*0.01;
		}
		
		visit[14][14] = true; 
		dfs(14,14,count,1); 
		
		System.out.println(result);
	}

	
	static void dfs(int x, int y, int count, double ret) {//시작 노드, 카운트, 결과
		
		if (count == N ) {
			result = ret + result;
			return; 
		}
		
		
		for (int i = 0; i<4;i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (!visit[nextX][nextY]) {
				visit[nextX][nextY] = true; 
				count ++;
				dfs(nextX,nextY,count,direction[i]*ret);  
				count --;
				visit[nextX][nextY] = false; 
			
			}
		}
		
		
	
	}
}



//dfs로 푸는 문제
