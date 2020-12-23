import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11497_우창완 {
	//dp는 안써도된다
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n= Integer.parseInt(br.readLine());
			int arr[]=new int[n];
			int dp[]=new int[n];
			String []temp=br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[j]=Integer.parseInt(temp[j]);
			}
			Arrays.sort(arr);
			dp[0]=0;
			dp[1]=arr[1]-arr[0];
			for(int j=2; j<n; j++) {
				dp[j]=Math.max(dp[j-1], arr[j]-arr[j-2]);
			}
			System.out.println(dp[n-1]);
		}

	}

}
