import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); // 친구 명수
		
		int L = input.nextInt();
		
		int Friend_Map [][] = new int [N+1][N+1]; // 1부터 시작이니까
		int check [] = new int [N+1];
		int level [] = new int [N+1];
		
		for(int l = 0; l < L; l++) {
			
			int a = input.nextInt();
			int b = input.nextInt();
			
			Friend_Map[a][b] = 1;
			Friend_Map[b][a] = 1;
		}
		
		Queue<Integer> Friend = new LinkedList<>();
		int count = 0;
		
		Friend.add(1); // 상근이부터 시작
		check[1] = 1; // 상근이 간거 체크
		
		while(!Friend.isEmpty()) {
			
			int F = Friend.poll();
			
			if(level[F] > 1) // level2가 넘어가면 count하지 않기!
				break;
			
			for(int i = 1; i < Friend_Map[F].length; i++) {
				
				if(Friend_Map[F][i] == 0) // 아무것도 없으면
					continue;
				
				if(check[i] == 1) // 이미 갔던 곳이라면
					continue;
				
				Friend.add(i);
				check[i] = 1;
				count = count + 1; // 친구수 추가
				
				level[i] = level[F] + 1;
			}
		}
		
		System.out.println(count);
	}

}
