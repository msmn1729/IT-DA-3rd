import java.util.Scanner;

public class CrazyRobot {

	static double ans = 0;
	static int n;
	static double [] pt;
	static boolean [][] visited;
	static int[] row = {0,0,1,-1};
	static int[] col = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		pt = new double[4];
		
		
		for(int i=0; i<4; i++)
			pt[i] = s.nextDouble() * 0.01;
		
		
		visited = new boolean[30][30];
		visited[15][15] = true;
		int r=15, c=15;
		DFS(r,c,0,1);
		
		System.out.println(ans);	
	}
	
	public static void DFS(int x, int y, int cnt, double per)
	{
		
		if(cnt == n) {
			ans += per;
			return;
		}

		for(int i=0; i<4; i++)
		{
			int dx = x + col[i];
			int dy = y + row[i];
			
			if(!visited[dx][dy])
			{
				visited[dx][dy]=true;
				DFS(dx,dy,cnt+1,per*pt[i]);
				visited[dx][dy]=false;
			}
		}

	}

}
