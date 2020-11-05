import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_5052_김영민 {

	static int n;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			String [] number = new String [n];
			for(int j=0; j<n; j++) {
				number[j] = br.readLine();
			}
			Arrays.sort(number); // 입력받은 전화번호 목록 정렬
			bw.write(solve(number)); 
		}
		bw.flush();
	}
	
	public static String solve(String [] number) {
		for(int i=0; i<n-1; i++) {
			if(number[i+1].startsWith(number[i])) { // 접두어이면
				return "NO\n";
			}
		}
		return "YES\n";
	}
}
