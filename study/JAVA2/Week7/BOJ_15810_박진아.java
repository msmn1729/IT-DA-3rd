package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 스태프의 수 N과 풍선의 개수 M이 입력된다. (1 < N ≤ 1 000 000, 0 < M ≤ 1 000 000)
 * 걸리는 시간 Ai가 순서대로
3 8
5 7 3

3 9
5 7 3

15분 --> 3+2+5 10개 
14분 --> 2+2+4 8개 

왜틀리지 
 */
public class Q15810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); int M=Integer.parseInt(input[1]);
		input= br.readLine().split(" ");
		int[] Narr = new int[N];
		int l=1, h=0;
		for(int i=0;i<N;i++) {
			Narr[i]=Integer.parseInt(input[i]);
			l=Math.min(l,Narr[i]); h=Math.max(h,Narr[i]);
		}
		
		if(M==0) {System.out.println(0); return;}
		
		long high=h*M;
		while(l<=high) {
			int m = (int) ((l+high)/2);
			
			int cnt=0;// 풍선의 개수 
			for(int i=0;i<N;i++) {
				cnt+=m/Narr[i];
			}
			
//			System.out.println(m+"\t"+cnt+"\t"+l+"\t"+high);
			if(cnt>=M) {
				high=m-1;
			}
			else {
				l=m+1;
			}
		}
		System.out.println(l);
	}

}
