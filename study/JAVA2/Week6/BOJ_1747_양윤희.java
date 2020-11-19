package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main11 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		 while(true) {
	            if(prime(n) && palin(n)) {
	                System.out.println(n);
	                return;
	            }
	            n++;
	        }
	    }		
	static boolean prime(int x) {//소수 인지 확인
        if (x == 1) return false;
         
        // 에라토스 뭐시기로 풀기 귀찮,,,그냥 1과 자기자신으로만 나뉘는지,,,,
        for(int i=2; i*i<=x; i++) {
            if(x % i == 0) return false;
        }
        return true;
	}
		     
	static boolean palin(int x) { //팰린드롬인지 확인
        char[] arr = String.valueOf(x).toCharArray();
        int s = 0, e = arr.length-1;
         
        while(s < e) {
            // 대칭되는 문자가 일치하는지 확인
            if(arr[s] != arr[e]) return false;
            s++; e--;
        }
        return true;
	}

}
