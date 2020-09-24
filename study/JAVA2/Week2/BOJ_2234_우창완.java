import java.awt.Point;
import java.io.* ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
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
    
	private static void initialCheck(){
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				check[i][j]=false;
			}
		}
	}
//	벽이 있을 시 벽을 한 쪽씩 제거한뒤 최대값 
	private static void breaking_wall() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int wall= map[i][j];
				if(wall>=8&& i+1<m){
					map[i][j]-=8;
					room_number=Math.max(room_number, bfs(i,j));
					map[i][j]+=8;
					wall=wall-8;
				}
				if(wall>=4 &&j+1<n){
					map[i][j]-=4;
					room_number=Math.max(room_number, bfs(i,j));
					map[i][j]+=4;
					wall=wall-4;
				}
				if(wall>=2&& i-1>=0){
					map[i][j]-=2;
					room_number=Math.max(room_number, bfs(i,j));
					map[i][j]+=2;
					wall=wall-2;
				}
				if(wall>=1 && j-1>=0){
					map[i][j]-=1;
					room_number=Math.max(room_number, bfs(i,j));
					map[i][j]+=1;
					wall=wall-1;
				}
				initialCheck();
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
			// System.out.print(x);
			// System.out.println(y);
			q.poll();
//			15에서 뺄 시 벽이 없는 곳의 방향을 알 수 있다
			int wall=15-map[y][x];
			
			if(wall>=8 &&y+1<m) {
				wall=wall-8;
				if(!check[y+1][x]){
					check[y+1][x]=true;
					q.add(new Pair(y+1,x));
				}
			}
			if(wall>=4 && x+1<n) {
				wall=wall-4;
				if(!check[y][x+1]) {
					check[y][x+1]=true;
					q.add(new Pair(y,x+1));
				}
			}
			if(wall>=2 && y-1>=0) {
				wall=wall-2;
				if(!check[y-1][x]) {
					check[y-1][x]=true;
					q.add(new Pair(y-1,x));
				}
			}
			if(wall==1&& x-1>=0 ) {
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
					// System.out.println(cnt);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(room_number);
		room_number=1;
		initialCheck();
		breaking_wall();
	}
	
}
