package itda;
import java.util.*;
import java.io.*;

public class BOJ_1743_김민정 {

	public static int []dy = {-1,1,0,0};
	public static int []dx = {0,0,-1,1};
	public static boolean [][]visit ;
	public static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean [][]map = new boolean[N][M];
		
		
		for(int i =0 ; i< K ; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			// 입력받은 음식좌표check 하기 
			map[y][x] = true;
			
		}
		visit = new boolean[N][M];
		Queue<int[]> que = new LinkedList<int[]>();

		for( int y=0; y< N ; y++) {
			for( int x=0; x< M ; x++) {
				//들리지 않은곳과 쓰레기가 있는가 
				if(map[y][x] && !visit[y][x] ) {
					//q방문 체크 
					visit[y][x] = true;
					int cnt =1;
					
					// 방문한곳을 큐에 넣기 
					que.add( new int[] { y, x});
					
					//que가 비워질때까지 반복 
					while(! que.isEmpty()) {
						
						int[] loc = que.poll();
						//동서남북 방문한곳으로부터 모든 곳 확인해주기 
						for( int i=0 ; i< dx.length ; i++) {
							int ny =  loc[0] + dy[i];
							int nx = loc[1] + dx[i];
							
							// 영역확인해주기 
							if( ny >= 0 && nx >= 0 && ny < N && nx< M && map[ny][nx]) {
								
								visit[ny][nx] = true;
								
								que.add(new int[] {ny, nx});
								
								++cnt;
							}
						}
					}
					
					answer = answer < cnt ? cnt : answer;
				}
			}
		}
		System.out.println(answer);
	}

}
