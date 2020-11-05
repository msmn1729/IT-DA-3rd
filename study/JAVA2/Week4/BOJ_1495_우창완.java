import java.util.Scanner;

public class BOJ_1495_¿ìÃ¢¿Ï {

	public static void main(String[] args) {
		int n,s,m;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		s=sc.nextInt();
		m=sc.nextInt();
		int v[]=new int[n+1];
		int dp[][]=new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			v[i]=sc.nextInt();
		}
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m ; j++) {
				dp[i][j]=-1;
			}
		}
		dp[0][s]=s;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(j+v[i]<=m&&dp[i-1][j]!=-1)	dp[i][j+v[i]]=dp[i-1][j]+v[i];
				if(j-v[i]>=0&& dp[i-1][j]!=-1)	dp[i][j-v[i]]=dp[i-1][j]-v[i];
			}
		}
		for(int i=m; i>=0; i--) {
			if(dp[n][i]!=-1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
