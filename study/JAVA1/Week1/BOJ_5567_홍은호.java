import java.util.Scanner;

public class Wedding {

	public static void main(String[] args) {
		int result = 0;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		boolean[] visited = new boolean[n+1];
		int[][] mat = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) //그래프 작성
		{
			int f1 = s.nextInt();
			int f2 = s.nextInt();
			mat[f1][f2] = mat[f2][f1] = 1;
		}
			
		for(int i=2; i<=n; i++)
		{
			if(mat[1][i] == 1)
			{
				if(!visited[i])
				{
					visited[i] = true;
					result++;
				}
				
				for(int j=2; j<=n; j++)
				{
					if(mat[i][j] == 1 && visited[j] == false)
					{
						visited[j] = true;
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
		
	}

}
