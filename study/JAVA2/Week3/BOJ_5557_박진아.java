package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5557 {
/*
 * 예를 들어, "8 3 2 4 8 7 2 4 0 8 8"에서 
 * 등식 "8+3-2-4+8-7-2-4-0+8=8"을 만들 수 있다.
 * 
 * 음수를 배우지 않았고, 
 * 20을 넘는 수는 모른다. 
 * 중간에 나오는 수가 모두 0 이상 20 이하이어야 한다. 
 * 예를 들어, "8+3+2-4-8-7+2+4+0+8=8"은 올바른 등식이지만, 
 * 8+3+2-4-8-7이 음수이기 때문에, 상근이가 만들 수 없는 등식이다.
 * 
 * 계산 과정 중에 20이하로 나와야함 
 * 마지막 두 수 사이에 = 
 * +,-
 * 만들 수 있는 올바른 등식의 수를 구하는 프로그램을 작성하시오.
 * 
 *  숫자의 개수 N이 주어진다. (3 ≤ N ≤ 100) 
11
8 3 2 4 8 7 2 4 0 8 8

 * [접근]
 * N-2의 숫자들이 0이면 됨
 * 
 *  2차원 배열에 각 계산의 값을 
 *  유효한지 검사 후 
 *  저장하면 될 거같은데
 * 
 * if(cur+arr[i]<0) return;
 * if(cur+arr[i]>20) return;
 * 
 * calculate(cur+arr[i],)
 * 
 * https://hyunah030.tistory.com/5 
 * 
 * 
 * 첫번째 연산 결과 -> map[1][21]에 저장
 * 
 * var1+var2 = map[2][var1+Var2]
 * 두번째 연산 결과 -> map[2][21]에 저장
 *  
 * 
 * 
 */
	
	
	static int[][] map = new int[101][21];
	static int[] input = new int[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String tmp[] = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			input[i+1]=Integer.parseInt(tmp[i]);
		}
		
		map[1][input[1]]=input[1];
		int var1=0, var2=0;
		//cnt = 연산의 횟수 
		for(int cnt=2;cnt<=n;cnt++) {
			for(int i=1;i<=20;i++) {
				if(map[cnt-1][i]!=0) {
					var1=map[cnt-1][i];
					var2=input[cnt];
					System.out.println(var1+" "+var2);
					
					if(0<=(var1+var2)&&(var1+var2)<=20) {
						map[cnt][var1+var2]=var1+var2;
					}
					if(0<=(var1-var2)&&(var1-var2)<=20) {
						map[cnt][var1-var2]=var1-var2;
					}
					
				}
			}
		}
		
		int rs=0;
		for(int j=0;j<=n;j++) {
			for(int i=1;i<=20;i++) {
				System.out.print(map[j][i]+" ");
			}
			System.out.println();
		}
		
		System.out.println(rs);
	}
	

}
