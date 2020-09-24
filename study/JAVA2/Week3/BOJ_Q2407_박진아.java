import java.util.Scanner;
import java.math.BigInteger;

/*
 * nCm을 출력한다.
 * 
 * 입력
 * n과 m이 주어진다. (5 ≤ n ≤ 100, 5 ≤ m ≤ 100, m ≤ n)

출력
nCm을 출력한다.

 * 100 6
 * 
 * 팩토리얼 값 
 * 
 * 4! = 1*2*3*4 = 3!*4
 * 3! = 1*2*3 = 2!*3
 * 2! = 1*2 = 1!*2
 * 
 * n! = 1*...*(n-1)
 * 
 * f(n)=f(n-1)*f(n-2)
 * 
 * 10C4
 * 10*9*8*7 / 4*3*2*1
 * 
 * 왜 틀렸지 -> BigInteger... 사용해야함 
 */
public class Q2407 {
	static BigInteger[] list2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m = sc.nextInt();
		
		list2= new BigInteger[m+1];
		list2[1]=BigInteger.valueOf(1);
		
		BigInteger result = Up(n,m).divide(Bottom(m));
		System.out.println(result);
	}
	
	public static BigInteger Up(int n,int m) {
		BigInteger rs = BigInteger.ONE;
		for(int i=n;i>n-m;i--) {
			rs = rs.multiply(BigInteger.valueOf(i));
		}
		return rs;
	}
	
	public static BigInteger Bottom(int m) {
		for(int i=2;i<=m;i++) {
			list2[i]=list2[i-1].multiply(BigInteger.valueOf(i));
		}
		return list2[m];
	}
	

}
