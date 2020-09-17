import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1926_김영민 {
	static int n, m;
	static int [][] paper;
	static boolean [][] visited;
	static int count=0;
	static int size=0;
	static int maxSize=0;
	static int [] offseti= {1,-1,0,0};
	static int [] offsetj= {0,0,1,-1};
	
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		size++; //현재 그림의 크기++
		
		for(int k=0; k<4; k++) {
			int tempi = i+offseti[k];
			int tempj = j+offsetj[k];
			if(tempi>=0 && tempi<n) {
				if(tempj>=0 && tempj<m) {
					if(paper[tempi][tempj]==1 && !visited[tempi][tempj]) {
						dfs(tempi, tempj);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(paper[i][j]==1 && !visited[i][j]) {
					size = 0; //현재 그림의 크기 0부터 시작
					count++; //그림의 개수
					dfs(i,j);
					if(size>maxSize) maxSize = size; //한 dfs가 끝난 후에 최대값 비교
				}
			}
		}
		System.out.print(count+"\n"+maxSize);
	}
}
