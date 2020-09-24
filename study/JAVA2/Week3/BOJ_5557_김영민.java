import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557_김영민 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] num = new int[N];
		long [][] result = new long [N-1][21]; // 마지막은 결과 & 0이상 20이하
		
		for(int i=0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		result[0][num[0]]++; // 첫 번째 인덱스 1
		
	    for(int i=1;i<N-1;i++){
	        for(int j=0;j<=20;j++){
	        	if(j+num[i]<=20) result[i][j+num[i]]+=result[i-1][j]; //20보다 작은 경우 가능
	            if(j-num[i]>=0)  result[i][j-num[i]]+=result[i-1][j]; //0보다 큰 경우 가능
	        }
	    }
		
		System.out.print(result[N-2][num[N-1]]);
	}
}
