import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1405_김영민 {

	static int N;
	static double [] probability = new double[4];
	static boolean [][] visited = new boolean[29][29];
	static int [] offsetX = {0,0,1,-1}; //동서 남북
	static int [] offsetY = {1,-1,0,0};
	static double answer = 0;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<4; i++) probability[i] = Double.parseDouble(st.nextToken()) / 100;
	
		dfs(14,14,0,1.0); //visited중간점에서시작
		System.out.print(answer);
	}
	
	public static void dfs(int x, int y, int count, double result) {
		if(count==N) {
			answer += result;
			return;
		}
	
		visited[x][y] = true;
		
		for (int k = 0; k < 4; k++) { //동서남북이동
			int tempx = x+offsetX[k];
			int tempy = y+offsetY[k];
			if(!visited[tempx][tempy]) {
				dfs(tempx, tempy, count+1, result*probability[k]);	
			}
		}
		
		visited[x][y] = false;
	}
}
