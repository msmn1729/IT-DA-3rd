import java.util.*;

public class 1756_ㅊㅁ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int D = input.nextInt(); // 오븐 깊이
		
		int N = input.nextInt(); // 피자 개수
		
		//ArrayList<Integer> Oven = new ArrayList<>();
		int Oven [] = new int [D+1]; // 숫자가 1부터 시작해서..
		int Pizza [] = new int [N];
		
		/*
		for(int d = 1; d <= D; d++) 
			Oven[d] = input.nextInt();
			//Oven.add(input.nextInt());
		
		
		for(int n = 0; n < N; n++) 
			Pizza[n] = input.nextInt();
		
		
		//int index = Oven.size();
		
		
		for(int i = 0; i < N; i++) {
			
			//int now = Pizza[i];
			int now = input.nextInt();
			
			//for(int j = 0; j < index; j++) {
			for(int j = index - 1; j >= 0; j--) {	
				if(Oven.get(j) < now) {
					index = j;
					break;
				}
			}
		}
		*/
		
		/**
		 * Week7 임원진분들이 올리신 코드 참고한 내용입니다.
		 */
		
		Oven[1] = input.nextInt();
		
		for(int d = 2; d <= D; d++) {
			int depth = input.nextInt();
			
			if(Oven[d-1] < depth)
				Oven[d] = Oven[d-1];
			
			else
				Oven[d] = depth;
		}
		
		
		for(int n = 0; n < N; n++) 
			Pizza[n] = input.nextInt();
		
		int index = 0;
		int answer = 0;
		
		for(int i = D; i > 0; i--) {
			
			if(index < N && Oven[i] >= Pizza[index]) {
				
				answer = i;
				index++;
			}
		}
		
		if(index == N)
			System.out.println(answer);
		
		else
			System.out.println(0);

	}

}
