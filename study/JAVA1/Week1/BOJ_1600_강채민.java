import java.util.*;

public class Main {
	
	//나이트 좌표.
	static int move_k_x[] = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int move_k_y[] = {1, 1, 1, -1, -2, -2, -1, 1};
	
	static int move_x[] = {1, -1, 0, 0}; // 동서남북
	static int move_y[] = {0, 0, -1, 1}; // 동서남북
	
	static int Monkey_Map [][];
	static int check [][];
	
	static int W;
	static int H;

	static ArrayList<Integer> Answer = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int K = input.nextInt(); // 나이트 가능 이동 횟수.
		
		W = input.nextInt(); // 가로
		H = input.nextInt(); // 세로
		
		Monkey_Map = new int [H][W];
		check = new int [H][W];
		
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				Monkey_Map[h][w] = input.nextInt();
			}
		}
		
		check[0][0] = 1; // 원숭이 출발점.
		dfs(0, 0, K, 0);
		
		if(Answer.size() == 0)
			System.out.println(-1);
		
		else
			System.out.println(Collections.min(Answer)); // 최솟값 출력하기
	}

	public  static void dfs(int x, int y, int k_count, int count) {
		
		if(x == W-1 && y == H-1) { // 끝까지 다 왔다면
			Answer.add(count-1);
			return;
		}
		
		if(k_count > 0) { // 나이트 이동 횟수가 남아 있다면
			
			for(int kc = 0; kc < move_k_x.length; kc++) {
				
				int go_kx = x + move_k_x[kc];
				int go_ky = y + move_k_y[kc];
				
				if(go_kx < 0 || go_ky < 0 || go_kx >= W || go_ky >= H) // 범위를 벗어나면
					continue;
				
				if(check[go_kx][go_ky] == 1) // 이미 간곳이라면
					continue;
				
				if(Monkey_Map[go_kx][go_ky] == 1) // 장애물이 있다면
					continue;
				
				check[go_kx][go_ky] = 1; // 간거 표시
				dfs(go_kx, go_ky, k_count-1, count+1);
				check[go_kx][go_ky] = 0; // 간거 다시 해제해주기.
				
			}
		}
		
		else {
			
			for(int i = 0; i < move_x.length; i++) {
				
				int go_x = x + move_x[i];
				int go_y = y + move_y[i];
				
				if(go_x < 0 || go_y < 0 || go_x >= W || go_y >= H) // 범위를 벗어나면
					continue;
				
				if(check[go_x][go_y] == 1) // 이미 간곳이라면
					continue;
				
				if(Monkey_Map[go_x][go_y] == 1) // 장애물이 있다면
					continue;
				
				check[go_x][go_y] = 1; // 간거 표시
				dfs(go_x, go_y, 0, count+1);
				check[go_x][go_y] = 0; // 간거 다시 해제해주기.
			}
		}
	}

}
