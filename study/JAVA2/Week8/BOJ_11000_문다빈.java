import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Classroom {
	
	static class Class implements Comparable<Class>{
		int start_t;
		int end_t;
		
		Class(int start, int end){
			start_t = start;
			end_t = end;
		}
		
		@Override
		public int compareTo(Class s) {
			if(start_t > s.start_t)
				return 1;
			else if(start_t == s.start_t) {
				if(end_t > s.end_t)
					return 1;
				else if(end_t == s.end_t)
					return 0;
				else
					return -1;
			}
			else
				return -1;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ��ġ�� �ð� ���� �������� �����ؼ�~(�� Ʋ��) ��� �̾��..?
		// ��ġ�� �ð��� �Ȱ����� �� �ð� �� ���� �ְ� �� �տ� ���Բ�..
		// ������ ȸ�ǽ� ���������� �����մϴ�.
		// ���� �ð� ���� ������������ Ǯ�� �¾���. �ٵ� �� �̷��� �ؾ��ϴ��� �𸣰���..
		int n;
		int finish;
		int count = 1;
		Class c;
		StringTokenizer st;
		PriorityQueue<Class> heap = new PriorityQueue<Class>();//�� �ð� ������ ���������ϴ� priority ť
		PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();//�ּҽð��� ��� priority ť
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			heap.add(new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		min_heap.add(heap.poll().end_t);
		for(int i = 1; i < n; i++) {
			finish = min_heap.poll();
			c = heap.poll();
			if(finish <= c.start_t) {
				finish = c.end_t;
				min_heap.add(finish);
			}
			else {
				min_heap.add(c.end_t);
				min_heap.add(finish);
				++count;
			}
		}
		System.out.println(count);
	}

}
