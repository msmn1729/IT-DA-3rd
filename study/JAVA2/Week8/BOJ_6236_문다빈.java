import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Budget {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 이진탐색 문제
		// left는 이용할 금액 중 최대 값
		// right는 금액들의 전체 합
		// M보다 같거나 작기만하면 됌 찾는 값이 쪼갤 수 있는 값이
		ArrayList<Integer> list = new ArrayList<>();
		int N, M;
		int cost;
		int left, right;
		int mid;
		int max = 0;
		int sum = 0;
		int temp;
		int count;
		int ans = 0;
		StringTokenizer st;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			cost = Integer.parseInt(br.readLine());
			list.add(cost);
			max = Math.max(cost, max);
			sum = sum + cost;
		}
		
		left = max;
		right = sum;
		
		while(left <= right) {
			mid = (left + right) / 2;
			count = 1;
			temp = mid;
			for(int i = 0; i < list.size(); i++) {
				if(temp - list.get(i) < 0) {
					temp = mid - list.get(i);
					++count;
				}
				else {
					temp = temp - list.get(i);
				}
				if(count > M)
					break;
			}
			if(count == M) {
				ans = mid;
				right = mid - 1;
			}
			else if(count > M) {
				left = mid + 1;
			}
			else if(count < M) {
				ans = mid;
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
