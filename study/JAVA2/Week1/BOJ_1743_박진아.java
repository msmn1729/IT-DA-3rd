
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 
 * 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 
 * 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 
 * 
 * 이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 
 * 가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다. 

 * 통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. 
 * 선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.

 * 입력
 * 첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 
 * 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ 10,000)이 주어진다.  
 * 그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.
 * 
 * 좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다.
 * 
3 4 5
3 2
2 2
3 1
2 3
1 1
 * 
 * [접근]
 * 
 * dfs로 상하좌우로 이어진 쓰레기의 개수를 세면 될듯
 * 
 * 
 */
public class Q1743 {
	static int map[][] = new int[101][101];
	static boolean visited[][] = new boolean [101][101];
	
	static int dx[]= {-1,0,0,1}; 
	static int dy[]= {0,-1,1,0};
	
	static int trash = 1; // 최종 result 값 
	static int t=1; // dfs 에서 사용될 쓰레기 
	
	static int n,m;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		
		n = Integer.parseInt(input[0]); // 세로 
		m = Integer.parseInt(input[1]); // 가로 
		int k = Integer.parseInt(input[2]);
		
		
		for(int i=0; i<k; i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			
			map[r][c]=1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==1) {
					dfs(i,j);
				}
				t=1; // t값을 1로 초기화
			}
		}
		
		System.out.println(trash);
	
	}
	// r -- n
	// c -- m 
	
	
	private static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		trash = Math.max(trash, t);
		
		t += 1;
		
		for(int i=0;i<4;i++) {
			
			int nextr = r+ dx[i];
			int nextc = c+ dy[i];
			
			
			if(1<=nextr && nextr<= n && 1<= nextc && nextc<=m) {
				if(map[nextr][nextc] == 1 && visited[nextr][nextc] ==false) {
					dfs(nextr,nextc);
				}
			}
		}
	}
	
}
