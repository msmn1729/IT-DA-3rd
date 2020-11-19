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
//1756
public class Main11 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] oven = new int[D];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}

        int[] pizza = new int[N];

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }
        int idx=D;
        for(int j=0; j<N;j++) {
        	for(int i =0; i<idx; i++) {
        		if(i==idx-1)idx = idx-1;
        		if(oven[i]<pizza[j]) { 
        			idx = i; 
        			break;
        		}
        	}
        }
        System.out.print(idx);
	}
}