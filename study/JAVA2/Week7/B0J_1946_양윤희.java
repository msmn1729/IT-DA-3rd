package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main7 {
	static int cnt;
	static int[] first, second;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     int T = Integer.parseInt(st.nextToken());
	     while(T-- >0) {
			st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int cnt = N;
	      
	        first = new int[N];
	        second = new int[N];
	        
	        for(int i=0; i<N; i++) {
	        	String[] str = br.readLine().split(" ");
				first[i] = Integer.parseInt(str[0]);
				second[i] = Integer.parseInt(str[1]);
	        }
	        for(int j=0; j<N; j++) {  
	        	for(int i=0; i<N; i++) {
	        		if(i==j) continue;
	        		if(first[j]>first[i] && second[j]>second[i]) {
	        			cnt--;
	        			break;
	        		}
	        	}
	        }
	        System.out.println(cnt);
	    }
	}
}
