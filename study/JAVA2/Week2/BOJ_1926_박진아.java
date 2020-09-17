import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 어떤 큰 도화지에 그림이 그려져 있을 때, 
 * 그 그림의 개수와, 
 * 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 
 * 
 * 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 
 * 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 
 * 그림의 넓이란 그림에 포함된 1의 개수이다.
 * 
 * 입력
 * 첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 
 * 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 
 * 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. 
 * (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 
 * 1은 색칠이 된 부분을 의미한다)

 * 출력
 * 첫째 줄에는 그림의 개수, 
 * 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 
 * 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
 * 
 * [접근]
 * 500*500 의 map  
 * 가로 세로로 인접한 것만 그림 
 * 
 */

public class Q1926 {
	
	static int map[][] = new int [501][501];
	static boolean visited[][] = new boolean [501][501];
	
	static int max = 0; // 그림의 최대값 
	static int n,m;
	static int size=0;
	
	
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		n = Integer.parseInt(input[0]); //세로 
		m = Integer.parseInt(input[1]); //가로 
		
		int pictures=0;//그림의 수 
		
		for(int i=1;i<=n;i++) {
			input=br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(input[j-1]);
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==1 && visited[i][j]==false) {
					Dfs(j,i);
					pictures++;
				}
				size=0;
			}
		}
		
		System.out.println(pictures);
		System.out.println(max);
		
	}
	
	public static void Dfs(int x, int y) {
		
		max=Math.max(max, size);
		
		visited[y][x]=true;
		for(int i=0;i<4;i++) {
			int nextx = x+dx[i];
			int nexty= y+dy[i];
			
			//map범위 확인 
			if(1<=nextx && 1<=nexty && nextx<=m && nexty<=n) {
				
				if(map[nexty][nextx]==1&&visited[nexty][nextx]==false) {
					size+=1;
					Dfs(nextx,nexty);
				}
			}
			
		}
	}

}
