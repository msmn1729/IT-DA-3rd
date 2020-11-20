package itda_2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15810_박소현 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        String input = br.readLine();
 
        char[] arr = input.toCharArray();

       int MIN = 1000000, MAX = 0;
       for (int i = 0; i<arr.length;i++) {
    	   if (arr[i] >= MAX) MAX = arr[i];
    	   if (arr[i] <= MIN) MIN = arr[i];
       }
       int A[] = new int[MAX-MIN];
       int j = 0;
       for (int i = MIN; i<=MAX;i++) {
    	   A[j] = i;
    	   j++;
       }
       
       binarySearch(A,n,MIN,MAX);
       
	}
	
    public static int binarySearch(int[] arr, int n, int first, int last) { 
    	int mid = 0;
    	
    	while (first <= last) {
    		mid = (first + last) / 2;
    		
    		if(n==arr[mid]) {
    			return 1;
    		}
    		else {
    			if(n<arr[mid]) 
    				last = mid - 1;
    			else
    				first = mid + 1;
    			
    		}
    	}
    	return 0;
    }
}

// ㅎ ,,
