package itda_2020;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ_2407_박소현 {
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
	     M = Integer.parseInt(st.nextToken());

	     BigInteger bigNum1 = BigInteger.ONE;  
	     BigInteger bigNum2 = BigInteger.ONE;  
	     
	     for (int i=M+1;i<=N;i++) {
	    	 bigNum1 = bigNum1.multiply(new BigInteger(String.valueOf(i)));
	    	 bigNum2 = bigNum2.multiply(new BigInteger(String.valueOf(N-i+1)));
	     }
	     BigInteger result = bigNum1.divide(bigNum2);
	     bw.write(result+"");
	     
	     bw.flush();
	     br.close();
	     bw.close();
	}

}
