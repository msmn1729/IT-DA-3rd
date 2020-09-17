package itda;
import java.io.*;
import java.util.*;

public class BOJ_2023_김민정 {
	
	static ArrayList<Integer> res = new ArrayList<Integer>();

	public static void dfs(int primeNum , int n ){
		
		if(n==0){
			res.add(primeNum);
		}else{
			// add odd number
			for( int i=1; i<10; i +=2){
				int num = primeNum*10 + i;
				// prime number ... search
				if(primeTest(num)) {
					dfs(num, n-1);
				}
		
			}
		}
		
		
	}
	public static boolean primeTest(int num) {
		// 1 is not prime number 
		if( num == 1) return false;
		
		for(int i=2 ; i*i < num ; i++) {
			if(num%i ==0 ){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] primeNum = { 2,3,5,7};
		
		for( int i=0 ; i< primeNum.length ; i++) {
			dfs(primeNum[i], N-1);
		}
		for( int i : res){
			System.out.println(i);
		}

	}

}
