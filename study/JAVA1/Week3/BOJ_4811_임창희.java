package q4811;

import java.util.Scanner;

public class Q4811 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=-1;
		int t =0;
//		t는 최대 1000개의 테스트 케이스로 이루워져서 while 조건문을 t<1000로 했다.
		while(t<1000) {
			N=sc.nextInt();
			if(N==0) break;		//	N값에 0이 들어오면 입력을 중지한다.
			
			long[][] map = new long[2*N][2*N+1];
			System.out.println(split(N,0,map));
			t++;
		}
		
	}
//	full은 알약 한개 half는 알약 반개이다.
	static long split(int full, int half,long[][] map) {
//		경우의 수가 1개가 되는 조건은 full이 한개일 때 half가 0이거나 full이 0일때 이다.
		if(half == 0 && full==1 || full==0) {
			map[full][half]=1;
			return 1;
		}else if(half<0) {
			return 0;
		}
		if(map[full][half]==0) {
			map[full][half] = split(full-1,half+1,map)+split(full,half-1,map);
		}
		return map[full][half];
	}
}
