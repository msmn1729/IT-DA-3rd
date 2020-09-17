package backjoon.study.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 성곽 https://www.acmicpc.net/problem/2234
/*
 대략 위의 그림과 같이 생긴 성곽이 있다. 굵은 선은 벽을 나타내고, 점선은 벽이 없어서 지나다닐 수 있는 통로를 나타낸다. 
 이러한 형태의 성의 지도를 입력받아서 다음을 계산하는 프로그램을 작성하시오.
 1. 이 성에 있는 방의 개수
 2. 가장 넓은 방의 넓이
 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
 위의 예에서는 방은 5개고, 가장 큰 방은 9개의 칸으로 이루어져 있으며, 위의 그림에서 화살표가 가리키는 벽을 제거하면 16인 크기의 방을 얻을 수 있다.
 성은 m×n(1 ≤ m, n ≤ 50)개의 정사각형 칸으로 이루어진다. 성에는 최소 두 개의 방이 있어서, 항상 하나의 벽을 제거하여 두 방을 합치는 경우가 있다.
 첫째 줄에 두 정수 n, m이 주어진다. 다음 m개의 줄에는 n개의 정수로 벽에 대한 정보가 주어진다. 벽에 대한 정보는 한 정수로 주어지는데, 
 서쪽에 벽이 있을 때는 1을, 북쪽에 벽이 있을 때는 2를, 동쪽에 벽이 있을 때는 4를, 남쪽에 벽이 있을 때는 8을 더한 값이 주어진다. 
 참고로 이진수의 각 비트를 생각하면 쉽다. 따라서 이 값은 0부터 15까지의 범위 안에 있다.
 
 BFS로 접근해야 넓이 구하는게 편할듯 
 1) 0000 bit 형식으로 map의 data가 저장된다. -> 그 값에 따라 상하좌우 탐색 가능이 달라진다 
 2) static 변수로 넓이 구하기 Max로 갱신 + 공간 구하기도 동시에 이뤄져야함 / visited 대신 map 값 자체를 바꾸는게 좋을 듯 
 3) 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기가 문제 / 각 지점에서 4방향 벽을 하나씩 모두 없애봐야하나?
   	=> 50 by 50 이 최대 사이즈, 기본적으로 50 * 50 * 4 가지의 경우의 수에 탐색은 최대 50 * 50 = 25,000,000
   	
 메모리 초과는 좀 애반데,,, 하아 쓰벌 
 */
public class CattleWall {
	// 남 동 북 서 방향으로 
	static int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] map; 
	static class Pair {
		int x, y;
		Pair(int x, int y) { this.x = x; this.y = y; }
	}
	
	public static int bfs(int[][] tempMap, int m, int n, int i, int j) {
		
		Pair start = new Pair(i, j);
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(start); // add start position
		int width = 0; // 지금 도는 방의 넓이 카운팅 
		
		while (!q.isEmpty()) {
			Pair now = q.poll();
			String nowData = String.format("%04d",Integer.parseInt(Integer.toBinaryString(map[now.y][now.x])));
			for (int k = 0; k < 4; k++) { 
				// 0001 서, 0010 북, 0100, 동 1000 남, dircetion은 "남 동 북 서" 으로 맞춤 
				if(nowData.charAt(k) == '0') { // 벽 없을때 진행 
					int nextX = now.x + direction[k][0]; 
		            int nextY = now.y + direction[k][1];
		            
		            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) { // bound check
		            	if(tempMap[nextY][nextX] != -1) {
		            		// System.out.println(nextX + ", " + nextY);
		            		tempMap[nextY][nextX] = -1;
		            		q.offer(new Pair(nextX, nextY));
		            	}	
		            } 
				} // 벽 있나 없나 체크 
	        } // for
			width++; 
		} // while
		
		return width;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = BR.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		map = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			// 0000 벽X, 0001 서, 0010 북, 0100, 동 1000 남,,,, 1111 동서남북
			temp = BR.readLine().split(" ");
			for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(temp[j]);
		} // for 
		
		// temp 2차원 배열 맵 만들기
		int[][] tempMap = new int[m][n];  
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) tempMap[i][j] = map[i][j];
		} // for
		
		// bfs 
		int roomCounter = 0; // 이 성에 있는 방의 개수
		int roomMaxWidth = 0; // 가장 넓은 방의 넓이
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(tempMap[i][j] != -1) {
					tempMap[i][j] = -1;
					roomMaxWidth = Math.max(bfs(tempMap, m, n, j, i), roomMaxWidth); // index 명심! x y 반대로임!! 
					roomCounter++; 
				}
			}
		} // for
		
		StringBuilder tempSB;
		int roomBrokenWidth = 0; // 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int origin = map[i][j]; // map[i][j]의 int 값 저장 
				for (int k = 0; k < 4; k++) {
					tempSB = new StringBuilder(String.format("%04d",Integer.parseInt(Integer.toBinaryString(origin))));
					if(tempSB.charAt(k) == '1') {
						tempSB.setCharAt(k, '0');
						map[i][j] = Integer.parseInt(tempSB.toString(), 2);
						// re-init tempMap
						tempMap = new int[m][n];  
						for (int i2 = 0; i2 < m; i2++) {
							for (int j2 = 0; j2 < n; j2++) tempMap[i2][j2] = map[i2][j2];
						} // for
						
						// re-bfs
						for (int i2 = 0; i2 < m; i2++) {
							for (int j2 = 0; j2 < n; j2++) {
								if(tempMap[i2][j2] != -1) {
									tempMap[i2][j2] = -1;
									roomBrokenWidth = Math.max(bfs(tempMap, m, n, j2, i2), roomBrokenWidth); // index 명심! x y 반대로임!! 
								}
							}
						} // for
						map[i][j] = origin;
					}
				} // for ~ break the wall
			}
		} // large for
		
		System.out.println(roomCounter + "\n" + roomMaxWidth + "\n" + roomBrokenWidth);
	}
}
