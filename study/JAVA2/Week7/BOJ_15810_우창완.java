import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15810_우창완 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int []time=new int[n];
		for(int i=0; i<n; i++) {
			time[i]=sc.nextInt();
		}
		Arrays.sort(time);
		//? 웨 max_time=time[n-1]*m하면 안뒈????????????????!
		long max_time = 500000000000l;
		long min_time=1;
		long ans=1;
		while(min_time<=max_time) {
			long sum=0;
			long mid=(min_time+max_time)/2;
			for(Integer i :time) sum+=mid/i;
			//최솟값을 찾아야하므로 sum==m일 때보다 더 작은 시간이 있을 수 있다 
			if(sum>=m) {
				ans=mid;
				max_time=mid-1;
			}
			else  min_time=mid+1;
		}
		System.out.println(ans);
	}
}
