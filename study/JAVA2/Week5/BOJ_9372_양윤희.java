package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


//가중치 없는 최단 거리 구하기 - bfs

class Main9 {
	static int N,M,cnt;
    static boolean visit[];
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        arr = new int[N+1][N+1];
	        visit = new boolean[N+1]; 
            cnt = 0;

	        for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()); //비행 경로를 이차원 배열로 연결해줌
                int v = Integer.parseInt(st.nextToken());
                arr[u][v] = 1;
                arr[v][u] = 1;
	        }
	        bfs(); 
	        System.out.println(cnt-1);
		}
		

	}
	 private static void bfs() {
	        Queue<Integer> queue = new LinkedList<Integer>();
	        queue.add(1); //1부터 찾긔
	        visit[1] = true;
	        while(!queue.isEmpty()) {
	        	cnt++;
	            int val = queue.poll();
	            for(int i=1; i<=N; i++) {
	                if(arr[val][i]==1 && !visit[i]) { //방문하지 않은 비행경로가 있는 나라일 경우 
	                    visit[i] = true;
	                    queue.add(i);
	                }
	            }
	        }
	    }
}

