import java.awt.Point;
import java.io.* ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2234_우창완 {
	private static int[][] map;
	private static boolean[][]check;
	private static int n,m;
	private static int room_number=1;
	private static class Pair{
		int x;
		int y;
		Pair(int y, int x){
			this.x=x;
			this.y=y;
		}
	}
	private static void breaking_wall() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				for(int wall=1; wall<=8; wall*=2) {
					if(check[i][j]==false) {
						Arrays.fill(check, false);
						map[i][j]-=wall;
						room_number=Math.max(room_number, bfs(i,j));
						map[i][j]+=wall;
					}
				}
			}
		}
		System.out.println(room_number);
	}
	private static int bfs(int b, int a) {
		int room_cnt=0;
//		자바에서 queue x,y의 쌍을 넣을 수 있는 다른 방법?
		Queue<Pair> q =new LinkedList<>();
		check[b][a]=true;
		q.add(new Pair(b,a));
		while(!q.isEmpty()) {
			room_cnt++;
			int x=q.peek().x;
			int y=q.peek().y;
			q.poll();
			int wall=15-map[y][x];
			
			if(wall>=8) {
				wall=wall-8;
				if(!check[y+1][x]){
					check[y+1][x]=true;
					q.add(new Pair(y+1,x));
				}
			}
			if(wall>=4) {
				wall=wall-4;
				if(!check[y][x+1]) {
					check[y][x+1]=true;
					q.add(new Pair(y,x+1));
				}
			}
			if(wall>=2) {
				wall=wall-2;
				if(!check[y-1][x]) {
					check[y-1][x]=true;
					q.add(new Pair(y-1,x));
				}
			}
			if(wall==1 ) {
				wall=wall-1;
				if(!check[y][x-1]) {
					check[y][x-1]=true;
					q.add(new Pair(y,x-1));
				}
			}
		}
		return room_cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String []arr = br.readLine().split(" ");
//		n 가로 m 세로
		n=Integer.parseInt(arr[0]);
		m=Integer.parseInt(arr[1]);
		map=new int[m+1][n+1];
		check=new boolean[m+1][n+1];
		int cnt=0;
		
		for(int i=0; i<m; i++) {
			arr=br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(arr[j]);
			}
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j]==false) {
					room_number=Math.max(room_number, bfs(i,j));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(room_number);
		Arrays.fill(check, false);
		breaking_wall();
	}

	

}
