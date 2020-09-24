import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Grade1 {
	static long check[][];//1번쨰 인덱스 : 들어갈 수 있는 숫자, 2번째 인덱스 : 연산 시행횟수
	static ArrayList<Integer> n_list = new ArrayList<>();
	static ArrayList<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// 바텀업이냐 탑다운이냐 그것이 문제로다..
		// 마지막에는 무조건 =만 옴..!
		// 바텀업으로 ㄱㄱ..
		// 유사 bfs..?(n-2번 연산 진행)
		// 총 n-2번 연산이 이뤄진 후 = 으로 비교~
		// 시간초과남..ㅜ check 이중 배열을 써서 중복연산을 줄이자..!
		// 틀린이유 : long을 안써서..ㅎ
		
		int n;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		check = new long[21][n-1];
		for(int i = 0; i < n; i++) {
			n_list.add(Integer.parseInt(st.nextToken()));
		}
		math(n);
		System.out.println(check[n_list.get(n_list.size()-1)][n-2]);
	}
	
	static void math(int d) {
		int limit;
		int a;
		int b;
		int n = 1;
		result.add(n_list.get(0));
		check[n_list.get(0)][0] = 1;
		
		while(n <= d-2) {
			limit = result.size();
			b = n_list.get(n);
			for(int i = 0; i < limit; i++) {
				a = result.get(0);
				if(a + b <= 20) { 
					if(n == d-2) {//마지막 연산때 =도 확인
						if(a + b == n_list.get(n_list.size() - 1)) {
							if(check[a + b][n] == 0) {
								check[a + b][n] = check[a][n-1];
							}
							else {
								check[a + b][n] = check[a + b][n] + check[a][n-1];
							}
						}
					}
					else {
						if(check[a + b][n] == 0) {
							result.add(a + b);
							check[a + b][n] = check[a][n-1];
						}
						else {
							check[a + b][n] = check[a + b][n] + check[a][n-1];
						}
					}
				}
				
				if(a - b >= 0) {
					if(n == d-2) {//마지막 연산때 =도 확인
						if(a - b == n_list.get(n_list.size() - 1)) {
							if(check[a - b][n] == 0) {
								check[a - b][n] = check[a][n-1];
							}
							else {
								check[a - b][n] = check[a - b][n] + check[a][n-1];
							}
						}
					}
					else {
						if(check[a - b][n] == 0) {
							result.add(a - b);
							check[a - b][n] = check[a][n-1];
						}
						else {
							check[a - b][n] = check[a - b][n] + check[a][n-1];
						}
					}
				}
				result.remove(0);
			}
			n++;
		}
	}

}
