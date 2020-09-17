import java.util.Scanner;

public class Main {

	public static int n,m;
	public static int [][] map;
	public static boolean [][] visited;
	public static int [] dx = {0,1,-1,0,0};
	public static int [] dy = {0,0,0,1,-1};
	public static int count;
	public static int vol;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		map = new int[501][501];
		visited = new boolean [n][m];
		count = 0;
		vol = 0;
		int max = 0;
		int pcount = 0;
		
		for(int i=0; i<n; i++)
			for(int j=0;j<m;j++)
			{
				map[i][j] = s.nextInt();
			}
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
			{
				if(visited[i][j] == false && map[i][j] == 1)
				{
					pcount++;
					count = 0;
					DFS(i,j);
					if(max < count)
						max = count;
				}
			}
		if(pcount == 0)
        {}
		System.out.println(pcount);
		System.out.println(max);
	}
	
	public static void DFS(int x, int y)
	{
		for(int i=0; i<5; i++)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx >= n || ny >= m)
				continue;
			
			if(visited[nx][ny] == false && map[nx][ny] == 1)
			{
				visited[nx][ny] = true;
				count++;
				DFS(nx,ny);
			}
		}
	}
}
