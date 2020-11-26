package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * A의 크기가 {8, 1, 7, 3, 1}이고, 
 * B의 크기가 {3, 6, 1}인 경우에 
 * A가 B를 먹을 수 있는 쌍의 개수는 7가지가 있다. 
 * 8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.
 * 20,000
 * 이게 왜 이분탐색이지 
 * 
 * 목표: 엔제곱만 피하자
 */

public class Q7795 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int res = 0;
			
			int[] aarr = new int[n];
			int[] barr = new int[m];
			
			input=br.readLine().split(" ");
			for(int j=0;j<n;j++) aarr[j]=Integer.parseInt(input[j]);
			input=br.readLine().split(" ");
			for(int j=0;j<m;j++) barr[j]=Integer.parseInt(input[j]);
			
			Arrays.parallelSort(aarr);
			Arrays.parallelSort(barr);
			
			
			int start = 0;
			for(int j=0;j<n;j++) {
				//B arr 시작값을 갱신하면 될거같은데... 
				for(int k=start;k<m;k++) {
					if(aarr[j]>barr[k]) {
						start +=1;
						res += start;
					}
				}
			}
			
			System.out.println(res);
		}
	}
}
