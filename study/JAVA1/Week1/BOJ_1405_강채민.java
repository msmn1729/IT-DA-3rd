import java.util.*;

public class Main {
	
	static int check[][] = new int[30][30];
	static double Percant [] = new double [4]; // 동서남북 확률 
	static int move_x[] = {1, -1, 0, 0}; // 동서남북
	static int move_y[] = {0, 0, -1, 1}; // 동서남북
	static int N;
	static double answer;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		
		for(int p = 0; p < Percant.length; p++) {
			int perc = input.nextInt();
			Percant[p] = (perc * 0.01);
		}
		
		check[15][15] = 1; // 가운데 부분에서 출발한다고 가정.
		
		dfs(15, 15, 1.0, 0);
		
		/**
		 * 확률 계산하는 부분이 잘 이해가 가지 않았다. 
		 * 따라서 이 부분은 구글링을 해서 문제 이해를 먼저 도왔다.
		 */
		
		System.out.println(answer);
	}

	public static void dfs(int x, int y, double percant, int n) {
		
		if(n == N) {
			answer = answer + percant;
			return;
		}
		
		for(int i = 0; i < move_x.length; i++) {
			
			if(Percant[i] == 0) // 갈 확률이 아얘 없으면 
				continue;
			
			int go_x = x + move_x[i];
			int go_y = y + move_y[i];
			
			if(check[go_x][go_y] != 1) { // 이거를 while이라고 했다니..
				
				check[go_x][go_y] = 1; // 간거 표시
				dfs(go_x, go_y, percant*Percant[i], n+1);
				check[go_x][go_y] = 0; // 간거 다시 풀어주기.
			}
		}
	}

}
