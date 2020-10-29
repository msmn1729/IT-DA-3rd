import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
/*

예제 입력 1 
5
5 2 4 1 3


[접근]
* 양 쪽의 수의 차를 조사해 순서를 정하는 방법 -> 이동하는 기준을 설정할 수 없음 
* 구글링 결과 +1인 수열의 길이를  n에서 빼면 된다네 
* [https://mygumi.tistory.com/276]
* 
* 5 2 4 1 3 
* 1 1 2 1 2
* 4는 연속되는 수열이니까 5,1,3만 위치를 바꾸면 됨 
* 즉 3회만 이동하면 됨!
* 
 */
	static int[] arr = new int [1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		int dp[]= new int[1000001];
		int max =0;
		
		int index=0;
		for(int i=1;i<=n;i++) {
			index=Integer.parseInt(input[i-1]);
			dp[index]=dp[index-1]+1;
			max=Math.max(max, dp[index]);
		}
		
		System.out.println(n-max);
		
		/* 시간초과 나는 코드 
		for(int i=1;i<=n;i++) {
			dp[i]=1;
			
			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
			max= Math.max(max, dp[i]);
		}
		System.out.println(n-max);
	*/
	}
}
