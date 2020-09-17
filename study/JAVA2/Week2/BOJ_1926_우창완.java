import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1926_¿ìÃ¢¿Ï {
	private static int n,m;
	private static int [][]map;
	private static boolean [][]check;
	private static int ans=1;
	private static int[] dx= {1,0,-1,0};
	private static int[]dy= {0,1,0,-1};
	private static class Pair{
		int x,y;
		Pair(int y, int x){
			this.x=x;
			this.y=y;
		}
	}
	
	private static int dfs(int y, int x) {
		int answer=0;
		check[y][x]=true;
		dfs()
	}
	private static int bfs(int y, int x) {
		int answer=0;
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(y,x));
		check[y][x]=true;
		while(!q.isEmpty()) {
			answer++;
			int x1=q.peek().x;
			int y1=q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int nx= x1+dx[i];
				int ny= y1+ dy[i];
				if(!check[ny][nx]&& nx>=0 && ny>=0 && nx<m &&ny<n) {
					q.add(new Pair(ny,nx));
					check[ny][nx]=true;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String []temp=br.readLine().split(" ");
		n=Integer.parseInt(temp[0]);
		m=Integer.parseInt(temp[1]);
		map=new int[n+1][m+1];
		check=new boolean[n+1][m+1];
		for(int i=0; i<n; i++) {
			temp=br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(temp[j]);
			}
		}
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1&& !check[i][j]) {
					ans=Math.max(ans, bfs(i,j));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(ans);
	}
	
}
