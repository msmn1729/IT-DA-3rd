import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2023_김영민 {

	static int N;
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N==1) System.out.print(2+"\n"+3+"\n"+5+"\n"+7); //1자리 숫자일 경우, 2, 3, 5, 7 출력
		else { 
			//그렇지 않을 경우, dfs호출
			//1자리 숫자가 소수(2,3,5,7)
			dfs(2, 2);
			dfs(3, 2);
			dfs(5, 2);
			dfs(7, 2);
		}
	}
	
	public static void dfs(int num, int n) {
		for(int i=1; i<=9; i++) {
			int temp = num*10+i; //10을 곱한 뒤에 i를 더해서 소수 판별(20,30,50,70...)
			if(isPrime(temp)) {
				if(n==N) System.out.println(temp); //입력받은 자릿수와 같으면 출력
				else dfs(temp, n+1); //다르면 자릿수를 올려서 dfs호출
			}
		}
	}
	
	public static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++)
			if(num%i==0) return false;
		return true;
	}
}
