package itda;
import java.io.*;
import java.util.*;


public class BOJ_1236_김민정 {

	public static int n,m;
	public static int cnt = 0;
	public static int[][] map;
	public static boolean[][] visited;
	public static int nowArea, maxArea ;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		map = new int[n+5][m+5];
		visited = new boolean[n][m];
		
		for(int i =0 ; i<n ; i++) {
			String[] input_map =br.readLine().split(" ");
			for(int j =0 ; j<m; j++) {
				map[i][j] = Integer.parseInt(input_map[j]);
			}
		}
		//picture is 0 in start.
		
		for(int i =0 ; i<n ; i++) {
			for(int j =0 ; j<m; j++) {
				//drawn picture check in dfs()
				if(map[i][j]==1 && !visited[i][j]){
					
					nowArea = 0;
					dfs(i,j);
					
					maxArea =( maxArea >nowArea) ? maxArea : nowArea;
					cnt++;
					
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxArea);
		
	}
	public static void dfs(int y, int x) {
		//find now area
		nowArea++;
		//check visited
		visited[y][x] = true;
		for( int i=0; i< dx.length ; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			//check new diration newX,newY in map
			if(0<= newY && newY < n && 0<= newX && newX < m ){
				if( !visited[newY][newX] && map[newY][newX]==1) {
						dfs(newY, newX);
				}
			}
		}
	}

}
