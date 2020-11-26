package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 이때 각 인접한 통나무의 높이 차가 최소가 되게 하려 한다.
 * 아.. 그리디 진짜 너무 싫다
 * 구글링 하겠음...
 */
public class Q11497 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			String input[] = br.readLine().split(" ");
			int narr[] = new int[n]; for(int m=0;m<n;m++) {narr[m]=Integer.parseInt(input[m]);}
			
			Arrays.parallelSort(narr);
			int rs= 0;
			for(int index=2;index<n;index++) {
				rs = Math.max(rs, Math.abs(narr[index]-narr[index-2]));
			}
			System.out.println(rs);
		}
	}
}
