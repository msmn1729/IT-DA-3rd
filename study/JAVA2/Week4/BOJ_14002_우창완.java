import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_14002_¿ìÃ¢¿Ï {
	static int[] arr= new int[1001];
	static int[]dp=new int[1001];
	static int[]record=new int[1001];
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> answer = new ArrayList<>();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] temp= br.readLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		temp=br.readLine().split(" ");
		int length=1;
		int pnt=0;
		dp[0]=1;
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(temp[i]);
			dp[i]=1;
		}
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(arr[i]<arr[j]&&dp[i]+1>dp[j]) {
					dp[j]=dp[i]+1;
					if(length<dp[j]) {
						length=dp[j];
						pnt=j;
					}
					record[j]=i;
				}
			}
		}
		System.out.println(length);
		int size=length;
		while(length>0) {
			answer.add(arr[pnt]);
			pnt=record[pnt];
			length--;
		}
		Collections.sort(answer);
		for(int j=0; j<answer.size(); j++) {
			System.out.print(answer.get(j)+" ");
		}
	}

}
