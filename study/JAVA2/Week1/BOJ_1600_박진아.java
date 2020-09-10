import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 말은 격자판에서 체스의 나이트와 같은 이동방식
 * 
 * 원숭이는 능력이 부족해서 총 K번만 위와 같이 움직일 수 있음
 * 그 외에는 그냥 인접한 칸으로만 움직일 수 있다.
 * 인접한 칸은 상하좌우만 이동 가능 
 * 
 * 격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다. 
 * 인접한 네 방향으로 한 번 움직이는 것, 
 * 말의 움직임으로 한 번 움직이는 것, 
 * 모두 한 번의 동작으로 친다. 
 * 
 * 격자판이 주어졌을 때, 
 * 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램을 작성하시오.
 * 
 * 
 * 첫째 줄에 정수 K가 주어진다. 
 * 둘째 줄에 격자판의 가로길이 W, 
 * 세로길이 H가 주어진다. 
 * 그 다음 H줄에 걸쳐 W개의 숫자가 주어지는데, 
 * 0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 
 * 장애물이 있는 곳으로는 이동할 수 없다. 
 * 시작점과 도착점은 항상 평지이다. 
 * W와 H는 1이상 200이하의 자연수이고, 
 * K는 0이상 30이하의 정수이다.
 * 
 * 못풂
 * 
 * [접근]
 * bfs
 * 한번 움직일때마다 움직인 횟수를 map에 기록하면서 전진
 * 이때 기록하는 횟수는 최소값으로 지정해서 저장하면 
 * 최소값을 구할 수 있음  
 * 
 * map 범위 안에 있는지? 
 * 장애물이 없을 때 -- Math.min(기존값, 새로운 값)을 visited에 저장 
 * 장애물이 있을 때 -- 인접칸으로 이동, Math.min(기존값, 새로운 값)
 * 
 * [고민]
 * k를 static으로 선언해야하나 ..? 
 * queue는 여전히 어렵다...
 * 다뤄야할 정보가 너무 많다
 * 
 * [해결]
 * 구글링 함
 * k정보는 visited배열을 3차원으로 선언해서 처리함  
 * 
 */

public class Main {

	static int dx[] = { -2, -1, 1, 2, -1, -2, 1, 2 };
	static int dy[] = { 1, 2, 2, 1, -2, -1, -2, -1 };

	static int dx2[] = { -1, 0, 0, 1 };
	static int dy2[] = { 0, 1, -1, 0 };

	static int w, h, k;

	static Queue<Node> queue = new LinkedList<>();
	static int[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine()); // 유사 나이트 이동 횟수
		String input[] = br.readLine().split(" ");
		w = Integer.parseInt(input[0]); // 격자판 가로길이
		h = Integer.parseInt(input[1]); // 격자판 세로길

		int map[][] = new int[h + 1][w + 1];
		visited = new int[h + 1][w + 1][k + 1];

		for (int i = 1; i < h + 1; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j < w + 1; j++) {
				map[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		bfs(map);

	}

	private static void bfs(int[][] map) {

		Node current = new Node(1, 1, 0, 0);
		queue.add(current);
		visited[1][1][0] = 1;

		while (!queue.isEmpty()) {
			current = queue.poll();
			int y = current.h;
			int x = current.w;
			int cntHorse = current.horse;
			int cntJump = current.jump;

			// 탐색 완료시
			if (x == w && y == h) {
				System.out.println(current.jump);
				return;
			}

			// 근접 탐색
			for (int i = 0; i < 4; i++) {
				int nextx = x + dx2[i], nexty = y + dy2[i];
				if (isRange(nextx, nexty) && map[nexty][nextx] != 0 && visited[nexty][nextx][cntHorse] != 1) {
					queue.add(new Node(nextx, nexty, cntJump + 1, cntHorse));
					visited[nexty][nextx][cntHorse] = 1;
				}
			}

			if (cntHorse == k) {
				continue;
			}
			
			// 말처럼 이동
			for (int i = 0; i < 8; i++) {
				int nextx = x + dx[i], nexty = y + dy[i];
				if (isRange(nextx, nexty) && map[nexty][nextx] != 0 && visited[nexty][nextx][cntHorse] != 1) {
					queue.add(new Node(nextx, nexty, cntJump + 1, cntHorse+1));
					visited[nexty][nextx][cntHorse+1] = 1;
				}
			}
		}
		System.out.println("-1");
	}

	public static boolean isRange(int x, int y) {
		if (0 <= x && 0 <= y && x <= w && y <= h)
			return true;
		else
			return false;
	}
}

class Node {
	int w;
	int h;
	int jump;
	int horse;

	Node(int w, int h, int jump, int horse) {
		this.w = w;
		this.h = h;
		this.jump = jump;
		this.horse = horse;
	}

}