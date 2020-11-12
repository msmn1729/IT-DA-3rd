package q5525;

import java.util.Scanner;

public class IOIOI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int M = sc. nextInt();
		String S = sc.next();
		int result = 0;
		int cnt = 0;
		char[] arr = S.toCharArray();
		for(int i=1;i<arr.length-1;i++) {
			if(arr[i-1]=='I' && arr[i] =='O' && arr[i+1]=='I') {
				cnt++;
				if(cnt ==N) {
					cnt--;
					result++;
				}
				i++;
			}else	cnt=0;
		}
		System.out.println(result);
	}
}
