import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class XY {
	int x;//좌표
	int y;//좌표
	int k;//말이 될 수 있는 기회
	int cost;//거기까지 가는 비용..
	
	public XY(int a, int b, int c, int d) {
		y = a;
		x = b;
		k = c;
		cost = d;
	}
}

public class MtobeH {
	static int w, h;
	static int op_X[] = {1,-1,0,0};//동서남북 x좌표
	static int op_Y[] = {0,0,-1,1};//동서남북 y좌표
	static int op_X2[] = {2,1,2,1,-2,-1,-2,-1};//나이트의 좌표
	static int op_Y2[] = {1,2,-1,-2,1,2,-1,-2};//나이트의 좌표
	static int map[][];//전체적인 맵 상태를 보여주는 이차원 배열
	static int visited[][][];//좌표 방문을 나타냄. 맨 끝은 k의 남은 횟수를 나타냄.
	static int cost = 0;
	static boolean cond = false;//답을 찾아냈는 지 못 찾아냈는 지 구분하는 변수
	static ArrayList<XY> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 접근 방식 : 칸마다의 최소 이동 횟수를 구해나가는 방식으로 풀어봅시다. 
		// 접근 방식(수정) : 최소 이동만 고려하면 안되고 k가 남은 횟수를 고려해서 해당 칸으로 갈 수 있는 최소 이동횟수를 구해주세요..
		// BFS를 쓰는게 좋아보이네요..
		// 좋은 자료구조를 따지기엔 너무 어려운 문제..
		// 제한시간은 2초로 넉넉한편이라 고려안해도 될 것 같습니다..(3중 배열이 되는 수준이 아니라면..?)
		// 는 시간초과가 떴습니다..ㅎ -> 이유는 제가 visited 체크를 제대로 안해서..ㅎ 무한루프 돌았습니다. 알고리즘 자체는 문제x
		int k;//원숭이의 점프 횟수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		visited = new int[h][w][k+1];
		
		for(int i = 0; i < h; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		Move(0,0,k);
		if(w == 1 && h == 1) //영역이 1칸 밖에 없을 때는 0 출력
			System.out.println(0);
		else {
			if(cond == false)
				System.out.println(-1);//모두 돌았는데도 못찾았을 때는 -1 출력
		}
	}
	
	static void Move(int y, int x, int k) {//원숭이를 움직이는 과정
		//여기서 신경써야 할 점은 3차원 배열을 활용해서 k의 남은 횟수에 따라 방문을 다르게 체크해주는 것!
		int next_x, next_y;
		
		list.add(new XY(y, x, k, 0));
		visited[0][0][k] = 1;
		
		while(!list.isEmpty()) {
			cost = list.get(0).cost;
			for(int i = 0; i < 4 ; i++) { //원숭이가 이동하는 법
				next_x = list.get(0).x + op_X[i];
				next_y = list.get(0).y + op_Y[i];
				if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h)
					if(map[next_y][next_x] == 0 && visited[next_y][next_x][list.get(0).k] == 0) {
						if(next_x == w - 1 && next_y == h - 1) { //원하는 값 찾으면 바로탈출
							System.out.println(cost + 1);
							cond = true;
							break;
						}
						visited[next_y][next_x][list.get(0).k] = 1;
						list.add(new XY(next_y, next_x, list.get(0).k, cost + 1));
					}
			}
			
			if(cond == true)
				break;
			
			if(list.get(0).k > 0) { //말이 이동하는 법
				for(int i = 0; i < 8; i++) {
					next_x = list.get(0).x + op_X2[i];
					next_y = list.get(0).y + op_Y2[i];
					if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h)
						if(map[next_y][next_x] == 0 && visited[next_y][next_x][list.get(0).k - 1] == 0) {
							if(next_x == w - 1 && next_y == h - 1) { //원하는 값 찾으면 바로탈출
								System.out.println(cost + 1);
								cond = true;
								break;
							}
							visited[next_y][next_x][list.get(0).k - 1] = 1;
							list.add(new XY(next_y, next_x, list.get(0).k - 1, cost + 1));
						}
				}
			}
			
			if(cond == true)
				break;
			list.remove(0);
		}
	}

}
