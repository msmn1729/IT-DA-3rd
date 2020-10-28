import java.util.Scanner;

public class Route {
	
	public static int map[][];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int K = s.nextInt();
		
		map = new int[N][M];
		map[0][0] = 1;
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
			{
				if(i==0 || j==0)
				{
					map[i][j] = 1;
				}
				else
				{
					map[i][j] = map[i-1][j] + map[i][j-1];
				}
			}
		
		if(K == 0)
		{
			System.out.println(map[N-1][M-1]);
		}
		
		else
		{
			int x = K / M;
			int y = K % M - 1;
			
			int tmpx = N - 1 - x;
			int tmpy = M - 1 - y;
			
			int result = map[x][y] * map[tmpx][tmpy];
			System.out.println(result);
		}
		
	}
}
