import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11497_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int [] tempL = new int [N];
			
			for(int j=0; j<N; j++) tempL[j] = Integer.parseInt(st.nextToken());
			Arrays.sort(tempL);
						
			ArrayList<Integer> L = new ArrayList<>();
			L.add(tempL[0]);
			
			//정렬후에앞뒤로넣어보자
			//맨처음과맨끝도인접해있기때문에
			for(int j=1; j<N; j++) {
				if(j%2!=0) L.add(0,tempL[j]);
				else L.add(tempL[j]);
			}
			
			//맨처음과맨끝값의차이로초기화
			int result = Math.abs(L.get(N-1)-L.get(0));
			for(int j=1; j<N; j++) result = Math.max(result, Math.abs(L.get(j-1)-L.get(j)));
			bw.write(result+"\n");
		}	
		bw.flush();
		bw.close();
	}
}
