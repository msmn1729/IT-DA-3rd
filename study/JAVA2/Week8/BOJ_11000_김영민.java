import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int [][] classRoom = new int [N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			classRoom[i][0] = Integer.parseInt(st.nextToken());
			classRoom[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(classRoom, new Comparator<int[]>() {
			public int compare(int [] o1, int [] o2) {
				if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]); //시작시간이같다면끝시간비교정렬
				else return Integer.compare(o1[0], o2[0]); //시작시간비교정렬
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
	    pq.offer(classRoom[0][1]); //첫수업끝나는시간큐에넣기

	    for (int i = 1; i < N; i++) {
	   	 	if (pq.peek() <= classRoom[i][0]) pq.poll(); //비교해서끝나는시간이작다면강의실추가이용
	   	 		pq.offer(classRoom[i][1]);
	    }	        
	
	    System.out.print(pq.size()); //남아있는사이즈출력
	}
}
