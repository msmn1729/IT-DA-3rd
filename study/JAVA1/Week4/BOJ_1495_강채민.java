import java.util.*;

public class 1495_ㅊㅁ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); // 곡의 개수
		int S = input.nextInt(); // 시작 볼륨
		int M = input.nextInt(); // 최대 볼륨
		
		int V[] = new int[N]; // 리스트 V
		
		Queue<Integer> Vol = new LinkedList<Integer>();
		
		Vol.add(S); // 먼저 시작 볼륨을 넣어준다.
		
		int count = 1;
		
		for(int i = 0; i < N; i++) {
			
			V[i] = input.nextInt();
			
			int COUNT = count;
			
			count = 0;
			
			if(COUNT == 0) {
				
				System.out.println(-1);
				return;
			}
			
			for(int c = 1; c <= COUNT; c++) {
				
				int tmp_vol = Vol.poll();
				
				if(tmp_vol + V[i] >= 0 && tmp_vol + V[i] <= M) {
					
					Vol.add(tmp_vol + V[i]);
					count++;
				}
				
				
				if(tmp_vol - V[i] >= 0 && tmp_vol - V[i] <= M) {
					
					Vol.add(tmp_vol - V[i]);
					count++;
				}
					
			}
			
		}
		
		int max = 0;
		
		while(!Vol.isEmpty()) {
			int poll_q = Vol.poll();
			
			if(max < poll_q)
				max = poll_q;
			
		}
		
		System.out.println(max);
	}

}
