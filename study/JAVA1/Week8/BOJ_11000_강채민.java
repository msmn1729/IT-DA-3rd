import java.util.*;

public class 11000_ㅊㅁ {

	public static void main(String[] args) {
		
		/**
		 * 2기때 풀었던 1931번 회의실 배정이랑 문제가 비슷한것 같다.
		 */
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int classRoom [][] = new int [N][2];
		
		for(int n = 0; n < N; n++) {
			classRoom[n][0] = input.nextInt();
			classRoom[n][1] = input.nextInt();
		}
		
		Arrays.sort(classRoom, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[1] == arg1[1]) {
                    return arg0[0] - arg1[0];
                } else {
                    return arg0[1] - arg1[1];
                }
            }
        });
		
		//ArrayList<Integer> Answer = new ArrayList<>();
		//Queue<Integer>Answer = new LinkedList<>();
		PriorityQueue<Integer>Answer = new PriorityQueue<>();
		
		//int end = classRoom[0][1]; // 초기 끝나는 시간.
		//Answer.add(classRoom[0][1]);
		Answer.add(classRoom[0][1]);
		int count = 1;
		
		
		for(int i = 1; i < N; i++) {
			
			/*
			if(classRoom[i][0] < Answer.peek()) {
				Answer.add(classRoom[i][1]);
				count++;
			}
			
			else {
				Answer.poll();
				Answer.add(classRoom[i][1]);
			}
			*/
			
			if(!Answer.isEmpty() && classRoom[i][0] >= Answer.peek())
				Answer.poll();
			
			Answer.add(classRoom[i][1]);
		}
		
		//System.out.println(count);
		
		System.out.println(Answer.size());
	}

}
