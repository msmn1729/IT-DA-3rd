package itda;
import java.util.*;
import java.io.*;
	
public class BOJ_1405_김민정 {
	
public static int[] dx = {0,0,1,-1 };
public static int[] dy = {1,-1,0,0 };
public static double[] dirPercent;
public static boolean visit[][];
public static int N;
public static double answer;

	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		dirPercent = new double[4];
		visit = new boolean[30][30];
		
		for( int i =0 ; i < dirPercent.length ; i++) {
			
			dirPercent[i] = Integer.parseInt(st.nextToken())*0.01;
			
		}
		//가운데에서 시작 
		visit[14][14] = true;
		
		//이동 0번 ,확률 1 시작! 
		dfs(14,14,0,1.0);

		
		System.out.println(answer);

	}
	
	private static void dfs(int row, int col, int cnt, double percent) { 
		
		//N 번 다돌았으면 그동안의 확률 더하기 
		if(cnt == N) { 
			
			answer += percent; 
			return; 
			
		} 
		
		for (int i = 0; i < 4; i++) {  
				
				//EWSN순으로 이동한 좌표값 
				int x = row + dx[i]; 
				int y = col + dy[i]; 
				
				//들리지 않은곳이라면 들리기 
				if(!visit[x][y]) { 
					
					//들렸던곳 체크해주기 
					visit[x][y] = true; 
					
					//횟수 증가해서 다시 경로찾아주기 
					dfs(x ,y ,cnt + 1 , dirPercent[i] * percent); 
					//다시 들렸던곳을 초기화 해주기 
					visit[x][y] = false; 
					
					} 
				} 
			}


}
