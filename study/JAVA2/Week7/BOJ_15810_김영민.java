import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ_15810_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		long right = 500000000000l;
		long left = 1l;
		
		while(left<=right) {
			long result = 0;
			long mid = (left+right)/2;
			for(int i=0; i<N; i++) result += mid / A[i];
			if(result >= M) right = mid-1;
			else left = mid+1;
		}
		
		System.out.print(left);
	}
}
