package q14675;

import java.util.Scanner;

public class Cut_VertexBridge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] a = new int[N-1];
		int[] b = new int[N-1];
		for(int i=0;i<N-1;i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int[] t = new int[q];
		int[] k = new int[q];
		for(int j =0; j<q;j++) {
			t[j] = sc.nextInt();
			k[j] = sc.nextInt();
		}
		for(int m =0;m<q;m++) {
			if(t[m] ==2) {
				System.out.println("yes");
			}else if(t[m]==1){
				int cnt = 0;
				for(int i=0;i<N-1;i++) {
					if(a[i] == k[m]) {
						cnt+=1;
					}
					else if(b[i] == k[m]) {
						cnt+=1;
					} 
				}
				if(cnt>=2) {
					System.out.println("yes");
				}else
					System.out.println("no");
			}
		} //결과 출력문
		
	} //main문
	
}
