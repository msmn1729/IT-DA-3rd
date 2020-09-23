package backjoon.study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1학년 https://www.acmicpc.net/problem/5557
/*
 상근이가 1학년 때, 덧셈, 뺄셈을 매우 좋아했다. 상근이는 숫자가 줄 지어있는 것을 보기만 하면, 마지막 두 숫자 사이에 '='을 넣고, 
 나머지 숫자 사이에는 '+' 또는 '-'를 넣어 등식을 만들며 놀고 있다. 예를 들어, 
 "8 3 2 4 8 7 2 4 0 8 8"에서 등식 "8+3-2-4+8-7-2-4-0+8=8"을 만들 수 있다.
 상근이는 올바른 등식을 만들려고 한다. 상근이는 아직 학교에서 음수를 배우지 않았고, 20을 넘는 수는 모른다. 
 따라서, 왼쪽부터 계산할 때, 중간에 나오는 수가 모두 0 이상 20 이하이어야 한다. 
 예를 들어, "8+3+2-4-8-7+2+4+0+8=8"은 올바른 등식이지만, 8+3+2-4-8-7이 음수이기 때문에, 상근이가 만들 수 없는 등식이다.
 숫자가 주어졌을 때, 상근이가 만들 수 있는 올바른 등식의 수를 구하는 프로그램을 작성
 첫째 줄에 숫자의 개수 N이 주어진다. (3 ≤ N ≤ 100) 둘째 줄에는 0 이상 9 이하의 정수 N개가 공백으로 구분해 주어진다.
 상근이가 만들 수 있는 올바른 등식의 개수를 출력한다. 이 값은 2^63-1 이하
 
 처음엔 dfs가 아닌가 생각했다. 어떻게 dp로 풀어야 할까, 2차원 dp배열? 첫번째는 자리고 두번째는 + or - 로?
 ++, +-, -+, -- 의 경우로? [N][4] 사이즈의 2차원 배열? 당연히.. 모든 경우를 볼 수가 없다.. 
 그럼 힌트는 20을 넘는 수는 모른다는 것 인데.. / 2차원 배열이되, 첫번째는 숫자의 '위치'가 맞고 두번째 자리는 20 숫자 
 - + 해봤자 20을 넘을 수가 없다는 것 
 */
public class FirstGrade {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(BR.readLine());
		StringTokenizer ST = new StringTokenizer(BR.readLine(), " ");
		int input[] = new int[N];
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(ST.nextToken());
		
		/////////////////////////////////////////////////////////////////////////
		
		long[][] dp = new long[N - 1][21];
        dp[0][input[0]] = 1;
        for(int i = 1; i < N - 1; i++){ // N 자리는 어짜피 '=' 이 나와야하는 자리임 (즉 목표 자리 값) 
            for(int j = 0; j < 21; j++){
                if(dp[i - 1][j] != 0) {
                    if(j + input[i] <= 20) dp[i][j + input[i]] += dp[i - 1][j]; 
                    if(j - input[i] >= 0) dp[i][j - input[i]] += dp[i - 1][j];
                }
            } // inner for 
        } // for
		
        System.out.println(dp[N - 2][input[N - 1]] + "\n");
	}
}
