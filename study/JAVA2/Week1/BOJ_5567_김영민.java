import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5567_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String [] temp = new String[2];
		boolean [][] friend = new boolean[501][501];
		boolean [] result = new boolean[501];
		
		for(int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			friend[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = true;
			friend[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = true;
			
			if(Integer.parseInt(temp[0])==1)
				result[Integer.parseInt(temp[1])] = true;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(friend[1][i] && friend[i][j]) {
					result[j] = true;
				}				
			}
		}

		int count = 0;
		for(int i=2; i<=n; i++)
			if(result[i]) count++;
		
		System.out.print(count);
	}
}
