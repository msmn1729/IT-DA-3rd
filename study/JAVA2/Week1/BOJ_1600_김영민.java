import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class BOJ_1600_김영민 {

	static int K;
	static int W;
	static int H;
	static Queue<Monkey> q = new LinkedList<>();
	static int [][] map;
	static boolean [][][] visited;
	static int [] offsetX = {1,-1,0,0}; //인접한곳으로이동
	static int [] offsetY = {0,0,1,-1};
	static int [] hoffsetX = {-2,-1,1,2,2,1,-1,-2}; //말처럼이동
	static int [] hoffsetY = {1,2,2,1,-1,-2,-2,-1};
	static int count = 0;
	
	static class Monkey{
		int x;
		int y;
		int count; //전체이동횟수
		int horse; //말처럼이동할경우
		Monkey(int x, int y, int count, int horse){
			this.x = x;
			this.y = y;
			this.count = count;
			this.horse = horse;
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		String [] temp = br.readLine().split(" ");
		W = Integer.parseInt(temp[0]);
		H = Integer.parseInt(temp[1]);
	
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			temp = br.readLine().split(" ");
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		visited[0][0][0] = true;
		q.add(new Monkey(0,0,0,0));
		
		System.out.print(bfs());
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			Monkey now = q.poll();
			int x = now.x;
			int y = now.y;
			int count = now.count;
			int horse = now.horse;
			
			if(x == H-1 && y == W-1) { //도착지점에도착할경우
				q.clear();
				return count;
			}

			if(horse<K) { //말처럼이동할수있는횟수가남아있을경우
				for(int i=0;i<8;i++) {
					int tempx = x+hoffsetX[i];
					int tempy = y+hoffsetY[i];
					if(tempx>=0 && tempx<H) {
						if(tempy>=0 && tempy<W) {
							if(map[tempx][tempy]==0 && !visited[tempx][tempy][horse+1]) {
								visited[tempx][tempy][horse+1] = true;
								q.add(new Monkey(tempx, tempy, count+1, horse+1));
							}
						}
					}
				}
			}
			
			for(int i=0;i<4;i++) { //인접한곳으로이동
				int tempx = x+offsetX[i];
				int tempy = y+offsetY[i];
				if(tempx>=0 && tempx<H) {
					if(tempy>=0 && tempy<W) {
						if(map[tempx][tempy]==0 && !visited[tempx][tempy][horse]) {
							visited[tempx][tempy][horse] = true;
							q.add(new Monkey(tempx, tempy, count+1, horse));
						}
					}
				}
			}
		}	
		return -1; //도착지점에도착하지못할경우
	}
}
