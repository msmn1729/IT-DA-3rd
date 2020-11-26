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
		// 마치는 시간 기준 오름차순 정렬해서~(는 틀림) 길게 이어보자..?
		// 마치는 시간이 똑같으면 앞 시간 더 빠른 애가 더 앞에 오게끔..
		// 백준의 회의실 배정문제와 유사합니다.
		// 시작 시간 기준 오름차순으로 풀면 맞았음. 근데 왜 이렇게 해야하는지 모르겠음..
		int n;
		int finish;
		int count = 1;
		Class c;
		StringTokenizer st;
		PriorityQueue<Class> heap = new PriorityQueue<Class>();//앞 시간 빠른애 기준으로하는 priority 큐
		PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();//최소시간을 담는 priority 큐
		
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
