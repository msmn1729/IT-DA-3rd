import java.util.Scanner;

public class Pill {

	public static long map[][];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true)
		{
			int n = s.nextInt();
			if(n == 0) return;
			map = new long[2*n+1][2*n+1];
			int w = n-1;
			int h = 1;
			System.out.println(dp(w,h));
		}
		
	}
	
	public static long dp(int w, int h)
	{
		if(w == 0) // 남은 완전체가 없는 경우
		{
			map[w][h] = 1;
			return map[w][h];
		}
		
		if(map[w][h] != 0)
			return map[w][h];
		
		long sum = 0;
		if( h >= 1)
			sum = dp(w-1,h+1) + dp(w, h-1);
		else
			sum = dp(w-1,h+1);
		
		map[w][h] = sum;
		return map[w][h];
		
	}

}
