import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743_김영민 {

	static int N, M, K;
	static int max = 0;
	static int count = 0;
	static int [] offsetX = {1,0,-1,0};
	static int [] offsetY = {0,1,0,-1};
	static boolean [][] load = new boolean[101][101];
	static boolean [][] visited = new boolean[101][101];
	
	public static void dfs(int i, int j) {
		count++; //count를 올리고
		visited[i][j] = true; //방문
		for (int k = 0; k < 4; k++) {//상하좌우체크
			int tempi = i+offsetX[k];
			int tempj = j+offsetY[k];
			if(tempi>=1 && tempi<=N) {
				if(tempj>=1 && tempj<=M)	{
					if(load[tempi][tempj] && !visited[tempi][tempj])
						dfs(tempi, tempj);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로 길이
		M = Integer.parseInt(st.nextToken()); //가로 길이
		K = Integer.parseInt(st.nextToken()); //쓰레기 개수
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			//각각의 좌표 저장
			load[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(load[i][j] && !visited[i][j]) {
					//음식물 쓰레기가 있고 방문하지 않았었다면
					count = 0; //음식물의 크기
					dfs(i, j); //그 좌표에 대해서 dfs
					if(max<count) max = count; //최대값 갱신
				}
			}
		}
		
		System.out.print(max);
	}

}
