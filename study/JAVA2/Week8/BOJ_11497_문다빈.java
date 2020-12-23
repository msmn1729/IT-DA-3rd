import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class TongWood {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 우선 순위 큐로 받아와서 하나하나 비교?
		int T;
		int N;
		int mid, left, right;
		int temp;
		int max;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		//숫차 내림차순으로 정렬
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				heap.add(Integer.parseInt(st.nextToken()));
			}
			mid = heap.poll();
			left = heap.poll();
			right = heap.poll();
			max = Math.max(mid - left, mid - right);
			for(int j = 0; j < N-3; j++) {
				if(j % 2 == 0) {
					temp = heap.poll();
					max = Math.max(max, left - temp);
					left = temp;
				}
				else {
					temp = heap.poll();
					max = Math.max(max, right - temp);
					right = temp;
				}
			}
			max = Math.max(max, left - right);
			System.out.println(max);
			heap.clear();
		}
		
	}

}
