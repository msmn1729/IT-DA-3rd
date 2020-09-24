import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Capsule {
	static BigInteger check[][];//1번쨰 인덱스 : 여태 사용한 W의 개수, 2번째 인덱스 : 연산 시행횟수 
	//현재 H의 개수 - > 여태 사용한 W의개수 - (연산 시행 횟수 - 여태 사용한 W의 개수)
	static ArrayList<Integer> w_list = new ArrayList<>();//이번 시행에서 실행되게 될 w의 개수들..

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1학년과 유사문제
		// 시간초과를 방지하기위해 이번에도 중복되는 경우는 다 제외해주는 식으로 나갑시다..
		// W개수(온전한 알약)와 글자 길이에 따라 구분~ 이차원 배열로~
		// 이것도 개수가 엄청 많이 나오니 biginteger로 접근해야합니다.
		// 바텀업으로 풀었어음..
		// 이 코드에서 중복을 더 뺄 수 있을 것 같습니다.(W 30개를 다 쓴 경우는 중복계산 안하는 식으로~)
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		while(n != 0) {
			w_list.clear();
			check = new BigInteger[n+1][(n * 2) + 1];
			
			for(int i = 1; i < n+1; i++) {
				Arrays.fill(check[i], new BigInteger("0"));
			}
			
			Cap(n, (n * 2) + 1);
			System.out.println(check[n][n*2]);
			
			n = Integer.parseInt(br.readLine());
		}
	}
	
	static void Cap(int n, int s) {
		int count = 1;//시행 횟수
		int limit;//w_list의 길이가 저장될 변수
		int temp;
		w_list.add(1);
		check[1][1] = new BigInteger("1");
		while(count < s - 1) {
			limit = w_list.size();
			for(int i = 0; i < limit; i++) {
				temp = w_list.get(0);
				if(temp < n) {
					if(check[temp + 1][count + 1].equals(BigInteger.ZERO)) {
						check[temp + 1][count + 1] = check[temp][count];
						w_list.add(temp + 1);
					}
					else {
						check[temp + 1][count+1] = check[temp + 1][count + 1].add(check[temp][count]);
					}
				}
				if(temp - (count - temp) > 0) {//H개수 0개보다 클 떄만 실행
					if(check[temp][count + 1].equals(BigInteger.ZERO)) {
						check[temp][count + 1] = check[temp][count];
						w_list.add(temp);
					}
					else {
						check[temp][count+1] = check[temp][count + 1].add(check[temp][count]);
					}
				}
				w_list.remove(0);
			}
			count = count + 1;
		}
	}

}
