import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 대략 위의 그림과 같이 생긴 성곽이 있다. 
 * 굵은 선은 벽을 나타내고, 
 * 점선은 벽이 없어서 지나다닐 수 있는 통로를 나타낸다. 
 * 이러한 형태의 성의 지도를 입력받아서 다음을 계산하는 프로그램을 작성하시오.

 * 이 성에 있는 방의 개수
 * 가장 넓은 방의 넓이
 * 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
 * 위의 예에서는 방은 5개고, 가장 큰 방은 9개의 칸으로 이루어져 있으며, 위의 그림에서 화살표가 가리키는 벽을 제거하면 16인 크기의 방을 얻을 수 있다.

 * 성은 m×n(1 ≤ m, n ≤ 50)개의 정사각형 칸으로 이루어진다. 
 * 성에는 최소 두 개의 방이 있어서, 
 * 항상 하나의 벽을 제거하여 두 방을 합치는 경우가 있다.

 * 입력
 * 첫째 줄에 두 정수 n, m이 주어진다.
 *  다음 m개의 줄에는 n개의 정수로 벽에 대한 정보가 주어진다. 
 *  벽에 대한 정보는 한 정수로 주어지는데, 
 *  서쪽에 벽이 있을 때는 1을, 
 *  북쪽에 벽이 있을 때는 2를, 
 *  동쪽에 벽이 있을 때는 4를, 
 *  남쪽에 벽이 있을 때는 8을 더한 값이 주어진다. 
 *  
 *  참고로 이진수의 각 비트를 생각하면 쉽다. 
 *  따라서 이 값은 0부터 15까지의 범위 안에 있다.
 *  
 *  [접근]
 *  서 : 1
 *  북 : 2
 *  동 : 4
 *  남 : 8
 *  
 *  3 : 서,북
 *  5 : 서,동
 *  9 : 서,남
 *  6 : 북,동
 *  10 : 북,남 
 *  12 : 동,남
 *  
 *  7 : 서,북,동
 *  11 : 서,북,남 
 *  13 : 서,남,동 
 *  
 *  한 사각형의 동서남북의 정보를 저장하는 클래스 만들기 -> 이건 아닌거 같다...
 *  
 *  방의 개수 : bfs로 탐색 
 *  가장 큰 방 : 탐색하면서 큰 값을 비교함 
 *  벽뚫은 가장 큰 방 : 하나씩 다 뚫어보면서 확인하기 ..? 
 * 
 *  [못풀음]
 */
public class Q2234 {

	static Walls map[][] = new Walls[51][51];
	static Queue<node> q = new LinkedList<>();
	static boolean visited[][] = new boolean[51][51];
	static int rooms, maxSize, maxRoom, rsrooms = -1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int wall = 0;

		rooms = 0; // 방의 개수
		maxSize = 0;// 가장 큰 방
		maxRoom = 0;// 억지 큰 방

		// 방이 두개 일때
//		if (n == 2 && m == 1) {
//			rooms = 2;
//			maxSize = 1;
//			maxRoom = 2;
//			System.out.println(rooms);
//			System.out.println(maxSize);
//			System.out.println(maxRoom);
//			return;
//		}

		for (int i = 1; i <= m; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				wall = Integer.parseInt(input[j]);
				try {
				map[i][j]=BuildWalls(wall, i, j);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("done");

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (!visited[i][j]) {
					bfs(m, n);
					System.out.println("시작 : "+i +" "+j);
					System.out.println(rooms);
				}
			}
		}

	}

	public static void bfs(int m, int n) {

		int mx = 1, ny = 1;
		visited[mx][ny] = true;
		q.add(new node(mx, ny));

		while (!q.isEmpty()) {

			int curm = q.poll().x;
			int curn = q.poll().y;

			if (map[curm][curn].east) { 
				rooms++;
				visited[curm+1][curn]=true;
				q.add(new node(curm + 1, curn));
			}
			if (map[curm][curn].west) {
				rooms++;
				visited[curm-1][curn]=true;
				q.add(new node(curm - 1, curn));
			}
			if (map[curm][curn].north) {
				rooms++;
				visited[curm][curn-1]=true;
				q.add(new node(curm, curn - 1));
			}
			if (map[curm][curn].south) {
				rooms++;
				visited[curm][curn+1]=true;
				q.add(new node(curm, curn + 1));
			}

		}
	}

	public static Walls BuildWalls(int wall, int i, int j) {
		switch (wall) {
		case 1:
			map[i][j].west = true;
			break;
		case 2:
			map[i][j].north = true;
			break;
		case 4:
			map[i][j].east = true;
			break;
		case 8:
			map[i][j].south = true;
			break;
		case 3:
			map[i][j].west = true;
			map[i][j].north = true;
			break;
		case 5:
			map[i][j].west = true;
			map[i][j].east = true;
			break;
		case 9:
			map[i][j].west = true;
			map[i][j].south = true;
			break;
		case 6:
			map[i][j].north = true;
			map[i][j].east = true;
			break;
		case 10:
			map[i][j].north = true;
			map[i][j].south = true;
			break;
		case 12:
			map[i][j].east = true;
			map[i][j].south = true;
			break;
		case 7:
			map[i][j].west = true;
			map[i][j].north = true;
			map[i][j].east = true;
			break;
		case 11:
			map[i][j].west = true;
			map[i][j].north = true;
			map[i][j].south = true;
			break;
		case 13:
			map[i][j].west = true;
			map[i][j].south = true;
			map[i][j].east = true;
			break;
		case 14:
			map[i][j].north = true;
			map[i][j].south = true;
			map[i][j].east = true;
			break;
		default:
			break;
		}
		return map[i][j];
	}
}

class node {
	int x, y;

	public node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Walls {
	boolean west;
	boolean east;
	boolean north;
	boolean south;

	public Walls(boolean west, boolean north, boolean east, boolean south) {
		this.west = west;
		this.north = north;
		this.east = east;
		this.south = south;
	}
}
