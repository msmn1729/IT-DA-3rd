import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoodA {
	static int op_X[] = {1,-1,0,0};//동서남북 x좌표
	static int op_Y[] = {0,0,-1,1};//동서남북 y좌표
	static int map[][];//계단의 상태를 나타내는 이차원 배열
	static int visited[][];//방문했는 지 안했는 지 체크해서 한 덩어리로 묶어줄 것!
	static int m, n;
	static int cnt;//영역의 크기 변수 구하는 변수

	public static void main(String[] args) throws IOException {
		// 코드 짜기 간편한 DFS
		// 덩어리가(근처에 있는 쓰레기를 다 방문) 되는 것을 다 찾는 방식으로 코드를 짭시다.
		// 한 덩어리를 찾으면 그 다음 덩어리를 찾아나가는 식으로 코딩하면 됩니다.
		// 시간제한은 2초로 넉넉합니다.
		// list에 덩어리의 크기들을 모아 오름차순 정렬한 다음 가장 큰 크기(맨 뒤)를 출력합니다.
		int k;
		int r, c;
		ArrayList<Integer> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st1.nextToken());
			c = Integer.parseInt(st1.nextToken());
			map[r][c] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					cnt = 1;
					DFS(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
	}
	
	static void DFS(int y, int x) {
		int next_x, next_y;
		visited[y][x] = 1;
		for(int i = 0; i < 4 ; i++) {
			next_y = y + op_Y[i];
			next_x = x + op_X[i];
			if(next_x > 0 && next_x <= m && next_y > 0 && next_y <= n)
				if (map[next_y][next_x] == 1 && visited[next_y][next_x] == 0) {
					cnt++;
					DFS(next_y, next_x);
				}
		}
	}

}
