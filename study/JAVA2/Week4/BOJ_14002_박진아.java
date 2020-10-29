import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

/*
 * 
 * 문제
수열 A가 주어졌을 때, 
가장 긴 
증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 
길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다. 
그러한 수열이 여러가지인 경우 아무거나 출력한다. <-- ? 


6
10 20 10 30 20 50

4
10 20 30 50

[접근]

아악 방문한 인덱스 어떻게 저장해??
	
		// 1 6 2 4 5 3 7 -> arr
		// 1 2 2 3 4 3 5 -> dp
		// 0 1 1 3 4 3 5 -> v에 저장된 값 
		// 0   1 3 4   5 -> rs에 저장된 값
		
아 괴로워 
... 포기 ㅎㅎ

 */
public class Q14002 {

	static int[] arr = new int[1001];
	static int[] dp = new int[1001];
	static int[] v = new int[1001]; 
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int A=0;
		A=Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		for(int i=1;i<=A;i++) {
			arr[i]=Integer.parseInt(input[i-1]);
		}
		
		for(int i=1;i<=A;i++) {
			int max = 0; //dp[j]의 최대값 판별 ... 
			dp[i]=1;
			
			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j] && max<dp[j]) {
					max = dp[j];
					v[i]=j;
				}
			}
			dp[i] = max+1;
			cnt=Math.max(cnt, dp[i]);
		}
	
		HashSet <Integer>rs = new HashSet<Integer>();
		for(int i=A;i>=1;i--) {
			if(v[i]==cnt) {
				for(int j=i;j>=1;j--) {
					if(v[j]>=v[j-1]) {
						rs.add(v[j]);
						System.out.print(j+" ");
					}
				}
			}
		}
		System.out.println();
		
		Iterator it=rs.iterator();
		String ans ="";
		while(it.hasNext()){
			int index = (int)it.next();
			if(index==0) {continue;}
			ans+=arr[index]+" "; //0 1 3 4 5 
		}
		for(int i=1;i<=A;i++) {
			if(dp[i]==cnt) {
				ans+=arr[i];
			}
		}
		System.out.println(cnt);
		System.out.println(ans);
	}

}
