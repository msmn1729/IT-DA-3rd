import java.util.Scanner;

public class Baekjoon14675 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int G[] = new int[N];
		
		for(int i=0; i<N-1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			G[a-1]++; G[b-1]++;
		}
		
		int Q = s.nextInt();
		for(int i=Q; i>0; i--) {
			int c = s.nextInt();
			int d = s.nextInt();
			if(c==1 && G[d-1]<=1) {
				System.out.println("no");
			}
			else
				System.out.println("yes");
		}
	}

}
