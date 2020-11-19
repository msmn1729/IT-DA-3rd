import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pizza {

	public static void main(String[] args) throws IOException {
		// 피자를 쌓아올리자.
		int D;
		int N;
		int lim[];
		int width;
		int piz;
		int height;
		int sw = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());//화덕깊이
		N = Integer.parseInt(st.nextToken());//피자개수
		
		height = D - 1;
	
		lim = new int[D];
		
		st = new StringTokenizer(br.readLine());
		lim[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < D; i++) {
			width = Integer.parseInt(st.nextToken());
			if(width < lim[i - 1]) {
				lim[i] = width;
			}
			else
				lim[i] = lim[i-1];
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			piz = Integer.parseInt(st.nextToken());
			for(int j = height; j >= 0; j--) {
				if(lim[j] >= piz) {
					sw = 1;
					height = j - 1;
					break;
				}
				else {
					sw = 2;
				}
			}
			if(sw == 2) {
				System.out.println(0);
				break;
			}
			if(i != N -1 && height < 0) {
				System.out.println(0);
				sw = 0;
				break;
			}
		}
		if(sw == 1) {
			System.out.println(height+2);
		}
	}

}
