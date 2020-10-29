package q10164;

import java.util.Scanner;

public class Q10164 {
	
	static int N,M,O;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] s1 = s.split(" ");
		
		N=Integer.parseInt(s1[0]);
		M=Integer.parseInt(s1[1]);
		if(s1.length>=3) {
			O=Integer.parseInt(s1[2]);
		}
		
		int[][] arr= new int[N][M];
		arr[0][0]=1;
		if(O>0) {
			
			for(int i=0; i<N; i++) {
				for(int j =0; j<M ;j++) {
					
				}
			}
			
		}else {
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(n==0 && m==0) continue;
					arr[0][m] =1;
					arr[n][0] =1;
					arr[n+1][m+1]= arr[n][m+1] + arr[n+1][m];
				}
			}
			System.out.println(arr[N-1][M-1]);
		}
	
	}
}
