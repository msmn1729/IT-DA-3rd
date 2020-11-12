import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {

	public static void main(String[] args) throws IOException {
		//문자열 비교.. 일단 단순히 생각했는데 시간초과 나옴
		//IOI패턴을 찾아서 하나 찾으면 하나 빼주는 식으로~ 구함
		String S;
		int N = 0;
		int M = 0;
		int cnt = 0;
		int count = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		for(int i = 0; i < M - 3; i++) {
			if(S.substring(i, i + 3).equals("IOI")) {
				++cnt;
				++i;
				if(cnt == N) {
					++count;
					--cnt;
				}
			}
			else {
				cnt = 0;
			}
		}
		System.out.println(count);
	}

}
