import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Trip {
	static int Map[][];
	static int visited[];
	static int count = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		// dfs문제인거신가..?
		// 더 이상의 자세한 설명은 생략한다.
		
		int T;
		int a;
		int b;
		int M;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			visited = new int[N+1];
			Map = new int[N+1][N+1];
			M = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < M; j++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st1.nextToken());
				b = Integer.parseInt(st1.nextToken());
				
				Map[a][b] = 1;
				Map[b][a] = 1;
			}
			dfs(1);
			System.out.println(count);
			count = 0;
		}

	}
	
	static void dfs(int idx) {
		visited[idx] = 1;
		for(int i = 1 ; i <= N ; i++) {
			if(Map[idx][i] == 1 && visited[i] == 0) {
				count++;
				dfs(i);
			}
		}
	}

}
