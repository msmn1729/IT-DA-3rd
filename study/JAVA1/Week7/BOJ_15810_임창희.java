package q15810;

import java.util.Scanner;

public class Balloon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int[] S = new int[1000000];
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		
		for(int k=1;;k++) {
			int sum = 0;
			for(int j=0;j<N;j++) {
				sum += (k/A[j]);
			}

			if(sum == M) {
				System.out.println(k);
				break;
			}
			
		}
	}
}
