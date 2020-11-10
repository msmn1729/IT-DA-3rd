import java.util.*;

public class 5052_ㅊㅁ {

	public static void main(String[] args) {
		
		/**
		 * 이중 포문을 이용할려고 먼저 생각.
		 * 이중 포문을 사용하면 바로 시간초과...
		 * startsWith을 쓰는 문제..
		 */
		
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for(int t = 0; t < T; t++) { // 테스트 케이스 수만큼 반복
			
			int N = input.nextInt();
			
			String Phone_Num[] = new String[N];
			
			for(int n = 0; n < N; n++) 
				Phone_Num[n] = input.next();
			
			Arrays.sort(Phone_Num);
			
			int flag = 0;
			
			for(int i = 1; i <N; i++) {
				
				if(Phone_Num[i].startsWith(Phone_Num[i-1])) {
					flag = -1;
					break;
				}
			}
			
			if(flag == -1)
				System.out.println("NO");
			
			else
				System.out.println("YES");
		}

	}

}
