package itda;
import java.util.*;
import java.io.*;
public class BOJ_1747_김민정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        while(true) {
            if(isPrimeNumber(N) && isPalindrome(N)) {
                System.out.println(N);
                return;
            }
            N++;
        }
    }
 
    private static boolean isPrimeNumber(int x) {
        if (x == 1) return false;
        
        for(int i=2; i*i<=x; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }
     
    private static boolean isPalindrome(int x) {
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
