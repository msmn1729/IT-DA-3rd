import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_김영민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char [] S = br.readLine().toCharArray();
	
		int result = 0;
		int count = 0;
		
		for(int i=1; i<M-1; i++) {
			if(S[i-1]=='I' && S[i]=='O' && S[i+1]=='I') {
				count++;
				if(count == N) {
					count--;
					result++;
				}
				i++;
			} else count = 0;
		}
		
		System.out.print(result);
	}
}
