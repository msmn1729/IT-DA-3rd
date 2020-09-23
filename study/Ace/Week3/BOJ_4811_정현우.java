package backjoon.study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알약 https://www.acmicpc.net/problem/4811
/*
 70세 박종수 할아버지는 매일 매일 약 반알을 먹는다. 손녀 선영이는 종수 할아버지에게 약이 N개 담긴 병을 선물로 주었다.
 첫째 날에 종수는 병에서 약 하나를 꺼낸다. 그 다음, 그 약을 반으로 쪼개서 한 조각은 먹고, 다른 조각은 다시 병에 넣는다.
 다음 날부터 종수는 병에서 약을 하나 꺼낸다. (약은 한 조각 전체 일 수도 있고, 쪼갠 반 조각 일 수도 있다) 
 반 조각이라면 그 약을 먹고, 아니라면 반을 쪼개서 한 조각을 먹고, 다른 조각은 다시 병에 넣는다.
 종수는 손녀에게 한 조각을 꺼낸 날에는 W를, 반 조각을 꺼낸 날에는 H 보낸다. 손녀는 할아버지에게 받은 문자를 종이에 기록해 놓는다. 
 총 2N일이 지나면 길이가 2N인 문자열이 만들어지게 된다. 이때, '가능한 서로 다른 문자열의 개수'는 총 몇 개일까?
 입력은 최대 1000개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄이며, 병에 들어있는 약의 개수 N ≤ 30 가 주어진다.
 입력의 마지막 줄에는 0이 하나 주어진다.
 
 어떻게 이런 문제를 만들며 어떻게 이런 문제가 dp인걸 알까 미친놈들 / 일단 N이 작다. 솔직히 dp로 전혀 감이 안잡힌다 
 얘도 2차원 배열로 접근할 수 있을까? [day(N)][약의 개수 0 ~ N] 의 사이즈로? 처음엔 무조건 한 알 일꺼다
 그 다음엔 한알 또는 반알 일 수 있다? / 문제를 이해하는 것도 솔직히 힘드네, 첫날엔 무조건 W아닌가? 
 시작 아이디어를 도저히 감이 안잡혀서 찾아봤다... / 
 
 N = 1 ; 큰 알약을 하나 먹고, 작은 알약을 하나 먹는 WH 방법 / 1 케이스 
 N = 2 ; 작은 알약 -> 큰 알약 / 큰 알약 -> 작은 알약 / 2 케이스 // WWHW / WWWH // WHHH (말이 안댐)  
 N = 3 ; 작은 알약 -> 큰 알약 -> 큰 알약 / 3케이스 // 작은 알약을 먹고나면, 큰 알약 2개가 남는데, dp[2] = 2 가지와 동일 / dp[0] * dp[2]
 		 큰 알약 -> 작은 알약 -> 큰 알약 // ==> 큰 알약 이후에는 작은 알약 -> 작은 알약 -> 큰 알약 / dp[1] * dp[1]
 		 큰 알약 -> 큰 알약 -> 작은 알약 // 앞에 큰 알약 2개는 dp[2] = 2가지 / 작은 알약은 케이스를 구분하는 데 영향을 끼치지 않으므로 2가지
 		 ==> dp[2] * dp[0] / 총 5가지
 k번째 알약의 문자열 개수를 구하는 방법은 합이 N - 1로 나누어지는 두 요소 i, j를 찾고, dp[i] * dp[j] 를 한 값을 dp[k]에 저장하는 것
 dp[k] = dp[i] * dp[N - 1 - i] 
 */
public class Pill {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		// 30까지니까 그냥 dp[30]까지 다 구해놓자 
		long[] dp = new long[31];
		dp[0] = 1; dp[1] = 1; dp[2] = 2;
		for (int i = 3; i <= 30; i++) {
			long cnt = 0;
			for (int j = 0; j < i; j++) //  
				cnt += dp[j] * dp[i - 1 - j];
			dp[i] = cnt;
		}

		int N;
		StringBuilder SB = new StringBuilder();
		while ((N = Integer.parseInt(BR.readLine())) != 0) SB.append(dp[N] + "\n");
		System.out.println(SB);
	}
}
