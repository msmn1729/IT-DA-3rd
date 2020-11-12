import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cutting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 단절점은 끝 점만 아니면 다 단절점?
		// 트리에서 간선은 모두 단절선아닌가?
		int N;
		int q;
		int t;
		int k;
		int Map[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Map = new int[N+1];
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			++Map[Integer.parseInt(st.nextToken())];
			++Map[Integer.parseInt(st.nextToken())];
		}
		q = Integer.parseInt(br.readLine());
		for(int i = 0; i < q; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st1.nextToken());
			k = Integer.parseInt(st1.nextToken());
			if(t == 1) {
				if(Map[k] == 1) {
					System.out.println("no");
				} 
				else {
					System.out.println("yes");
				}
			}
			else {
				System.out.println("yes");
			}
		}
	}

}
