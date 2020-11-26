import java.util.*;

public class 6263_ㅊㅁ {

	public static void main(String[] args) {
		
		/**
		 * 잇다 여러분들의 코드를 참고했습니다..
		 * left와 right의 값을 어떻게 설정할지 몰라서 헤맸음
		 */
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		int yongdon [] = new int[N];
		int max = 0;
		int sum = 0;
		
		for(int n = 0; n < N; n++) {
			yongdon[n] = input.nextInt();
			
			if(max < yongdon[n])
				max = yongdon[n];
			
			sum = sum + yongdon[n];
		}
			
		/**
		 * left와 right을 아는것이 관건이였던거 같습니당
		 */
		int left = max;
		int right = sum;
		
		
		while(left < right) {
			
			int mid = (left + right) / 2;
			
			int now_money = 0;
			int count = 1;
			
			for(int i = 0; i < N; i++) {
				
				if(now_money + yongdon[i] > mid) {
					count++;
					now_money = yongdon[i];
				}
				
				else 
					now_money += yongdon[i];
			}
			
			if(count > M)
				left = mid + 1;
			
			else
				right = mid;
		}
		
		System.out.println(left);
	}

}
