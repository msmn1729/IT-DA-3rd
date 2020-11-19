import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1946_김영민 {
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		/**
		 * 1 4
		 * 2 3
		 * 3 2
		 * 4 1
		 * 5 5
		 */
			
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int [] rank = new int[N+1];
			for(int j=0; j<N; j++) {
				String [] temp = br.readLine().split(" ");
				rank[Integer.parseInt(temp[0])] = Integer.parseInt(temp[1]);
			}
			
			int count = 1;
			int minRank = rank[1];
			
			for(int k=2; k<=N; k++) {
				if(rank[k]<minRank) { //면접성적만비교
					minRank=rank[k];
					count++;
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
	}
}
