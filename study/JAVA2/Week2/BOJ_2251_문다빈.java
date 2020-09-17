import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class ABC {
	//좌표 값 저장하는 클래스
	int a, b, c;
	public ABC (int x, int y, int z) {
		a = x;
		b = y;
		c = z;
	}
}

public class WaterBottle {
	static int visited[][][];
	static ArrayList<ABC> list = new ArrayList<>();
	static ArrayList<Integer> sol = new ArrayList<>();
	static int A, B, C;
	
	public static void main(String[] args) throws IOException {
		// 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있다. 
		// 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다.
		// c는 항상 가득차게 주어짐.
		// bfs..?
		// A->B A->C B->A B->C C->A C->B 경우 있음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new int[A+1][B+1][C+1];
		BFS();
		
		Collections.sort(sol);
		for(int i : sol) {
			System.out.print(i + " ");
		}
	}
	
	static void BFS() {
		int a, b, c;
		
		list.add(new ABC(0,0,C));
		
		while(!list.isEmpty()) {
			a = list.get(0).a;
			b = list.get(0).b;
			c = list.get(0).c;

			list.remove(0);
			if(visited[a][b][c] == 1)
				continue;
			visited[a][b][c] = 1;
			if(a == 0) {
				sol.add(c);
			}
			
			if(a + c >= A) {//c -> a
				list.add(new ABC(A, b, c - (A - a)));
			}
			else {
				list.add(new ABC(a + c, b, 0));
			}
			
			if(c + b >= B){//c -> b
				list.add(new ABC(a, B, c - (B - b)));
			}
			else {
				list.add(new ABC(a, c + b, 0));
			}
			
			if(a + b >= A){//b -> a
				list.add(new ABC(A, b - (A - a), c));
			}
			else {
				list.add(new ABC(a + b, 0, c));
			}
			
			if(c + b >= C){//b -> c
				list.add(new ABC(a, b - (C - c), C));
			}
			else {
				list.add(new ABC(a, 0, c + b));
			}
			
			if(a + c >= C){//a -> c
				list.add(new ABC(a - (C - c), b, C));
			}
			else {
				list.add(new ABC(0, b, a + c));
			}
			
			if(a + b >= B){//a -> b
				list.add(new ABC(a - (B - b), B, c));
			}
			else {
				list.add(new ABC(0, a + b, c));
			}
		}
	}


}
