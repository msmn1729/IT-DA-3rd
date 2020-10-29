import java.util.Scanner;

public class Q4811 {
	/*
	 * 문제 70세 박종수 할아버지는 
	 * 
	 * 
	 * 매일 매일 약 반알을 먹는다. 
	 * 약이 N개 담긴 병을 선물로 주었다.
	 * 한 알을 이틀에 걸쳐 먹음 
	 * (약은 한 조각 전체 일 수도 있고, 쪼갠 반 조각 일 수도 있다) 반 조각이라면 그 약을
	 * 먹고, 아니라면 반을 쪼개서 한 조각을 먹고, 다른 조각은 다시 병에 넣는다.)
	 * 
	 * 종수는 손녀에게 한 조각을 꺼낸 날에는 W를, 반 조각을 꺼낸 날에는 H 보낸다. 
	 * 손녀는 할아버지에게 받은 문자를 종이에 기록해 놓는다.
	 * 
	 * 총 2N일이 지나면 길이가 2N인 문자열이 만들어지게 된다. 이때, 가능한 
	 * 
	 * 서로 다른 문자열의 개수는 총 몇 개일까?
	 * 
	 * 
	 * 입력 입력은 최대 1000개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄이며, 병에 들어있는 약의 개수 N ≤ 30 가
	 * 주어진다.
	 * 
	 * 입력의 마지막 줄에는 0이 하나 주어진다.
	 * 
	 * 출력 각 테스트 케이스에 대해서 가능한 문자열의 개수를 출력한다.
	 * 
	 * 
	 * [접근]
	 * 총 N알 
	 * 한 알을 이틀에 걸쳐 먹음
	 * 1/2조각 or 1조각 
	 * h		 w
	 * 
	 * 2알 이면 4일에 
	 * hwhw
	 * hhww
	 * 
	 * 우선 w가 선행되야함 
	 * DFS랑 병행인가 
	 * h의 개수, w의 개수 
	 * 
	 * day[n]= day[n-1] * x 
	 * x는 조합의수 
	 * 
	 * [고민]
	 * DFS 시간초과날거같애서 수열 규칙 찾고있었는데... 
	 * 어떻게 dfs인거 확신한거지 
	 * 
	 * 
	 * [https://hini7.tistory.com/m/28] 접근법 참고함  
	 * [https://howtolivelikehuman.tistory.com/11]
	 */

	
	static long[][] map = new long[31][31];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n=sc.nextInt();
			if(n==0) {
				break;
			}
			// w먼저 선행 
			System.out.println(TakePill());
		}
		
	}
	
	private static long TakePill() {
		
		//외곽 
		for(int i=0;i<=n;i++) {
			map[i][0]=1;
		}
		map[1][1]=1;
		
		for(int w=2;w<=n;w++) {
			for(int h=1;h<=w;h++) {
				if(w==h) {
					map[w][h]=map[w][h-1];
				}
				map[w][h]=map[w-1][h]+map[w][h-1];
			}
		}
		return map[n][n];
	}

}
