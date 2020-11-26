import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Eat {

	public static void main(String[] args) throws IOException {
		int T;
		int N, M;
		int comp;
		int num;
		int sum;
		StringTokenizer st;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				heap.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				heap2.add(Integer.parseInt(st. nextToken()));
			}
			comp = heap2.poll();
			num = heap.poll();
			while(true) {
				if(comp < num) {
					sum = sum + 1 + heap.size();
					if(heap2.isEmpty())
						break;
					comp = heap2.poll();
				}
				else {
					if(heap.isEmpty())
						break;
					num = heap.poll();
				}
			}
			System.out.println(sum);
			heap.clear();
			heap2.clear();
		}

	}

}
