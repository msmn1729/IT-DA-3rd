package q1747;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=N;i<=1000000;i++) {
			String temp = Integer.toString(i);
			char[] arr = temp.toCharArray();
			boolean check = true;
			if(isPrime(i)==true) {
				for(int j=0;j<arr.length/2;j++) {
					if(arr[j] != arr[arr.length-(j+1)]) {
						check = false;
					}
				}
				if(check ==true) {
					System.out.println(i);
					return;
				}	
			}
			
		}		
	}
	static boolean isPrime(int n) {
		if(n==1) return false;
		
		for(int i =2 ;i*i<= n;i++) {
			if(n % i ==0) {
				return false;				
			}
		}
		return true;
	}
}
