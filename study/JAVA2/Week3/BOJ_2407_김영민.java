import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2407_김영민 {
		
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger nfac = BigInteger.ONE; // 1
		BigInteger mfac = BigInteger.ONE; 
		BigInteger nmfac = BigInteger.ONE;
		
		for(int i=2; i<=n; i++) nfac = nfac.multiply(BigInteger.valueOf(i)); // n!
		for(int i=2; i<=m; i++) mfac = mfac.multiply(BigInteger.valueOf(i)); // r!
		for(int i=2; i<=n-m; i++) nmfac = nmfac.multiply(BigInteger.valueOf(i)); // n-r!
	
		BigInteger result = BigInteger.ONE;
		result = result.multiply(nfac); // n!
		result = result.divide(mfac); // n!/r!
		result = result.divide(nmfac); // n! / r!(n-r)!
		
		System.out.print(result);
	}
}
