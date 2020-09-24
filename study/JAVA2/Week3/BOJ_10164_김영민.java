import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10164_김영민 {
	static int[][] map = new int [15][15];
	static int[][] check = new int [15][15];
	static int checki, checkj;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		init(N, M, K);
		dp(N, M, K);
		
		System.out.println(dp(N,M,K));
	}
	
	static void init(int N, int M, int K) {
		//오른쪽으로 가는 경우와 아래쪽으로 가는 경우는 1가지 뿐이다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i==0||j==0)map[i][j]=1;
			}
		}
		
		if(K!=0) {
			//k값 체크
			int count = 1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					check[i][j]=count++;
					if(check[i][j]==K) {
						checki = i;
						checkj = j;
					}
				}
			}
		}
	}
	
	static int dp(int N, int M, int K) {
		// 1 1 1 1 1
		// 1 2 3 4 5
		// 1 3 6 10 15
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				map[i][j]=map[i-1][j]+map[i][j-1];
			}
		}
		
		if(K==0) return map[N-1][M-1];
		else return map[checki][checkj] * map[N-checki-1][M-checkj-1];
	}
}
