import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_6236_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int [] K = new int [N];
		
		int left = 0;
		int right = 0;
		for(int i=0; i<N; i++)	{
			K[i] = Integer.parseInt(br.readLine());
			left = Math.max(left, K[i]); //하루에쓰는가장큰값
			right += K[i]; //모든금액의합
		}
		
		int mid=0;
		while (left <= right) {
	        mid = (left + right) / 2; //뽑을금액
	        int count = 1;
	        int money = mid; 
	        for (int i = 0; i < N; i++) {
	            money = money - K[i]; //매일해당하는금액사용
	            if (money < 0) {
	                money = mid - K[i]; //부족하면넣고다시꺼내서사용
	                count++; //출금카운트증가
	            }
	        }
	        if (count > M) left = mid + 1;
	        else right = mid - 1;
	    }
		
		System.out.print(mid);
	}
}
