package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main7 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int t =0; t<T; t++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	int[] afish = new int[a];
        	int[] bfish = new int[b];
        	
        	for(int i=0; i<a; i++) {
        		afish[i] = sc.nextInt();
        	}
        	for(int i=0; i<b; i++) {
        		bfish[i] = sc.nextInt();
        	}
        	Arrays.sort(bfish);
        	int count=0;
        	
        	for(int i=0; i<a; i++) {
        		for(int j=0; j<b; j++) {
        			if(afish[i]<=bfish[j]) {
        				break;
        			}
        			count++;
        		}
        	}
        	System.out.println(count);
        }
	}
}
