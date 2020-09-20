package q2407;


import java.math.BigInteger;
import java.util.Scanner;

public class Q2407 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		n=sc.nextInt();
		m=sc.nextInt();
		
		if((n/2)<m) {
			m = n-m;
		}
//		nCm = nPm / m!
//		up = nPm , down = m!
//		BigInteger의 범위는 무한대이다. 따라서 BigInteger클래스를 사용하면 int나 long으로 표현할 수 없는 수도 표현이 가능하다.
		BigInteger up = BigInteger.ONE;
		BigInteger down = BigInteger.ONE;
		
		for(int i =0 ; i<m;i++) {
			up = up.multiply(new BigInteger(String.valueOf(n-i)));
			down = down.multiply(new BigInteger(String.valueOf(i+1)));
		}
		BigInteger result = up.divide(down);
		
		System.out.println(result);
	}
}
