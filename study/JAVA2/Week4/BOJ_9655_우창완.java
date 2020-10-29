import java.util.Scanner;

public class BOJ_9655_우창완 {
	public static void main(String[] args) {
		//dp[i]=dp[i-1]+1, dp[i-3]+1이다 따라서 홀수는 항상 sk 짝수는 cy
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		if(n%2==0) System.out.println("CY");
		else System.out.println("SK");
	}
}
