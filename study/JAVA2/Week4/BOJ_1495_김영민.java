import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1495_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] V = new int[N];
		int [][] result = new int [N+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) V[i] = Integer.parseInt(st.nextToken());
		
		result[0][S] = 1; // S=시작볼륨
		
		for(int i=1;i<=N;i++){ // N=곡수
	        for(int j=0;j<=M;j++){ // M=최대볼륨
	        	if(j+V[i-1]<=M) { //최대볼륨보다작을경우
	        		if(result[i][j+V[i-1]] != 1)
	        			result[i][j+V[i-1]]+=result[i-1][j];
	        	}
	            if(j-V[i-1]>=0) { //0이랑크거나같을경우
	        		if(result[i][j-V[i-1]] != 1)
	        			result[i][j-V[i-1]]+=result[i-1][j];
	            }
	        }
	    }
	
		int answer = -1;
		for(int i=0; i<=M; i++) {
			if(result[N][i]==1) answer = i;
		}
		
		System.out.println(answer);
	}
}