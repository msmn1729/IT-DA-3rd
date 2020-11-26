import java.util.Arrays;
import java.util.Scanner;

public class EatOrDie {

	static Scanner s;
	public static void main(String[] args) {
		int T;
		s = new Scanner(System.in);

		T = s.nextInt();
		
		for(int i=0; i<T; i++)
		{
			System.out.println(Test());
		}
	}
	
	public static int Test() {
		int N, M;
		int count = 0;
		N = s.nextInt();
		M = s.nextInt();
		int[] a = new int[N];
		int[] b = new int[M];
		for(int i=0; i<N; i++)
			a[i] = s.nextInt();
		for(int i=0; i<M; i++)
			b[i] = s.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(a[i] > b[j])
				{
					count++;
				}
				else
					break;
			}
		}
		
		return count;
	}
}
