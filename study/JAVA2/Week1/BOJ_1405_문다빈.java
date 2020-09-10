import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CrazyR {
	static int op_X[] = {1,-1,0,0};//동서남북 x좌표
	static int op_Y[] = {0,0,-1,1};//동서남북 y좌표
	static int n;
	static double pro = 1;
	static double pro_l[] = new double[4];//동서남북 순으로 확률 값 저장 되어 있는 변수
	static double p_sum;
	static int d = 0;
	static int visited[][];//그 좌표를 방문했는 지 알려주는 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		//접근 방식은 2가지로 나눠볼 수 있겠지
		//1. 단순 경로의 확률을 바로 구하는 법 2. 단순 하지 않은 경로를 방문하는 확률을 구해서 1에서 빼는 법
		//2번의 접근 방식은 어려울 것.(고려사항이 많음.)
		//1번의 접근 방식은 비교적 단순. 중복되는 지역을 거치지않고 그 지역에 도달하는 확률을 구하면 됌.
		//저는 DFS로 풀것입니다..
		//잃어버린 2시간을 찾아서.. 그래도 뿌듯합니다..
		//처음에 틀린이유 : 확률이 0일 때를 고려하지 않았음. 이렇게 풀면 최악의 경우에도 대략 600만번 돌아서 시간초과 안걸림.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		visited = new int[n * 2 + 1][n * 2 + 1];
		for(int i = 0; i < 4; i++) {
			pro_l[i] = (Double.parseDouble(st.nextToken()) / 100);
		}
		visited[n][n] = 1;
		DFS(n, n, d, -1);
		System.out.println(p_sum);
	}
	
	static int DFS(int x, int y, int d, int k) {//맨 마지막 인수 k가 이 알고리즘에서 시간 단축에 이용.
		int next_x, next_y;
		if(d == n) {
			p_sum = p_sum + pro;
		}
		else {
			if(d == 0) {//처음 함수 들어왔을 떄와 아닐 때를 구분해서 시간을 좀 더 단축시켰습니다.
				for (int i = 0; i < 4; i++) {
					next_x = op_X[i] + x;//동서남북 좌표 더하기 
					next_y = op_Y[i] + y;//동서남북 좌표 더하기
					if(visited[next_x][next_y] == 0 && pro_l[i] != 0) {//아직 안 방문 했으면서 그 방향으로 가는 확률이 0이 아닐 때만 탐색
						visited[next_x][next_y] = 1;
						pro = pro * pro_l[i];
						if(i % 2 == 0) {//시간 단축을 위한 몸부림
							DFS(next_x, next_y, d+1, i+1);
						}
						else {//시간 단축을 위한 몸부림2..
							DFS(next_x, next_y, d+1, i-1);
						}
						visited[next_x][next_y] = 0;
						pro = pro / pro_l[i];
					}
				}
			}
			else {
				int a = k + 1;
				int cnt = 0;
				while(cnt < 3) {//시간 단축을 위한 몸부림3..
					if(a > 3)
						a = a % 4; 
					next_x = op_X[a] + x; 
					next_y = op_Y[a] + y;
					if(visited[next_x][next_y] == 0 && pro_l[a] != 0) {
						visited[next_x][next_y] = 1;
						pro = pro * pro_l[a];
						if(a % 2 == 0) {
							DFS(next_x, next_y, d+1, a+1);
						}
						else {
							DFS(next_x, next_y, d+1, a-1);
						}
						visited[next_x][next_y] = 0;
						pro = pro / pro_l[a];
					}
					a = a + 1;
					cnt = cnt + 1;
				}
			}
		}
		return 0;
	}

}
