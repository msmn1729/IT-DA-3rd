import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecialP {
	static ArrayList<Integer> list = new ArrayList<>();
	static int limit;
	static int comp;
	static int N;
	static boolean pri = true;//true면 소수 나타냄

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 모든 자리가 소수(1과 자기자신의 수로만 나눠지는 수)인 수를 찾읍시다.
		// 1 자리 소수 : 2 3 5 7 이걸로 무조건 첫 자리 시작!
		// 2째 자리부터는 짝수는 못옵니다.
		// 소수일 경우 제곱근이 없음. 제곱근 까지만~ 곱해나가는 걸로.. 구해 봅시다.. 시간초과 안나기를..
		// 자리 수에 따라서 찾아올라가는 식으로..? 메모리 공간이 너무작다.. 4MB
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list.add(2);//기본 값 넣기..!
		list.add(3);
		list.add(5);
		list.add(7);
		
		if(N == 1)
			for(int i = 0; i < 4; i++) {
				System.out.println(list.get(i));
			}
	
		else {
			for(int i = 1; i < N; i++) {
				limit = list.size();//list에는 조건을 만족하는 변수들이 들어가있음.
				Prime(i);
			}
		}
		
	}

	static void Prime(int d) {
		int count = 0;
		int lim;//제곱근 저장되는 변수
		while(count < limit) { //while문을 list의 사이즈 만큼만 돌립니다.
			count = count + 1;
			comp = list.get(0) * 10 + 1;
			list.remove(0);
			for(int i = 0; i < 5; i++) {
				lim = (int) Math.floor(Math.sqrt(comp));
				pri = true;
				if(Math.pow(lim, 2) == comp) {
					comp = comp + 2;
					continue;
				}
				for(int j = 2; j <= lim; j++) {
					if(comp % j == 0) {
						pri = false;
						break;
					}
				}
				if(pri == true) {//지금 검사하는 comp는 소수라는 의미
					if(d == N - 1) //마지막 자리수에 왔을 때는 바로 출력해줍시다.
						System.out.println(comp);
					else
						list.add(comp);
				}
				comp = comp + 2;//어차피 짝수들은 검사할 필요도 없으니 홀수에 2를 계속 더해서 검사~ 시간초과 줄임
			}
		}
	}
}
