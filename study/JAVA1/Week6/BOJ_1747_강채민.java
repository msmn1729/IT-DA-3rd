import java.util.*;

public class ㅊㅁ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		if(N <= 11) {
			
			System.out.println(N);
			return;
		}
		
		while(true) {
			
			int check = 0;
			
			//1. 소수인지를 판별하고
			for(int i = 2; i < N; i++) {
				
				if(N % i == 0) {
					check = 1;
					break;
				}
					
			}
			
			if(check == 0) {
				
				//2, 그다음 String을 비교한다. 
				
				int is_P = 0;
				
				String check_string = Integer.toString(N);
				
				for(int j = 0; j < check_string.length() / 2; j++) {
					
					char start = check_string.charAt(j);
					char end = check_string.charAt(check_string.length()-1 - j);
					
					if(start != end) {
						is_P = 1;
						break;
					}
				}
				
				if(is_P == 0) {
					System.out.println(N);
					break;
				}
				
				
			}
			
			N++;
			
		}
	}

}
