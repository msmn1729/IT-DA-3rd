package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main8{
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	 
	        int N = Integer.parseInt(st.nextToken());
	        int K = Integer.parseInt(st.nextToken());
	 
	        String input = br.readLine();
	        char[] arr = input.toCharArray();
	        
	        char[] res = new char[N-K];
	        res[0] = arr[0];
	        int idx=0, cnt=0;
	       
	        for(int i=1; i<N; i++) {
	        	if(res[idx]>=arr[i]) {	
	        		if(idx+1>=N-K)break;
	        		res[idx+1] = arr[i];
	        		idx++;
	        		continue;
	        	}
	        	if(res[idx]<arr[i]) {
	        		cnt = idx;
	        		
	        		while(cnt-- >0) {
	        			if(res[cnt]>arr[i] ||cnt<0)break;
	        		}
	        		res[cnt] = arr[i];
	        	}

	        }
	       for(char a : res) {
	    	   System.out.print(a);
	     }
	}
}
