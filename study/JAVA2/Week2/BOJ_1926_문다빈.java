import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Draw {
	static int op_x[] = {0,0,1,-1};//동서남북
	static int op_y[] = {1,-1,0,0};//동서남북
	static int n;
	static int m;
	static int cnt = 0;
	static int max = 0;
	static int cnt2 = 0;
	static int map[][];
	static int visited[][];
	public static void main(String[] args) throws IOException {
		//전형적인 영역구하기 문제
		//dfs가 편하니 dfs로 품
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st1.nextToken());
		 }
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					cnt = 0;
					DFS(i,j);
					max = Math.max(cnt, max);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt2);
		System.out.println(max);
	}
	
	static void DFS(int x, int y) {
		int next_X = 0, next_Y = 0;
		visited[x][y] = 1;
		cnt++;
		for (int i = 0; i < 4; i++) {
			next_X = op_x[i] + x; next_Y = op_y[i] + y;
			if(next_X >= 0 && next_X < n && next_Y >= 0 && next_Y < m) {
				if (map[next_X][next_Y] == 1 && visited[next_X][next_Y] == 0) {
					DFS(next_X, next_Y);
				}
			}
		}
	}

}
