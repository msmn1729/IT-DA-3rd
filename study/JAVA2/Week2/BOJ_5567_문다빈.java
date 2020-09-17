import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wedding {
	static int visited[];
	static ArrayList<ArrayList<Integer>> F_list = new ArrayList<>();
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 리스트에 연결 된 친구를 모두 방문하는 전형적인 탐색 문제.
		// 친구의 친구의 친구부터는 초대 금지.
		// DFS를 사용하여 문제를 풀 겁니다.
		// 메모리를 더 유용하게 쓰기 위해 이중 어레이리스트를 썼습니다.
		// 사실 데이터의 양이 많지 않아 2차원 배열을 써도 상관없는 문제입니다
		// 이차원 배열써도 최대 byte : 4 * 500 * 500 byte = 대략 1mb(아마도..)로 메모리 걱정안해도 됌.
		// 이차원 배열을 쓰면 코드짜기는 편하지만 이용되지 않는 빈공간이 너무 많이 생겨서 이렇게 풀었습니다.
		int n;
		int m;
		int a, b;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		visited = new int[n+1]; 
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			F_list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			F_list.get(a).add(b);//친구 리스트 작성 과정
			F_list.get(b).add(a);//친구 리스트 작성 과정
		}
		
		visited[1] = 1;
		DFS(1, 0);
		System.out.println(cnt);
	}
	
	static int DFS(int n, int d) {
		if(d == 2) {
			return 0;
		}			
		else {
			for(int i : F_list.get(n)) {
				if(visited[i] == 0) {//체크 안 되었던 친구들만 추가해주는 식으로 계속 탐색
					visited[i] = 1;
					cnt++;
				}
				DFS(i, d+1);
			}
		}
		return 0;
	}

}
