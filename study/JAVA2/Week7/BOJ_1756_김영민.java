import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1756_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long [] diameter = new long [D+1];
		long [] pizza = new long [N];
		
		st = new StringTokenizer(br.readLine());
		diameter[0] = 1000000001; //지름정렬
		for(int i=1; i<=D; i++) {
			long temp = Long.parseLong(st.nextToken());
			diameter[i] = Math.min(temp, diameter[i-1]);
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) pizza[i] = Long.parseLong(st.nextToken());	
		
		int count = 0; //피자의갯수
		int result = 0; //결과
		
		for(int i=D; i>0; i--) {
			if(count!=N) { //남은피자가있을경우
				if(diameter[i]>=pizza[count]) { //지름이피자보다같거나크면
					result = i;
					count++; //다음피자
				}
			}
		}
		
		if(count==N) System.out.print(result); //피자를끝까지담았을경우
		else System.out.print(0); //아닐경우
	}
}
