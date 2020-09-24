package itda;
import java.io.*;

public class BOJ_5557_김민정 {


    public static void main(String[] args) throws IOException{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    
        long[] num = null;
        for(int i=0; i<n-2; i++) {
            if(i==0) {
                num = new long[21];
                num[arr[0]] = 1;
            }
            num = calSum(arr, num, i+1);
        }
        
        System.out.println(num[arr[n-1]]);
    }
 
    private static long[] calSum(int[] arr, long[] tmp, int x) {
        
        long[] num  = new long[21];
        for(int i=0; i<21; i++) {
            if(tmp[i] == 0) continue;
            else {
                if(i-arr[x] >= 0 && i-arr[x] <= 20) {
                    num[i-arr[x]] += tmp[i];
                }
                if(i+arr[x] >= 0 && i+arr[x] <= 20) {
                    num[i+arr[x]] += tmp[i];
                }
            }
        }
        return num;
        
    }

}
