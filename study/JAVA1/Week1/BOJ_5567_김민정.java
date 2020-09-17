package itda;
import java.util.*;
import java.io.*;


public class BOJ_5567_김민정 {

	public static boolean friend[][]; 
	public static boolean check[];
	public static int n, m , answer;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		friend = new boolean[n+1][n+1];
		check = new boolean[n+1];

		
		for( int i =0 ; i<m ;i ++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 인접행렬로 표현해준다. 
			friend[a][b] = true;
			friend[b][a] = true;
		}
		for( int i = 2; i <= n ;i++) {
			//상근이인 1과 친구인가 
			if(friend[1][i]) {
				//친구이면 check해주기!
				check[i] = true;
				
				for( int j =2; j <= n; j++) {
					//친구의 친구이면 check!!
					if( friend[i][j] == true)
						check[j] = true;
				}
			}
		}
		
		for( int i =2 ;i <= n ;i++) {
			if(check[i] == true)
				answer++;
		}
		
		System.out.println(answer);
	}

}
