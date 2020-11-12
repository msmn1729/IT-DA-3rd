import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14675_김영민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int [] trees = new int [N+1];
		
		for(int i=0; i<N-1; i++){
			st = new StringTokenizer(br.readLine());
			trees[Integer.parseInt(st.nextToken())]++;
			trees[Integer.parseInt(st.nextToken())]++;
		}
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++){
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(t==2) bw.write("yes\n");
			else {
				if(trees[k]>=2) bw.write("yes\n");
				else bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
