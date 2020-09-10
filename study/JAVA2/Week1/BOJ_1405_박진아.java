package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1405 {
/*
 * 각 행동에서 로봇은 4개의 방향 중에 하나를 임의로 선택한다. 
 * 그리고 그 방향으로 한 칸 이동한다.
 * 로봇이 같은 곳을 한 번보다 많이 이동하지 않을 때, 
 * 로봇의 이동 경로가 단순하다고 한다. 
 * (로봇이 시작하는 위치가 처음 방문한 곳이다.) 
 * 로봇의 이동 경로가 단순할 확률을 구하는 프로그램을 작성하시오. 
 * 예를 들어, EENE와 ENW는 단순하지만, 
 * ENWS와 WWWWSNE는 단순하지 않다. (E는 동, W는 서, N은 북, S는 남)
 * 
 * 
 * 
 * 첫째 줄에 
 * N, 
 * 동쪽으로 이동할 확률, 
 * 서쪽으로 이동할 확률, 
 * 남쪽으로 이동할 확률, 
 * 북쪽으로 이동할 확률이 주어진다.
 *  N은 14보다 작거나 같은 자연수이고,  
 *  모든 확률은 100보다 작거나 같은 자연수 또는 0이다. 
 *  그리고, 동서남북으로 이동할 확률을 모두 더하면 100이다.
 *  
 *  2 25 25 25 25
 *  
 *  못풂 
 * 
 *  [접근]
 *  단순한 이동경로 : 지나간 곳을 지나가지 않음 
 *  단순한 이동경로 : 4*3 / 총 이동 경로 : 4*4 = 0.75 ?
 *  
 *  단순한 이동경로의 수는 dfs로 구할 수 있을거같음
 *  dfs의 탐색 깊이 = n 
 *
 *  이동할 확률은 어떻게 따지면 좋을까
 *  으음 
 *  이동할때마다 확률 곱하면 될까 ? ...
 *  
 *  동서남북에서 출발할때
 *  dfs로 갈 수 있는 이동경로를 탐색하고 
 *  확률을 곱하기
 *  그 후 동서남북 확률 모두 더하면 되지 않나  
 *  
 */
	
	static int dx[]= {-1,0,0,1}, dy[]= {0,-1,1,0};
	static int n;
	static Direction E;
	static Direction W;
	static Direction S;
	static Direction N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] =br.readLine().split(" ");
		long result=0;
		int map [][] = new int [15][15];
		
		n = Integer.parseInt(input[0]);
		long Epercent = Integer.parseInt(input[1])/100;
		long Wpercent = Integer.parseInt(input[2])/100;
		long Spercent = Integer.parseInt(input[3])/100;
		long Npercent = Integer.parseInt(input[4])/100;
		
		 E = new Direction('E',Epercent);
		 W = new Direction('W',Wpercent);
		 S = new Direction('S',Spercent);
		 N = new Direction('N',Npercent);
		
		
		int depth=0; long tresult =1; int x =0; int y=0;
		map[0][0]=1;
		
		result += dfs(E,depth,map,tresult,x,y);
		result += dfs(W,depth,map,tresult,x,y);
		result += dfs(S,depth,map,tresult,x,y);
		result += dfs(N,depth,map,tresult,x,y);
		
		System.out.println(result);
		
		
	}

	private static long dfs(Direction e, int depth, int map[][], long result, int x, int y) {
		if(depth==n) {
			return result;
		}
		depth++;
		Postion postion = returnPostion(e);
		x += postion.x;
		y += postion.y;
		map[y][x]=1;
		
		long percent = e.percent;
		result =  result * percent;
		
		for(int i=0;i<4;i++) {
			int nextx=x+dx[i];
			int nexty=y+dy[i];
			
			if(0<=nextx && nextx<map.length && 0<=nexty && nexty<map.length) {
				if(map[nexty][nextx]==0) {
					dfs(nextDirection(nextx,nexty), depth, map, result, nextx, nexty);
				}
			}
		}
		
		
		
		
		return 0;
	}

	
	private static Direction nextDirection(int x, int y) {
		Direction direction =null;
		
		if(x==1&&y==0) {
			direction = E;
		}
		if(x==-1&&y==0) {
			direction = W;
		}
		if(x==0&&y==-1) {
			direction = S;
		}
		if(x==0&&y==1) {
			direction = N;
		}
		
		return direction;
		
	}
	
	private static Postion returnPostion(Direction e) {
		char nextDirection = e.direction;
		Postion position = new Postion(0,0);
		switch (nextDirection) {
			case 'E':
				position.x=1;
				position.y=0;
				return position;
			case 'W':
				position.x=-1;
				position.y=0;
				return position;
			case 'S':
				position.x=0;
				position.y=-1;
				return position;
			case 'N':
				position.x=0;
				position.y=1;
				return position;
		}
		return null;
	}
}
	
	class Postion{
		int x;
		int y;
		
		public Postion(int x, int y) {
			this.x =x;
			this.y=y;
		}
	}
	
	class Direction{
		char direction;
		long percent;
		
		public Direction(char direction, long percent) {
			this.direction = direction;
			this.percent = percent;
		}
	}
	
