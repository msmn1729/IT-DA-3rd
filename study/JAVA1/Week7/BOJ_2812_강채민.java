import java.util.*;

public class 2812_크게만들기_채민 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int K = input.nextInt();
		
		String S = input.next();
    
    /**
    1. 시간초과 코드. 
    */
		
		int index = -1;
		String answer = "";
		
		for(int t = 1; t <= K; t++) {
			
			int max = 0;
			
			for(int i = index+1; i < N - (K - t); i++) {
				
				if(max < (S.charAt(i) - '0')) {
					
					max = S.charAt(i) - '0';
					index = i;
				}
			}
			
			answer = answer + Integer.toString(max);
		}
		
		
		System.out.println(answer);
		
		/**
    밑에 있는 방법은 Week7 Python팀 코드 보고 도움을 얻은 코드입니다.
    
    반례 6 4
    198794
    
    에서 [박한규]님 코드 참고했습니다.(모르시는분이지만..감사드려요..)
    */
    
    /*
		ArrayList <Integer> answer = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			
			int now = (S.charAt(i) - '0');
			
			while(!answer.isEmpty() && K > 0 && 
				answer.get(answer.size() - 1) < now) {
				
				answer.remove(answer.size() - 1); // 마지막 숫자 지우고
				K--; // K도 한개 줄여준다.
			}
			
			answer.add(now);
		}
		
		//for(int a = 0; a < answer.size(); a++) {
		for(int a = 0; a < answer.size() - K; a++) {
			System.out.print(answer.get(a));
		}
		*/
	}

}
