import java.math.BigInteger;
import java.util.*;

public class Main {
	
	static int dp[][] = new int [101][101];

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int M = input.nextInt();
		
		/*System.out.println(dp_f(N, M));*/
		
		/**
		 * 재귀를 사용했더니 틀렸다고 나온다. long을 써도 범위를 초과한다는 이야기가 나오길래
		 * 할 수 없이 이번은 구글링을 통해서 찾았다.
		 * 전혀 모르는 BigInteger가 나오게 되었다!
		 * 
		 * 5C3이라고 하면 543 / 321 이니까 이 점을 활용한것 같다!
		 */
		
		BigInteger bigN = BigInteger.ONE;
		BigInteger bigM= BigInteger.ONE;
		
		for(int i = 0; i < M; i++) { // M번만큼 돌기.
			
			//이 과정이 N을 M개만큼 뽑아서 곱하는 과정이다.
			bigN = bigN.multiply(new BigInteger(String.valueOf(N-i)));
			
			//이 밑에 과정은 말 그대로 M!인 것이다.
			bigM =  bigM.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(bigN.divide(bigM));
		
	}
	
	/*public static int dp_f(int n, int k) {
		
		if(k > n || k < 0)
			dp[n][k] = 1;
		
		else {
			dp[n][k] = dp_f(n-1, k-1) + dp_f(n-1, k);
		}
		
		return dp[n][k];
	}*/

}
