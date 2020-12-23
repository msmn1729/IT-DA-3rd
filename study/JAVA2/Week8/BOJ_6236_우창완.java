import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6236_��â�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String []temp= br.readLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		int m=Integer.parseInt(temp[1]);
		int arr[]=new int[n];
		int max_num=0;
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			max_num=Math.max(max_num, arr[i]);
		}
		int answer=1000000000;
		int start=1;
		int end=1000000000;
		while(start<=end) {
			int mid=(start+end)/2;
			int money=mid;
			int cnt=1;
			//���� mid���� arr[i]���� ������ mid���� �缳�����ش�.
			if(mid<max_num) {
				start=mid+1;
				continue;
			}
			for(int i=0; i<n; i++) {
				if(money>=arr[i])	money=money-arr[i];
				else {
					money=mid-arr[i];
					cnt++;
				}
			}
			if(cnt>m)	start=mid+1;
			else 	{
				answer=mid;
				end=mid-1;
			}
		}
		System.out.println(answer);
	}

}
