import java.util.Scanner;

public class Q2023 {
	/*
	 * 문제 수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다.요즘 수빈이가 가장 관심있어 하는 소수는
	 * 7331이다.
	 * 
	 * 7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다.
	 * 
	 * 7331 733 73 7
	 * 
	 * 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
	 * 
	 * 수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두
	 * 찾아보자.
	 * 
	 * 입력 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
	 * 
	 * 출력 N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
	 * 
	 * [접근] 
	 * DFS로 숫자 만든 후 
	 * (중복 허용) 
	 * 근데 만든는 법을 모르겠음 
	 * 
	 * 소수판별 --> 제곱근으로 나누기 
	 * 1) 4자리수 
	 * 2) 앞에서부터 3자리 
	 * 3) 앞에서부터 2자리 
	 * 4) 앞에서부터 1자리
	 * 
	 * 첫째자리는 소수로 시작
	 * 
	 * 4*9^8
	 * 
	 * [고민]
	 * 숫자를 다 만들지 말고 
	 * 숫자를 만들면서 소수검사를 해야함
	 * 
	 * 
	 * --> 블로그 참고 
	 * 
	 */
	static int n;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Dfs("",0);
	}

	private static void Dfs(String num, int length) {
		//n의자리수 일대 
		if (length == n) {
			System.out.println(num);
		}
		else {
			for(int i=1;i<=9;i++) {
				
				if(isPrime(Integer.parseInt(num+i))) {
					Dfs(num+i,length+1);
				}
			}
		}
	}

	private static boolean isPrime(int num) {
		//소수가 아닐 때 
		if(num==1) {
			return false;
		}
		
		int sqrt = (int) Math.sqrt(num);
		for(int i=2;i<=sqrt;i++) {
			if(num % i ==0) {
				return false;
			}
		}
		//소수일 때 
		return true;
	}

}
