import java.util.*;

public class 11497_ㅊㅁ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for(int t = 0; t < T; t++) {
			
			int N = input.nextInt();
			
			int Tongnamu [] = new int[N];
			int tmp [] = new int[N];
			
			for(int i = 0; i < N; i++)
				Tongnamu[i] = input.nextInt();
			
			Arrays.sort(Tongnamu);
			
			int answer = 0;
			
			/**
			 * 인터넷 참고 코드인데 뭔가 음..
			 */
			
			for(int j = 2; j < N; j++) {
				
				tmp[j] = Tongnamu[j];
				
				answer = Math.max(answer, Tongnamu[j] - Tongnamu[j-2]);
			}
			
			System.out.println(answer);
		}
	}

}
