package itda_2020;


import java.util.*;
import java.io.*;

public class BOJ_5557_박소현 {
	static int N;
	public static long[][] array ;
	public static int[] numbers;
	 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		 N = Integer.parseInt(br.readLine());
		 numbers = new int[N];
		 array = new long[N-1][21];
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());

		 int i = 0;
		 while (st.hasMoreTokens()) {
	            numbers[i] = Integer.parseInt(st.nextToken());
	            i++;
	        }
	     dp();
	     
	     for (int a = 0 ; a < N ; a++) {
	    	 bw.write(numbers[a]+" ");
	     }
	     bw.write("\n");
	     
	     for (int k = 0; k < N-1 ; k++) {
				for (int j = 0; j < 21 ; j++) {
					bw.write(array[k][j]+" ");
					}
				bw.write("\n");
			}
	     
	     bw.write(array[N-2][numbers[N-1]]+"");
	     
	     bw.flush();
	     br.close();
	     bw.close();
	     //https://hyunah030.tistory.com/5 이 방식 참고 
	}

	static void dp() {
		
		for (int i = 0; i < N-1 ; i++) {
			for (int j = 0; j < 21 ; j++) {
				array[i][j] = 0;
				}
		}
		
		array[0][numbers[0]] = 1;
		
		for (int i = 0; i < N-2 ; i++) {
			for (int j = 0; j < 21 ; j++) {
				if (array[i][j] != 0) {
					if (j+numbers[i+1] <=20) {
						array[i+1][j+numbers[i+1]]=array[i+1][j+numbers[i+1]]+array[i][j];
					}
					if (0 <= j-numbers[i+1] ) {
						array[i+1][j-numbers[i+1]]=array[i+1][j-numbers[i+1]]+array[i][j] ;
					}
					else continue;
				}
			}
		}
	}
}
