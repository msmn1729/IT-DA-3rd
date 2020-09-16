package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N=0;
	static boolean isPrime = false;
	static int[] prime;
	static int cnt=1;
	
    public static void main(String args[])  {
    
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    
    prime = new int[] {2,3,5,7}; //맨 앞자리 숫자가 소수로 시작해야한다.
    
    for(int i=0; i<4; i++) {
    	dfs(prime[i], N-1);
    	}
    }
    
   public static void dfs(int num, int length) { 
 
	   if(length==0) System.out.println(num); //길이가 0이 되면 출력하기
	   for(int i=1; i<10; i+=2) { //홀수만 더하기
		   int tmp = num*10 + i;  
		   if(back(tmp)) {
			   dfs(tmp, length-1); //길이를 하나씩 줄여나가기
	   }
	 } 
   }
   
   public static boolean back(int n) { //소수 구하기
	   if(n<2) return false;
	   for(int i=2; i*i<=n; i++) {
		   if(n %i==0) return false;
	   }
	   return true;
	}
}
