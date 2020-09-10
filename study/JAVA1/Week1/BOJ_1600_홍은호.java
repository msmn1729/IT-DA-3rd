import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Monkey{
	int x, y, cnt, horse;
	Monkey(int x, int y, int cnt, int horse)
	{
		this.x=x;
		this.y=y;
		this.cnt=cnt;
		this.horse=horse;
	}
}

public class HorseMonkey {
	static int [][] mat;
	static boolean [][][] visited;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		int W = s.nextInt();
		int H = s.nextInt();
		
		mat = new int[W][H];
		visited = new boolean[W][H][K+1];
		
		for(int i=0; i<W; i++)
			for(int j=0; j<H; j++)
			{
				mat[i][j] = s.nextInt();
			}
		
		visited[0][0][0] = true;
		BFS();
	}

	public static void BFS()
	{
		Queue<Monkey> queue = new LinkedList<>();
		Monkey mon = new Monkey(0,0,0,0);
	}
}
