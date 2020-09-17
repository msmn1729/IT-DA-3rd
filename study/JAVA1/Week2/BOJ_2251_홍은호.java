import java.util.Scanner;

public class WaterBottle {

	static boolean visited[][] = new boolean[201][201];
	static boolean cnt[] = new boolean[201];
	static int maxA, maxB, maxC;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		maxA = s.nextInt();
		maxB = s.nextInt();
		maxC = s.nextInt();
		
		DFS(0,0,maxC);
		
		for(int i=0; i<201; i++)
		{
			if(cnt[i])
				System.out.print(i+ " ");
		}
		
	}
	
	public static void DFS(int ca, int cb, int cc) {
		if(visited[ca][cb])
			return;
		
		if(ca == 0)
			cnt[cc] = true;
		
		visited[ca][cb] = true;
		
		// 1. A -> B
		if(ca+cb > maxB) //B에 전부 붓고 A가 남는 경우
			DFS((ca+cb)-maxB, maxB, cc);
		else //B에 전부 붓고 A가 빈 경우
			DFS(0, ca+cb, cc);
		
		// 2. B -> A
		if(cb+ca > maxA) //A에 전부 붓고 B가 남는 경우
			DFS(maxA, (cb+ca)-maxA, cc);
		else //A에 전부 붓고 B가 빈 경우
			DFS(cb+ca, 0, cc);
		
		// 3. A -> C (C로 붓는 경우는 넘칠 가능성이 없음)
		DFS(0, cb, ca+cc);
		
		// 4. C -> A
		if(cc+ca > maxA) //A에 전부 붓고 C가 남는 경우
			DFS(maxA, cb, (cc+ca)-maxA);
		else //A에 전부 붓고 C가 빈 경우
			DFS(cc+ca, cb, 0);
		
		// 5. B -> C (C로 붓는 경우는 넘칠 가능성이 없음)
		DFS(ca, 0, cb+cc);
		
		// 6. C -> B
		if(cc + cb > maxB) //B에 전부 붓고 C가 남는 경우
			DFS(ca, maxB, (cc+cb)-maxB);
		else //B에 전부 붓고 C가 빈 경우
			DFS(ca, cc+cb, 0);
	}

}
