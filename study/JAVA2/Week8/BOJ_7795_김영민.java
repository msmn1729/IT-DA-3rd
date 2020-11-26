import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795_김영민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer((br.readLine()));
		
		int T = Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int [] A = new int [N];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				A[j] = Integer.parseInt(st.nextToken());
		
			int [] B = new int [M];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				B[j] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(A); //둘다정렬하고비교
			Arrays.sort(B);
			
			int count = 0;
			for(int k=0; k<N; k++) {
				for(int l=0; l<M; l++) {
					if(A[k] > B[l]) count++; 
					else break; // A[k]가B[l]보다작다면그이후에값들에대해서도작을것이다
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
	}
}
