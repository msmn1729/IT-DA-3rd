import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Biggest {

	public static void main(String[] args) throws IOException {
		// n자리 수 입력받아서 앞자리 뒷자리 비교하고 뒷자리가 더 크면 삭제하는 방식으로 구현하고싶다..
		int N;
		int K;
		
		String s;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		s = br.readLine();
		for(int i = 0; i < N; i++) {
			
		}
	}

}
