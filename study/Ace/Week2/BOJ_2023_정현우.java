package backjoon.study.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 신기한 소수 https://www.acmicpc.net/problem/2023
/*
 수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
 7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 
 수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다. / N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
 
 2초 4 MB / 메모리 제한 있는 이유가 DP를 못하게 하려고 4mb구나 ㅋㅋㅋㅋ 
 그냥 시뮬레이션 처럼 반복문으로 접근했더니 오버헤드 너무 발생, 시간 초과, 8자리 같은 경우에는 
 8(100,000,000) -> 7(10,000,000) ... 까지 다 한 자리 마다 봐야함,  
 자리수 다 만들고, 쪼개면서 접근하는 게 아니라, 
 1의 자리수 부터 소수 인 것 부터 뒤에 붙이면서 접근하는게 시간 단축상 올바른 접근인 것 같음 
 */
public class AmaginPrimeNumber {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static boolean isPrime(int target) {
		if (target == 1) return false;
		for (int i = 2; i <= (int) Math.sqrt(target); i++) {
			if (target % i == 0) return false;
		}
		return true;
	}
	
	public static void dfs(int target, int depth) {
		if (depth == N) sb.append(target + "\n");
		else {
			// 자리수가 N이 될때까지 소수인 것을 뒤에 i를 붙여서 다시 재귀
			for (int i = 1; i <= 9; i++) {  
				if (isPrime(target * 10 + i)) {
					dfs(target * 10 + i, depth + 1);
				}
			} // for 
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		dfs(0, 0);
		System.out.println(sb.toString());
	}
	
	// 부르트포스
	/*
	public static boolean isPrime(String target_) {
		int target = Integer.parseInt(target_);
		if(target == 1) return false;
		for (int i = 2; i <= (int) Math.sqrt(target); i++) {
			if(target % i == 0) return false;
		}
		return true;
	}
	
	public static boolean isPrime(int target) {
		if(target == 1) return false;
		for (int i = 2; i <= (int) Math.sqrt(target); i++) {
			if(target % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int range = (int) Math.pow(10, N - 1); // N 부터 (N * 10) - 1
		StringBuilder SB = new StringBuilder();
		
		for (int target = range; target < (range * 10 - 1); target++) {
			if(isPrime(target)) { // 전체 숫자가 소수 인지 아닌지 
				// System.out.println(target);
				boolean isAllPrime = true;
				for (int i = 1; i < N; i++) { // 각 자리수를 하나씩 떼어내서 소수인지 아닌지 
					// System.out.println(Integer.toString(target).substring(0, N - i));
					if(!isPrime(Integer.toString(target).substring(0, N - i))) {
						isAllPrime = false;
						break;
					}
				} // inner for
				if(isAllPrime) SB.append(target + "\n");
			} // if 
		} // for 
		
		System.out.println(SB);
	}
	*/
}
