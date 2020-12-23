import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15810_��â�� {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int []time=new int[n];
		for(int i=0; i<n; i++) {
			time[i]=sc.nextInt();
		}
		Arrays.sort(time);
		//? �� max_time=time[n-1]*m�ϸ� �ȵ�????????????????!
		long max_time = 500000000000l;
		long min_time=1;
		long ans=1;
		while(min_time<=max_time) {
			long sum=0;
			long mid=(min_time+max_time)/2;
			for(Integer i :time) sum+=mid/i;
			//�ּڰ��� ã�ƾ��ϹǷ� sum==m�� ������ �� ���� �ð��� ���� �� �ִ� 
			if(sum>=m) {
				ans=mid;
				max_time=mid-1;
			}
			else  min_time=mid+1;
		}
		System.out.println(ans);
	}
}
