import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14502_김영민 {

	static int N;
	static int M;
	static int [][] map = new int[8][8];
	static int [][] temp = new int[8][8];
	static ArrayList<Xy> virusList = new ArrayList<Xy>();
	static int [] offsetX = {1,-1,0,0}; //인접한곳으로이동
	static int [] offsetY = {0,0,1,-1};
	static int max = 0;
	
	static class Xy {
		int x;
		int y;
		Xy(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		map = new int[N][M];
		temp = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virusList.add(new Xy(i, j));
			}
		}
		wall(0);
		System.out.print(max);
	}
	
	static void wall(int count) {
		if (count == 3) {
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                	temp[i][j] = map[i][j];        	
                }
            }
            
            for(int i=0; i<virusList.size(); i++)
            	virus(virusList.get(i).x, virusList.get(i).y);

            max = Math.max(max, count());
			return;
        }
		
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
            	if (map[i][j]==0) {
	                map[i][j] = 1;
	                wall(count + 1);
	                map[i][j] = 0;
	        	}
            }
        }
	}
	
	static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + offsetX[i];
            int ny = y + offsetY[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (temp[nx][ny] == 0) {
                	temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }
	
	static int count() {
		int count = 0;
	    for(int i = 0; i < N; i++){
	        for(int j = 0; j < M; j++){
	            if(temp[i][j] == 0)
	                count+=1;
	        }
	    }
	    return count;
	}
}
