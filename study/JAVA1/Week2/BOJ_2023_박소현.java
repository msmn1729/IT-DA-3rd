package itda_2020;

import java.io.*;
import java.util.*;


public class BOJ_2023_박소현 {
	private static int N;
	static boolean[] arr = new boolean[100000000];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int rangeStart=1, rangeEnd=1;
		arr[0] = arr[1] = false;
		for (int i = 2; i<100000000;i++) {
			arr[i] = true;
		}
		for (int i = 1; i < N ; i++) {
			rangeStart = rangeStart*10;
		}
		rangeEnd = rangeStart*10;
		
		Prime(rangeEnd);
		
		for (int i = rangeStart; i < rangeEnd ;i ++) {
			//SearchMystery(i);
			dfs(i);
		}
	}

	static void dfs(int num) {
		
	}
	
	static void Prime(int End){
		for(int i = 2; i*i<=End; i+=1) {
            for(int j=i*i; j<=End; j+=i) {
                arr[j] = false;       
            }
        }
	}
	
	static boolean SearchPrime(int num) {
		boolean result = false;
		if (arr[num]) {result = true;}
		return result;
	}

}

/*static void SearchMystery(int num) {
	int tmp = num;
	for (int i = 0; i < N ; i++) {
		if (!SearchPrime(num)) {
			return;
		}
		num = num/10;
	}
	System.out.println(tmp);
}
*/
/*
 static boolean SearchPrime(int num) {
		boolean result = true;
		int end = (int)Math.sqrt(num);
		for (int i = 2; i<=end;i++) {
			if (num%i==0) {
				result = false;
				break;
			}
			else {
				result = true;
			}
		}
		return result;
	}
*/