package backjoon.study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//공통부분문자열 https://www.acmicpc.net/problem/5582
/*
 두 문자열이 주어졌을 때, 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열을 찾는 프로그램을 작성하시오.
 어떤 문자열 s의 부분 문자열 t란, s에 t가 연속으로 나타나는 것을 말한다. 
 예를 들어, 문자열 ABRACADABRA의 부분 문자열은 ABRA, RAC, D, ACADABRA, ABRACADABRA, 빈 문자열 등이다. 
 하지만, ABRC, RAA, BA, K는 부분 문자열이 아니다.
 두 문자열 ABRACADABRA와 ECADADABRBCRDARA의 공통 부분 문자열은 CA, CADA, ADABR, 빈 문자열 등이 있다. 
 이 중에서 가장 긴 공통 부분 문자열은 ADABR이며, 길이는 5이다. 
 또, 두 문자열이 UPWJCIRUCAXIIRGL와 SBQNYBSBZDFNEV인 경우에는 가장 긴 공통 부분 문자열은 빈 문자열이다.
 첫째 줄과 둘째 줄에 문자열이 주어진다. 문자열은 대문자로 구성되어 있으며, 길이는 1 이상 4000 이하이다.
 첫째 줄에 두 문자열에 모두 포함 된 부분 문자열 중 가장 긴 것의 길이를 출력한다.
 
 LIS(가장 긴 증가 부분 수열) 알고리즘 생각남! 숫자 -> 문자열로 바뀌면서 '증가'의 개념이 아님 / 
 부분 문자열을 어떻게 구하지? LCS? 알고리즘? LIS랑 비슷하지 않을까 풀어본적은 없는데.. /
 LCS는 x, y가 있을때 (x or y)특정 string 기준으로 2중 포문으로 
  - 다를때 dp 값 dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]); // 
  - 같을때 dp[i][j] = dp[i - 1][j - 1] + 1 (길이카운터)로 가능하다 
  
 큰놈을 기준으로 LCS알고리즘을 돌린다면? 
 */
public class CommonPartialString {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String a = BR.readLine();
		String b = BR.readLine();
		
		// 더 큰걸 무조건 a 로 만들기!! 
		if(a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		
		int[][] dp = new int[a.length() + 1][b.length() + 1]; // 각 문자열의 길이만큼 선언
		for(int i = 1; i <= a.length(); i++) { // i = a index
			for(int j = 1; j <= i; j++) { // j = b index
				
				if(j >= b.length()) break;
				
				// 다를 경우 
				if(a.charAt(i - 1) != b.charAt(j - 1)) dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); // 점화식
				else dp[i][j] = dp[i - 1][j - 1] + 1; // 점화식
				System.out.println(dp[i][j]);
			}
		}
		
//		// Type One
//		int d[] = new int[n];
//		d[0] = 1;
//		for (int i = 1; i < n; i++) {
//			d[i] = 1;
//			for (int j = 0; j < i; j++) {
//				if (arr[j] < arr[i] && d[i] <= d[j]) d[i] = d[j] + 1;
//			}
//		} // for 
//		
//		int max = 0;
//		for (int i : d) max = Math.max(max, i);
//		System.out.println(max);
		
		
		System.out.println(dp[a.length()][b.length()]);
	}
}
