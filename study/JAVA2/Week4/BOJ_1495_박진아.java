import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 못풀겠음!!

public class Q1495 {
	
	static int dp[] = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N,S,M=0;
		int V[] = new int[101];
		N= Integer.parseInt(input[0]);
		S=Integer.parseInt(input[1]);
		M=Integer.parseInt(input[2]);
		input=br.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			V[i]=Integer.parseInt(input[i-1]);
		}
		
		int sound[][] = new int[M+1][N];// 모든 경우의 볼륨 크기가 저장 되는 배열 ...
		int P=S; // 현재 볼륨 
		
		for(int i=1;i<=N;i++) {
			
			if(0<=P&&P+V[1]<=M) {
				sound[P+V[1]][N]=P+V[1];
				P=P+V[1];
			}
			
			if(0<=P&&P-V[1]<=M) {
				sound[P-V[1]][N]=P-V[1];
				P=P-V[1];
			}
		}
		
//		 * 3 2 5
//V[i]=V[i-1]+P||V[i-1]-P
		
/*
 * V[1]= P + V[1] or P - V[1]
 * V[2]= P + V[2] or P - V[2]
 * 	   = P + (P+V[1])/ P+(P-V[1])  or P-(P+V[1]) / P-(P-V[1])
 * V[3]= P + V[3] or P - V[3]
 */
//		 * V[1] = 8 || -2
//		 * V[2] = 10, 6 || 
//		 * V[3] = 15, 5 || 1, 11 
//		 * 
		
		int ans=0;
		for(int i=1;i<=N;i++) {
			ans=Math.max(ans, sound[i][M]);
		}
		
	}
}
