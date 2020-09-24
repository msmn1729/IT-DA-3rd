package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main4 {
	static int dx[] = {-1,1,0,0}; //x죄표
	static int dy[] = {0,0,-1,1}; //y좌표
	
	
	static int map[][];
	static int visited[][];
	static int n,m, cnt, mark=1;
	static ArrayList<Integer> res = new ArrayList<Integer>();
	static Queue<pos> q = new LinkedList<>();

	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
	
	
		map = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		for(int i=0; i<n; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
		bfs();
		System.out.println(mark - 1);
		System.out.println(Collections.max(res)); //최댓값 가져오기
	}
	
	public static void bfs() {

		for(int i =0 ; i< m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					cnt = 1; //그림 내의 그림 넓이를 count하기 위한 변수
					mark++; //그림 번호
					q.add(new pos(i,j));
					map[i][j] = mark;
					
					while(!q.isEmpty()) {
						
						pos now  = q.poll();
						
						for(int d = 0; d<4; d++) {
							int xx = now.x + dx[d]; //상하좌우 탐색
							int yy = now.y + dy[d];
							
							//map의 범위를 벗어나면 pass
							if(xx<0 || yy<0 || xx>=m || yy>=n ) continue;
							//그림이 없거나, 다른 그림으로 지정됐으면 pass
							if(map[xx][yy] !=1 )continue;
							
							//그림으로 포함시키기
							map[xx][yy] = mark; 
							cnt++;
							q.add(new pos(xx,yy)); //이 위치에서 또 상하좌우 탐색
						}
					}
					res.add(cnt); //
				}
			}
	}		
}
	
	
	static public class pos{ //현재 방문 하는 곳의 좌표를 저장하기 위한 구조페
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
