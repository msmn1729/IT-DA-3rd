package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 아 ... 이중포문때문에 시간초과 걸렸음 
 */
public class Q5052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n=0;
		
		for(int i=0;i<t;i++) {

			String ans ="YES";
			boolean flag=false;
			
			n= Integer.parseInt(br.readLine());
			String[] phonenum= new String[n];
			
			for(int j=0;j<n;j++) {
				phonenum[j]=br.readLine();
			}
			
			Arrays.parallelSort(phonenum);
			for(int m=0; m<n-1; m++) {
				int length=phonenum[m].length();
					if(length<phonenum[m+1].length()) {
						if(phonenum[m].equals(phonenum[m+1].substring(0, length))){
							ans="NO";
							flag=true;
							break;
						}
					}
			}
			if(flag) System.out.println("No");
			else System.out.println("Yes");

		}
	}
}
