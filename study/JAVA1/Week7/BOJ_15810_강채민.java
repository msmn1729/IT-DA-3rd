import java.util.*;

public class 15810_ㅊㅁ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		/**
		 * 팀원들의 코드의 도움을 받아 푼 문제입니다.
		 */
		
		int N = input.nextInt(); // 스태프 수
		int M = input.nextInt(); // 풍선 개수
		
		int Minute [] = new int[N];
		
		long left = 1l;
		long right = 100000000000l;
		
		for(int n = 0; n < N; n++)
			Minute[n] = input.nextInt();
		
		while(left <= right) {
			
			long answer = 0;
			long mid = (left + right) / 2;
			
			for(int i = 0; i < N; i++)
				answer = answer + (mid / Minute[i]);
			
			if(answer >= M)
				right = mid - 1;
			
			else
				left = mid + 1;
		}
		
		System.out.println(left);
		
	}

}
