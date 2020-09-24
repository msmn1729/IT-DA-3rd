import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static int[] arr=new int[101];
	static int answer=0;
	
	private static void dfs(int target, int sum, int cnt){
		if(cnt==n-1){
			if(sum==target) answer++;
			return;
		}
		if(sum<=20 &&sum>=0){
			dfs(target, sum+arr[cnt],cnt+1);
			dfs(target, sum-arr[cnt], cnt+1);
		}
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String []temp= br.readLine().split(" ");
		
		n=Integer.parseInt(temp[0]);
		temp=br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		int target=arr[n-1];
		dfs(target,0,0);
		System.out.println(answer);
	}

}
