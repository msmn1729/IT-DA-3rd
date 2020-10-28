import java.util.Scanner;

public class BOJ_4811_우창완 {
	static int cnt[][]=new int[31][61];
	static int dp[][]=new int[31][61];
	
	public static void main(String[] args) {
		//w는 온전한 알약 개수, h는 반쪽자리 알약 개수
		//w=0 일때 h의 숫자에 관계없이 1
		for(int i=0; i<=60; i++) {
			dp[0][i]=1;
		}
		for(int w=1; w<=30; w++) {
			for(int h=1; h<=60; h++) {
				dp[w][h]=dp[w-1][h+1]+dp[w][h-1];
			}
		}
		int n;
		Scanner scan=new Scanner(System.in);
		while(true) {
			n=scan.nextInt();
			if(n==0) break;
			System.out.println(dp[n-1][0]);
		}

	}

}
