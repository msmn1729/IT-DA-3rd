import java.util.Scanner;

public class Food {

	static int [][] mat;
	static boolean [][] visited;
	static int [] dx = {1, -1, 0, 0};
	static int [] dy = {0, 0, 1, -1};
	static int max = 0;
	static int cnt=0;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		int K = s.nextInt();
		
		
		
		mat = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<K; i++)
		{
			int x = s.nextInt();
			int y = s.nextInt();
			mat[x-1][y-1] = 1;
		}
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
			{
				if(mat[i][j] == 1 && visited[i][j] == false)
				{
					cnt = 0;
					DFS(i,j);
					if(max < cnt)
						max = cnt;
				}
			}
		
		System.out.println(max);
	}
	
	public static void DFS(int x, int y)
	{
		for(int i=0; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny<0 || nx>=N || ny>=M)
				continue;
			
			if(visited[nx][ny] == false && mat[nx][ny] == 1)
			{
				visited[nx][ny] = true;
				cnt++;
				DFS(nx,ny);
			}
			
		}
	}

}
