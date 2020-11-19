import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BallonFactory {
	static class Ballon implements Comparable<Ballon> {
		long now;
		int num;
		
		public Ballon(long a, int b) {
			this.now = a;
			this.num = b;
		}
		
		@Override
		public int compareTo(Ballon target) {
	        return this.now > target.now ? 1 : -1;
	    }
		
	}

	public static void main(String[] args) throws IOException {
		//priority queue »ç¿ë
		int n;
		long m;
		int a;
		long next;
		long b_num = 0;
		Ballon ba;
		PriorityQueue<Ballon> heap = new PriorityQueue<Ballon>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			a = Integer.parseInt(st.nextToken());
			heap.add(new Ballon(a, a));
		}
		while(!heap.isEmpty()) {
			++b_num;
			ba = heap.poll();
			next = ba.now + ba.num;
			if(b_num == m) {
				System.out.println(ba.now);
				break;
			}
			heap.add(new Ballon(next, ba.num));
		}
	}
}
