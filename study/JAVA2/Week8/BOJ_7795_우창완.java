import java.util.Arrays;
import java.util.Scanner;

public class BOJ_7795_¿ìÃ¢¿Ï {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			int []a_arr=new int[n];
			int []b_arr=new int[m];
			for(int j=0; j<n; j++) {
				a_arr[j]=sc.nextInt();
			}
			for(int j=0; j<m; j++) {
				b_arr[j]=sc.nextInt();
			}
			Arrays.sort(a_arr);
			Arrays.sort(b_arr);
			int answer=0;
			int cnt=0;
			int sum=0;
			for(int j=0;j<n; j++) {
				
				answer=0;
				int target=a_arr[j];
				if(target>b_arr[m-1]) {
					sum+=m-1;
					continue;
				}
				if(target<=b_arr[0]) {
					continue;
				}
				int left=0;
				int right=m-1;
				while(left<=right) {
					int mid=(left+right)/2;
					if(target==b_arr[mid]) {
						sum+=mid+1;
						break;
					}else if(target>b_arr[mid]) {
						left=mid+1;
						answer=mid;
					}else {
						right=mid-1;
					}
				}
				sum+=answer+1;
			}
			System.out.println(sum);
		}

	}

}
