import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Combination {

	public static void main(String[] args) throws IOException {
		// 조합 dp!
		// 매우 큰 수가 문제..(big integer을 안쓰면 해결이 안됌)
		// 굳이 DP로 안품..
		// 공식 nCr = nPr / r! 이용해서 풀었슴돠..
		ArrayList<BigInteger> list = new ArrayList<>();  
		BigInteger n, m;
		BigInteger sum = BigInteger.ONE;
		int a, b;
		int temp;
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = st.nextToken();
		b = Integer.parseInt(s);
		n = new BigInteger(s);
		s = st.nextToken();
		m = new BigInteger(s);
		a = Integer.parseInt(s);
		
		if(n.equals(m))
			System.out.println(1);
		else {
			for(int i = 0; i < a; i++) {
				temp = b - i;
				list.add(new BigInteger(temp + ""));//nPr을 list에 저장 하는 부분 
			}
			for(int i = a; i > 0; i--) {//r!이 돌아가면서 나눠지는 부분  
				while(!list.isEmpty()) {
					if(list.get(0).remainder(new BigInteger(i + "")).equals(BigInteger.ZERO)) {
						list.set(0, list.get(0).divide(new BigInteger(i + "")));
						break;
					}
					else {
						list.set(0, list.get(0).multiply(list.get(1)));
						list.remove(1);
					}
				}
			}
			
			for(BigInteger i : list) {
				sum = sum.multiply(i);
			}
			
			System.out.println(sum);
		}
		
		
	}
	
}
