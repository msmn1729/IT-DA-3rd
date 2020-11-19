package q1946;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class New_recruits {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Integer> a;
		ArrayList<Integer> b;

		int[][] arr;
		for(int i=0;i<T;i++) {
			int N= sc.nextInt();
			a= new ArrayList();
			b= new ArrayList();
			arr = new int[N][2];
			for(int j=0;j<2;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k]=sc.nextInt();
					a.add(arr[0][k]);
				}
			}
			Collections.sort(a);
			
			
		}
	}
	
}
