package backjoon.study.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수&팰린드롬 https://www.acmicpc.net/problem/1747
/*
 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.
 어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.
 
 isPrime 과 isPalind 함수 두개 만들어서 완탐으로 일단 해보자. 100만이라 100만 탐색 * 2 해도 1초 안에 가능
 소수는 고냥 루트 까지 돌고 ㅇㅇ  
 */
public class PrimeAndPalindrome {
	public static void main(String[] args) throws IOException {         
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
         
        while(true) {
            if(isPrimeNumber(N) && isPalindrome(N)) {
                System.out.println(N);
                return; // system.exit(1);
            }
            N++;
        }
    }
 
    private static boolean isPrimeNumber(int x) {
        if (x == 1) return false;
        for(int i = 2; i <= Math.sqrt(x); i++) { // Math.sqrt(x)
            if(x % i == 0) return false;
        }
        return true;
    }
     
    // 완탐으로 
    private static boolean isPalindrome(int x) {
        char[] charArr = String.valueOf(x).toCharArray();
        int s = 0, e = charArr.length-1;
        while(s < e) { // 대칭되는 문자가 일치하는지 확인
            if(charArr[s] != charArr[e]) return false;
            s++; e--;
        }
        return true;
    }
}
