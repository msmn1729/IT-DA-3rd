package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 벽의 개수 3개!  
 * 
 * 0은 빈 칸 
 * 1은 벽
 * 2는 바이러스가 있는 곳
 * 
 *  벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
 *  
 *  
 *  1) 벽 뚫린 곳 조사
 *  2) 벽 어떻게 세우지... 
 *  	대각선 유효 ...  
 *  3) 바이러스 퍼뜨리기 
 *  
 *  
 */

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}


public class Q14502 {

	static int[][] map = new int[8][8];
	static boolean[][] visited = new boolean[8][8];
	static int n,m=0;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);  m = Integer.parseInt(input[1]);
		
		for(int i=0;i<n;i++) {
			input=br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(input[j]);
			}
		}
	}

	public void makeWall(int[][] tmp) {
		//DFS?? 
		//
		
		tmp = map;
		
		spreadVirus(tmp);
	}
	
	
	public void spreadVirus(int[][] tmp){
		
		Queue<Pos> Q = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==2) {
					Pos v = new Pos(i,j);
					Q.add(v);
				}
			}
		}
		
		while(!Q.isEmpty()) {
			Pos p = Q.poll();
			int curX=p.x;
			int curY=p.y;
			
			for(int i=0;i<4;i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				if(0<=nextX&&nextX<=8 && 0<=nextY&&nextY<=8) {
					if(tmp[nextX][nextY]==0) {
						tmp[nextX][nextY]=2;
						Pos np = new Pos(nextX,nextY);
						Q.add(np);
					}
				}
			}
		}
		
		int safeZone = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(tmp[i][j]==0) {
					safeZone +=1;
				}
			}
		}
	}
}
