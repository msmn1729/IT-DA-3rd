import java.util.*;

public class 7570_강채민 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int Child [] = new int[N];
		int dp[] = new int[N];
    
    //1. 시간초과 방법.
		
		for(int i = 0; i < N; i++) {
			
			Child[i] = input.nextInt();
			
			dp[i] = 1;
			
			// 순서대로의 순열을 찾는거니까 
			int sequence = 0;
			
			for(int j = 0; j < i; j++) {
				
				sequence = Child[j];
				
				if(Child[j] < Child[i] && dp[i] < dp[j]+1
						&& Child[i] == sequence+1) {
					
					dp[i] = dp[j] + 1;
					
					//sequence = dp[j];
				}
					
			}
		}
		
		Arrays.sort(dp);
		System.out.println(N - dp[N-1]);
    
    //2. 시간초과 안나게 하는..
		int dp[] = new int[N+1];
        
        for(int i = 1; i <= N; i++) {
            
            int Child = input.nextInt();
            
            dp[Child] = dp[Child-1] + 1;
            
        }
        
        Arrays.sort(dp);
        
		System.out.println(N - dp[N]);
		
	}

}
