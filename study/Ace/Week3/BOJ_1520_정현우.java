package backjoon.study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 내리막길 https://www.acmicpc.net/problem/1520 
/* 프로그래머스에서 '등굣길(https://programmers.co.kr/learn/courses/30/lessons/42898)' 이라는 문제랑 굉장히 비슷한 느낌을 받았다.
 
 여행을 떠난 세준이는 지도를 하나 구하였다. 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
 한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능
 현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다. 
 그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다
 지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수
 첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다. 
 이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다. 
 M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수
 첫째 줄에 이동 가능한 경로의 수 H를 출력한다. 모든 입력에 대하여 H는 10억 이하의 음이 아닌 정수
 
 등굣길에서 웅덩이의 조건이 '낮은 지점'이라는 조건으로 바뀐 것 뿐인 것 같다. 
 dp 3차원 배열로, 좌표 + 상하좌우 ? 불가능하면 -1로 바꾸고? / 쓸모없는 메모리 낭비 같다 
 등굣길 문제는 only dp 점화식 연산으로만 가능한데 얘는 모든 경로의 수를 찾아야한다. 그래프 탐색으로 먼저 접근 ㄱㄱ
 상하좌우를 탐색할꺼다. 값이 작을때만 재귀호출을 한다. int로 하는게 좋을까? static 변수 ++도 나쁘지 않다.
 그럼 어떻게 메모리를 사용할까? 시간을 줄이는 방향으로 써야한다. 
 1) 내려가는 방향이 정해져 있다
 2) 한 번 간 곳을 되돌아 갈 필요가 없게 만들어야 한다  
 3) 누적 합을 이용해야 한다 / 어떻게 누적합을 이용하지? 
 */
public class DownhillRoad {
	static int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] dp, map;
	
	public static int dfs(int nowY, int nowX, int M, int N) {
	    if(nowY == M - 1 && nowX == N - 1) return 1; // 도착, 기저 case
	    if(dp[nowY][nowX] == -1) { // 방문한 적 없는 좌표 dp값
	        dp[nowY][nowX] = 0;
	        for (int i = 0; i < 4; i++) {
	            int nextX = direction[i][1] + nowX;
	            int nextY = direction[i][0] + nowY;
	 
	            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) { // out of bound check
	                if(map[nowY][nowX] > map[nextY][nextX]) { // 내리막길 check
	                	// System.out.println("nowY: " + nowY + ", nowX: " + nowX + ", nextY: " + nextY + ", nextX: " + nextX);
	                    dp[nowY][nowX] += dfs(nextY, nextX, M, N);
	                }
	            }
	        } // for 
	    } // if 
	    // System.out.println("nowY: " + nowY + ", nowX: " + nowX + ", return: " + dp[nowY][nowX]);
	    return dp[nowY][nowX];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = BR.readLine().split(" ");
		
		int M = Integer.parseInt(temp[0]); 
		int N = Integer.parseInt(temp[1]);
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			temp = BR.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1; // init
				map[i][j] = Integer.parseInt(temp[j]);
			}
		} // for
		
		//////////////////////////////////////////////////////////////////////////
	    
		System.out.println(dfs(0, 0, M, N));
	}
}
