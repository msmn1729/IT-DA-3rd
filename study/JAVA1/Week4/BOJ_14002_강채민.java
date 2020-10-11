import java.util.*;

public class 14002_강채민 {
	
	static ArrayList<Integer> Answer = new ArrayList<>();
	static int Suyeol [];
	static int find [];

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		Suyeol= new int[N];
		
		/**
		 * 일단 수열 자체도 출력해줘야 한다는 점에서 어려웠던 문제였던것 같다.
		 * 일단 숫자를 담을 배열, dp배열, 그리고 수열을 차례대로 탐색해갈 배열이 필요하다.
		 */
		
		int dp[] = new int[N];
		find = new int[N]; // 수열을 차례대로 탐색해갈 배열.
		
		for(int i = 0; i < N; i++) {
			
			Suyeol[i] = input.nextInt();
			
			dp[i] = 1; // 디폴트 값을 1로 준다. 최소 자기부터 수열이 시작할 수 있기 때문이다.
			find[i] = -1; // 수열을 찾아갈때 -1일때를 찾을것이기 때문에 디폴트 값을 -1로 두었다.
			
			for(int j = 0; j < i; j++) { // 현재 i번째 전 숫자들을 탐색해야 하니까.
				
				if(Suyeol[j] < Suyeol[i] && dp[i] < dp[j]+1) { 
					
					dp[i] = dp[j] + 1;
					find[i] = j; // 자신의 뒤에 어떠한 숫자가 있는지.
				}
			}
		}
		
		/**
		 * dp배열의 max값을 찾는 과정.
		 */
		int dp_max = 0;
		
		for(int i = 0; i < N; i++) 
			dp_max = Math.max(dp_max, dp[i]);
		
		System.out.println(dp_max); // 이게 가장 긴 수열의 길이이기 때문.
		
		for(int i = 0; i < N; i++) {
			//이제 가장 길이가 긴 dp배열의 수열 숫자부터 시작해서 탐색을 해가야 한다.
			
			if(dp[i] == dp_max) {
				// 여기서부터 거꾸로 탐색해가면 된다.
				Answer.add(Suyeol[i]); // 맨 마지막에 들어갈 수열 숫자 넣어줌.
				
				CHECK(find[i]); // 탐색 시작.
				
				break; // 중요...
			}
		}
		
		for(int a = Answer.size() - 1; a >= 0; a--)
			System.out.print(Answer.get(a) + " ");

	}

	public static void CHECK(int vv) { 
		
		if(vv == -1) // -1일때 탐색 종료.
			return;
		
		Answer.add(Suyeol[vv]); // 그 전까지 계속 수열에 넣어주기.
		
		CHECK(find[vv]); // 탐색 이어가기.
	}

}
