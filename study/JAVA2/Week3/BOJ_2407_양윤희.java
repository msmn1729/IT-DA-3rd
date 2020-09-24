package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main6 {
	static BigInteger n, m, sum, sum2; //큰 수 입력받기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = new BigInteger(st.nextToken());
		m = new BigInteger(st.nextToken());
		sum =n;
		sum2 =m;
		
		
		
		while(m.compareTo(BigInteger.ONE)==1) { //분모 분자 모두 m개를 곱하는 것이므로 m개만큼
			
			n = n.subtract(BigInteger.ONE);
			m = m.subtract(BigInteger.ONE);

			sum  = sum.multiply(n);//곱하기
			sum2 = sum2.multiply(m);
		}
		
		System.out.println(sum.divide(sum2));//나누기
	}
}