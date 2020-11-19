package itda1119;
import java.io.*;
import java.util.*;
public class BOJ_1756_김민정 {
	   public static void main(String[] args) throws IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int D = Integer.parseInt(st.nextToken());
	        int N = Integer.parseInt(st.nextToken());

	        int[] oven = new int[D];

	        st = new StringTokenizer(br.readLine());

	        oven[0] = Integer.parseInt(st.nextToken());

	        //오븐의 지름이 밑에 길어도 피자 반죽 못들어간다.
	        for (int i = 1; i < D; i++) {
	            oven[i] = Math.min(oven[i-1], Integer.parseInt(st.nextToken()));
	        }

	        int[] pizza = new int[N];

	        st = new StringTokenizer(br.readLine());

	        for (int i = 0; i < N; i++) {
	            pizza[i] = Integer.parseInt(st.nextToken());
	        }

	        
	        int count = 0;
	        int result = 0;
	        for (int i = D-1; i >= 0 ; i--) {
	            //피자 들어갈수있다.
	            if( oven[i] >= pizza[count] ) {
	                count++;
	            }

	            //finish
	            if(count == N) {
	                result = i+1;
	                break;
	            }

	        }
	        System.out.println(result);
	    }

}
