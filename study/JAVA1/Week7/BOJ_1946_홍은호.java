import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Employee {
	
	static int T;
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		T = s.nextInt();
		for(int i=0; i<T; i++)
		{
			int N = s.nextInt();
			System.out.println(rank(N));
		}
	}
	
	public static int rank(int N) {
		int[][] score = new int[N][2];
		int count = 1;
		
		
		for(int i=0; i<N; i++)
		{
			score[i][0] = s.nextInt();
			score[i][1] = s.nextInt();
		}
		
		Arrays.sort(score, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		
		for(int i=1; i<N; i++)
		{
			int flag = 0;
			for(int j=0; j <= i-1; j++)
			{
				if(score[i][1] > score[j][1]) //앞 지원자가 더 순위가 높을경우
				{
					flag = 1;
					break;
				}
			}
			//안에 for문을 돌고 flag가 0이라면 통과되므로
			if(flag == 0)
				count++;
		}
		
		
		return count;
		
	}
	
}
