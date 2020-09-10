package backjoon.study.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 말이 되고픈 원숭이 https://www.acmicpc.net/problem/1600
/*
 동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 그 녀석은 말(Horse)이 되기를 간절히 원했다. 
 그래서 그는 말의 움직임을 유심히 살펴보고 그대로 따라 하기로 하였다. 말은 말이다. 
 말은 격자판에서 체스의 '나이트'와 같은 이동방식을 가진다. 다음 그림에 말의 이동방법이 나타나있다. 
 x표시한 곳으로 말이 갈 수 있다는 뜻이다. 참고로 말은 장애물을 뛰어넘을 수 있다.
  	x	 	x	 
x	 	 	 	x
 	 	말	 	 
x	 	 	 	x
 	x	 	x	 
 근데 원숭이는 한 가지 착각하고 있는 것이 있다. 말은 저렇게 움직일 수 있지만 원숭이는 능력이 부족해서 총 'K번만 위와 같이' 움직일 수 있고, 
 그 외에는 '그냥 인접한 칸'으로만 움직일 수 있다. 대각선 방향은 인접한 칸에 포함되지 않는다.
 이제 원숭이는 머나먼 여행길을 떠난다. 격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다. 
 인접한 네 방향으로 한 번 움직이는 것, 말의 움직임으로 한 번 움직이는 것, 모두 한 번의 동작으로 친다. 
 격자판이 주어졌을 때, 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램을 작성하시오.
 첫째 줄에 정수 K가 주어진다. 둘째 줄에 격자판의 가로길이 W, 세로길이 H가 주어진다. 
 그 다음 H줄에 걸쳐 W개의 숫자가 주어지는데, 0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 
 장애물이 있는 곳으로는 이동할 수 없다. 시작점과 도착점은 항상 평지이다. W와 H는 1이상 200이하의 자연수이고, K는 0이상 30이하의 정수이다.
 첫째 줄에 원숭이의 동작수의 최솟값을 출력한다. 시작점에서 도착점까지 갈 수 없는 경우엔 -1을 출력한다.

 0 0 -> W H / 상하좌우가 인접, k 번 나이트 움직임 가능 / map 0 이동 가능, 1 불가능 / 최소한 동작으로 도착지점까지
 2초 256 MB / 200 200 까지 최대면 2초 안에 안될 가능성도 있다,, 특히 움직임 경우의 수가 8 + 4,,
 1) dfs 0 0 출 -> counter + 1 -> W H return
 2) 인접 상하좌우 + 나이트 움직임 8방향 (K counter) 
 3) 문제는 상하좌우 부터 vs 나이트 움직임 부터 인 것 같다 / 처음에 dfs를 for문 2집단(나이트, 인접)으로 나눴는데 한개로 묶어서 같이 돌렸다
 => 시간 초과,, map 사이즈와 경우의 수가 너무 엄청나서 당연한 결과긴 하다 
 => dp적인 요소가 필요하다! 불필요한 탐색 가지치기! / 다익스트라 느낌으로 접근해야 하는건가? / 그럼 dfs는 X
 : BFS로 퍼지면서, map 좌표 값에 move counter 값 입력해 주고, 그 무브 카운트 값 기점으로 갱신하면서 움직이면? 
 : 음,, visited[x][y][jump]와 같이 체크해주면 "(x, y) 좌표에, 말 움직임 횟수를 jump회 남기고 도달할 수 있는 최소 횟수" 라고 정의하면 됩니다.
 : hint from "https://www.acmicpc.net/board/view/30139"
  
 */
public class MonkeyWantToBeHorse {
	// night 움직임 index
	static int[][] nightDirection = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] map;
	static boolean[][][] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static class Position {
		int x, y, k, move;
		public Position(int x, int y, int k, int move) { this.x = x; this.y = y; this.k = k; this.move = move;}
	}
	
	private static void bfs(int W, int H, int maxK) {
		Position root = new Position(0, 0, maxK, 0);
		Queue<Position> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			Position now = q.poll();
			if(now.x == W - 1 && now.y == H - 1) {
				answer = Math.min(answer, now.move);
				return;
			}
			
			// out of bound test
			if(now.x >= 0 && now.x < W && now.y >= 0 && now.y < H) {
				// 
				if(map[now.y][now.x] == 0 && !visited[now.y][now.x][now.k]) {
					visited[now.y][now.x][now.k] = true;
					
					for (int i = 0; i < 4; i++) { // 상하좌우 선  
			        	int nextX = now.x + direction[i][0]; 
			            int nextY = now.y + direction[i][1];
			            // System.out.println("상하좌우: " + nextX + ", " + nextY);
			            q.add(new Position(nextX, nextY, now.k, now.move + 1));
					}
					
					if(now.k == 0) continue;
					for (int i = 0; i < 8; i++) { // 상하좌우 선  
			        	int nextX = now.x + nightDirection[i][0]; 
			            int nextY = now.y + nightDirection[i][1];
			            // System.out.println("나이트: " + nextX + ", " + nextY);
			            q.add(new Position(nextX, nextY, now.k - 1, now.move + 1));
					}
				}
			}
		} // while 
	}
	
	/*
    private static void dfs(int W, int H, int nowX, int nowY, int nowK, int maxK, int moveCounter) { 
        if(moveCounter > answer) return;
    	if(nowX == W - 1 && nowY == H - 1) { 
            answer = Math.min(answer, moveCounter);
            return; 
        } 
        
    	for (int i = 0; i < 12; i++) { // 나이트 움직임 
        	int nextX = nowX + direction[i][1]; 
            int nextY = nowY + direction[i][0]; 
            
            if(i >= 8) { // 상하좌우 
                if(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H) { // bound check
                    if(map[nextX][nextY] == 0 && !visited[nextX][nextY]) { 
                    	// System.out.println(nextX + ", " + nextY);
                    	visited[nextX][nextY] = true; 
                        dfs(W, H, nextX, nextY, nowK, maxK, moveCounter + 1); 
                        visited[nextX][nextY] = false; 
                    }            	
                }
            }
            else if(nowK < maxK) {
                if(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H) { // bound check
                    if(map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    	// System.out.println(nextX + ", " + nextY);
                    	visited[nextX][nextY] = true; 
                        dfs(W, H, nextX, nextY, nowK + 1, maxK, moveCounter + 1); 
                        visited[nextX][nextY] = false; 
                    }            	
                }            	
            }
    	} // for
    } // dfs 
    */
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(BR.readLine());
		String[] temp = BR.readLine().split(" ");
		int W = Integer.parseInt(temp[0]);
		int H = Integer.parseInt(temp[1]);
		map = new int[H][W];
		visited = new boolean[H][W][31];
		visited[0][0][0] = true;
		
		for (int i = 0; i < H; i++) {
			temp = BR.readLine().split(" ");
			for (int j = 0; j < W; j++) map[i][j] = Integer.parseInt(temp[j]);
		}
		
		///////////////////////////////////////////////////////////////////////////////
		
		// dfs(W, H, 0, 0, 0, K, 0);
		bfs(W, H, K);
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
}
