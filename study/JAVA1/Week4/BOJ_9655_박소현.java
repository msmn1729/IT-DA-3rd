package itda_2020;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9655_박소현 {	
	
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		if(N%2 == 1) System.out.println("SK");
		else  System.out.println("CY");
	}

}
