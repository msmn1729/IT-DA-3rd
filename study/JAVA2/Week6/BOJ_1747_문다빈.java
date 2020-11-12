import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//1의자리도 팰린드롬이 되는구나...ㅎ
		//팰린드롬을 우선 찾은 후에 소수를 찾아주는 방식으로 문제를 풀었습니다.
		String N;
		boolean pri;
		StringBuilder sb;
		int lim;
		int n;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = br.readLine();
		
		if(Integer.parseInt(N) <= 2)
			System.out.println(2);
		else if(Integer.parseInt(N) <= 3)
			System.out.println(3);
		else if(Integer.parseInt(N) <= 5)
			System.out.println(5);
		else if(Integer.parseInt(N) <= 7)
			System.out.println(7);
		else if(Integer.parseInt(N) <= 11)
			System.out.println(11);
		else {
			if(N.length() == 2) {
				System.out.println(101);
			}
			else {
				if(Integer.parseInt(N) % 2 == 0)
					N = Integer.toString((Integer.parseInt(N) + 1));
				while(true) {
					sb = new StringBuilder(N.substring(N.length() - N.length() / 2, N.length()));
					sb.reverse();
					if(N.substring(0, N.length() / 2).equals(sb.toString())) {
						n = Integer.parseInt(N);
						lim = (int) Math.floor(Math.sqrt(n));
						pri = true;
						if(n % lim == 0) {
							N = Integer.toString(n + 2);
							continue;
						}
						for(int j = 2; j < lim; j++) {
							if(n % j == 0) {
								pri = false;
								break;
							}
						}
						if(pri == true) {//지금 검사하는 n은 소수라는 의미
							System.out.println(n);
							break;
						}
					}
					N = Integer.toString(Integer.parseInt(N) + 2);//어차피 짝수들은 검사할 필요도 없으니 홀수에 2를 계속 더해서 검사~ 시간초과 줄임
				}
			}
		}
	}
}

