import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_2407_우창완 {
	static BigInteger[][] combination;
	public static void main(String[] args) throws IOException {
		int n,m;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[]temp= br.readLine().split(" ");
		n=Integer.parseInt(temp[0]);
		m=Integer.parseInt(temp[1]);
		BigInteger big= new BigInteger("1");
		combination= new BigInteger[1001][1001];
		combination[0][0]=big;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0||j==i) combination[i][j]=big;
				else	combination[i][j]=combination[i-1][j].add(combination[i-1][j-1]);
			}
		}
		//2번 풀이
		BigInteger a=BigInteger.ONE;
		BigInteger b=BigInteger.ONE;
		for(int i=0; i<m; i++) {
			a=a.multiply(BigInteger.valueOf(n-i));
			b=b.multiply(BigInteger.valueOf(i+1));
		}
		System.out.println(a.divide(b));
		//System.out.println(combination[n][m]);
	}

}
