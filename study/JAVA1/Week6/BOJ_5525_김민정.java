package itda;
import java.util.*;
import java.io.*;
public class BOJ_5525_김민정 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		
		int answer =0;
		int num=0;
		for(int i=0;i<M-2;i++){
	        if(S[i]=='I' && S[i+1]=='O' && S[i+2]=='I'){
	            num++;
	            if(num==N){
	                answer++;
	                num--;
	            }
	            i++;
	        }
	        else num=0;
	    }
		System.out.println(answer);
		
		
	}

}
