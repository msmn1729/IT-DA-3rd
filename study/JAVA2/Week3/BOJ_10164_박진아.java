package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q10164 {
	/*
	 * 
	 * 행의 수가 N이고 열의 수가 M인 격자의 각 칸에 
	 * 1부터 N×M까지의 번호가 
	 * 첫 행부터 시작하여 차례로 부여되어 있다. 
	 * 격자의 어떤 칸은 ○ 표시가 되어 있다. 
	 * 
	 * (단, 1번 칸과 N × M번 칸은 ○ 표시가 되어 있지 않다. 또한, ○ 표시가 되어 있는 칸은 최대 한 개이다. 즉, ○ 표시가 된 칸이 없을 수도 있다.) 
	 * 
	 * 행의 수가 3이고 열의 수가 5인 격자에서 각 칸에 번호가 1부터 차례대로 부여된 예가 아래에 있다. 이 격자에서는 8번 칸에 ○ 표시가 되어 있다.
	 * 
	 * 
	 * 격자의 1번 칸에서 출발한 어떤 로봇이 아래의 두 조건을 만족하면서 N×M번 칸으로 가고자 한다.
	 * 
	 * 
	 * 조건 1: 로봇은 한 번에 오른쪽에 인접한 칸 또는 아래에 인접한 칸으로만 이동할 수 있다. (즉, 대각선 방향으로는 이동할 수 없다.)
	 * 
	 * 조건 2: 격자에 ○로 표시된 칸이 있는 경우엔 로봇은 그 칸을 반드시 지나가야 한다. 
	 * 
	 * 위에서 보인 것과 같은 격자가 주어질 때, 로봇이 이동할 수 있는 서로 다른 경로의 두 가지 예가 아래에 있다.
	 * 
	 * 1 → 2 → 3 → 8 → 9 → 10 → 15
	 * 1 → 2 → 3 → 8 → 13 → 14 → 15
	 * 격자에 관한 정보가 주어질 때 로봇이 앞에서 설명한 두 조건을 만족하면서 
	 * 이동할 수 있는 서로 다른 경로가 총 몇 개나 되는지 찾는 프로그램을 작성하라.
	 *  
	 *  
	 *  
	 *  
	 * 조건 1: 로봇은 한 번에 오른쪽에 인접한 칸 또는 아래에 인접한 칸으로만 이동할 수 있다. (즉, 대각선 방향으로는 이동할 수 없다.)
	 * 조건 2: 격자에 ○로 표시된 칸이 있는 경우엔 로봇은 그 칸을 반드시 지나가야 한다. 
	 * 
	 *
	 *  입력의 첫째 줄에는 격자의 행의 수와 열의 수를 나타내는 두 정수 N과 M(1 ≤ N, M ≤ 15), 
	 *  그리고 ○로 표시된 칸의 번호를 나타내는 정수 K(K=0 또는 1 < K < N×M)가 차례로 주어지며, 
	 *  각 값은 공백으로 구분된다. K의 값이 0인 경우도 있는데, 
	 *  이는 ○로 표시된 칸이 없음을 의미한다. N과 M이 동시에 1인 경우는 없다.
	 *  
	 *[접근]
	 *O 표시까지 갈 수 있는 방법 
	 *O 표시에서 도착까지 갈 수 있는 방법 
	 *
	 *  1 1 1 1 1
		1 2 3 3 3
		1 3 3 6 9
		
		
		0 1 2 3 4  : m
	   0
	   1
	   2
	   
	   :
	   n
	   
	   
	 *
	 */

	static int map[][]= new int [16][16];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);//3
		int m = Integer.parseInt(input[1]);//가로 줄 
		int k = Integer.parseInt(input[2]);
		
		int kn = (int)k/m; int km = (int)k%m;
		//k= 8 일때  n=5, k좌표 : (1,3)
		
		//map[n][m];
		//외곽
		for(int i=0;i<m;i++) {
			map[0][i]=1;
		}
		for(int i=0;i<n;i++) {
			map[i][0]=1;
		}
		
		System.out.println(kn+" "+km);
		
		for(int i=1;i<=kn;i++) {
			for(int j=1;j<km;j++) {
				System.out.println(i+ " "+j);
				map[i][j]=map[i][j-1]+map[i-1][j];
			}
		}
		
		for(int i=kn;i<n;i++) {
			for(int j=km;j<m;j++) {
				map[i][j]=map[i][j-1]+map[i-1][j];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(map[n-1][m-1]);
	}

}
