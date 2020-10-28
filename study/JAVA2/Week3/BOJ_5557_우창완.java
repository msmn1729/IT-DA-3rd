import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5557_¿ìÃ¢¿Ï {
	private static int n;
	private static int[] arr=new int[101];
	static int answer=0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String []temp= br.readLine().split(" ");
		n=Integer.parseInt(temp[0]);

		temp=br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		long [][] dp=new long[n][21];
		dp[0][arr[0]]=1;
		for(int i = 1; i < n - 1; i++){
            for(int j = 0; j <= 20; j++){
                if(dp[i - 1][j] != 0) {
                    if(j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i - 1][j]; 
                    if(j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i - 1][j];
                }
            }
        }
	
		System.out.println(dp[n-2][arr[n-1]]);
	}		
}
