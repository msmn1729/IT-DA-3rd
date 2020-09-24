package itda;
import java.io.*;
import java.util.*;
import java.math.*;

public class BOJ_2407_김민정 {

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;
        
        for(int i=0; i<m; i++) {
            num1 = num1.multiply(new BigInteger(String.valueOf(n-i)));
            num2 = num2.multiply(new BigInteger(String.valueOf(i+1)));
        }
        
        System.out.println(num1.divide(num2));
    }

}
