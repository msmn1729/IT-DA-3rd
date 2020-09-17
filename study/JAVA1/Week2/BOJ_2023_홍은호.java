import java.util.Scanner;

public class PrimeNumber {

	public static int N;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		
		for(int i=1; i<=9; i++)
		{
			if(isPrime(i))
				DFS(i, 1);
		}
	}
		
	public static void DFS(int num, int count)
	{
		if(count == N)
		{
			System.out.println(num);
			return;
		}
		
		int checkNum;
		for(int i=0; i<=9; i++)
		{
			checkNum = num * 10 + i;
			if(isPrime(checkNum))
				DFS(checkNum, count+1);
		}
	}
	
	//소수이면 false, 소수가 아니면 true를 리턴
		public static boolean isPrime(int num)
		{
			if(num==1) return false;
			
			int sqrt = (int)Math.sqrt(num);
			for(int i=2; i<= sqrt; i++)
			{
				if(num % i == 0)
				{
					return false;
				}
			}
			
			return true;
		}
}
