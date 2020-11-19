package itda1119;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15810_김민정 {

	   public static void main(String[] args) throws IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        
	        long l =1, r = 100000000000l;
	        
	        int[] a = new int[1000000];
	        
	        for (int i = 0; i < N ; i++) {
	        	a[i] =Integer.parseInt(st.nextToken());
	        }
	        while (l + 1 < r)
	        {
	            long mid = (l + r) / 2;
	            long cnt = 0;
	            for (int i = 0; i < N; i++)
	                cnt += mid / a[i];
	            if (cnt >= M) r = mid;
	            else          l = mid;
	        }
	        System.out.println(r);
	}

}
