package q5557;

import java.util.Scanner;

public class Q5557 {
	static int N;
	static int[] arr;
	static long[][] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]= sc.nextInt();
		}
//		result의 첫번째 인덱스는 배열의 몇번째 요소까지 계산했는지를 나타낸다.
//		두번째 인덱스는 첫번째 인덱스까지 계산했을 때 계산한 값을 나타낸다.
//		왼쪽부터 계산할 때 중간에 나오는 수가 0부터 20까지이므로 21로 했다.
		result = new long[N-1][21];
		result[0][arr[0]]=1;
		
//		
		for(int i=1;i<N-1;i++) {
			for(int j=0;j<21;j++) {
//				plus는 전번째 시행까지 나올 수 있는 값에서 arr[]의 다음 요소를 더한 값이다.
//				minus는 같은 방법으로 뺀 값이다.
//				result는 각각의 시행에서 나올 수 있는 j의 값의 횟수이다.
				if(result[i-1][j] !=0) {
					int plus = j+arr[i];
					int minus = j-arr[i];					
					if(plus<=20) {
						result[i][plus] += result[i-1][j];							
					}
					if(minus >=0) {
						result[i][minus] +=result[i-1][j];							
					}
				}
				
			}
		}
		
		System.out.println(result[N-2][arr[N-1]]);
	}
	
}
