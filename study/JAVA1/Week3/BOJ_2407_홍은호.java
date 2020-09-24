import java.math.BigInteger;
import java.util.Scanner;

public class Comb {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		
		
		
		BigInteger a = factorial(BigInteger.valueOf(n));
		BigInteger b = factorial(BigInteger.valueOf(m));
		BigInteger c = factorial(BigInteger.valueOf(n-m));
		
		BigInteger result = a.divide(b).divide(c);
		
		System.out.println(result);
		
	}
	
	public static BigInteger factorial(BigInteger num) {
		if(num.compareTo(BigInteger.ONE)==0)
			return BigInteger.ONE;
		else
		{
			BigInteger tmp = num.subtract(BigInteger.ONE);
			return num.multiply(factorial(tmp));
		}
			
	}

}
