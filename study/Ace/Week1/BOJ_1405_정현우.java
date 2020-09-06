package backjoon.itda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.StringTokenizer;

// 미친 로봇 https://www.acmicpc.net/problem/1405
/*
 통제 할 수 없는 미친 로봇이 평면위에 있다. 그리고 이 로봇은 N번의 행동을 취할 것이다.
 각 행동에서 로봇은 4개의 방향 중에 하나를 임의로 선택한다. 그리고 그 방향으로 한 칸 이동한다.
 로봇이 "같은 곳을 한 번보다 많이 이동하지 않을 때", 로봇의 이동 경로가 "단순"하다고 한다. (로봇이 시작하는 위치가 처음 방문한 곳이다.) 
 로봇의 이동 경로가 단순할 확률을 구하는 프로그램을 작성하시오. (E는 동, W는 서, N은 북, S는 남)
 예를 들어, EENE와 ENW는 단순하지만, ENWS와 WWWWSNE는 단순하지 않다. 
 첫째 줄에 N, 동쪽으로 이동할 확률, 서쪽으로 이동할 확률, 남쪽으로 이동할 확률, 북쪽으로 이동할 확률이 주어진다. 
 N은 '14보다 작거나 같은 자연수'이고,  모든 확률은 100보다 작거나 같은 자연수 또는 0이다. 그리고, 동서남북으로 이동할 확률을 모두 더하면 100
 첫째 줄에 로봇의 이동 경로가 단순할 확률을 출력한다. 절대/상대 오차는 10-9 까지 허용한다.

 같은 곳을 한 번 보다 많이 이동하지 않을때! -> 같은 곳을 또 방문할때 / '단순할' 확률을 구하기 / N 14 최대 인거보면 부르트 포스 같긴 함  
 = "단순한 경우의 수 / 전체 경우의 수" // 또는, N만큼 진행하면서 단순한 경우만 보고 곱셈 확률 
 1) 그래프 탐색으로 로 N 깊이 만큼 동서남북 다 가면서, 깊어 질 때 마다 확률 곱하기 / N이 최대 14까지 나오므로 30개의 맵을 선언한다. / 14,14좌표에서 DFS를 시작한다.
 	지금 포지션 시작지점과 같으면 static 변수에 구한 확률 더하기 
 2) 단순과 단순하지 않은 것에 초점을 맞춰서 풀다보니까 헷갈린다,, / DFS로 바꿈,, 
 	기본 로직은 동일하지만 전체 그냥 단순 비단순 초점 없이 전체 확률 구하기 (확률의 곱셈) 
	/ Depth == N일때 percent를 최종ans에 더한다. / 아 이게 dfs로 보니까 단순 비단순의 의미가 보임
	아닌데? 단순과 비단순이 단말에 가까워질수록, (depth N) 단순 비단순 동시 존재인데 왜? 

 */
public class Main {
	static int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static double answer = 0;
	// static int[][] map;
	static boolean visited[][]; 
	static double[] input;
	static int N;
	
	/* object + BFS version
	 
	static class Pair { 
		public int x, y, depth; 
		public double probability;
		Pair(int x, int y, int depth, double probability) { 
			this.x = x; 
			this.y = y;
			this.depth = depth;
			this.probability = probability;
		} 
	}
	
	public static void bfs(int start, int maxDepth) {
		Pair root = new Pair(start, start, 0, 1);
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(root);
		
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if(now.depth > maxDepth) continue;
        	if(now.x == start && now.y == start && now.probability != 1.0) { // root면 pass 
        		// System.out.println(now.probability);
        		answer += now.probability;
        	}
            
            for (int k = 0; k < 4; k++) {
            	// [0] 동, [1] 서, [2] 남, [3] 북 순서로 움직임 
                int nextX = now.x + direction[k][1]; 
                int nextY = now.y + direction[k][0];
                
                if(nextX >= 0 && nextX < 2 * maxDepth && nextY >= 0 && nextY < 2 * maxDepth) {
                	// index 'k' 가 어떻게 보면 핵심 
                	queue.offer(new Pair(nextX, nextY, now.depth + 1, now.probability * (((double) input[k]) / 100)));
                } // bound check
            } // for
        } // while
	}	
	*/
	
	// 전체 모든 경우의 수, 이동 누적 확률 
    private static void dfs(int nowX, int nowY, int nowDepth, double nowProbability) { 
        if(nowDepth == N) { 
            answer += nowProbability; 
            return; 
        } 
        
        for (int i = 0; i < 4; i++) { 
            if(input[i] == 0) continue; 
            int nextX = nowX + direction[i][1]; 
            int nextY = nowY + direction[i][0]; 
            if(!visited[nextX][nextY]) { 
            	visited[nextX][nextY] = true; 
                dfs(nextX, nextY, nowDepth + 1, input[i] * nowProbability); // 확률 곱 
                visited[nextX][nextY] = false; 
            }
        } // for 
    } // dfs 
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		StringTokenizer ST = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
		N = Integer.parseInt(ST.nextToken()); // depth
		input = new double[ST.countTokens()];
		for (int i = 0; i < input.length; i++) input[i] = Integer.parseInt(ST.nextToken()) * 0.01;
		visited = new boolean[30][30]; // 아무리 커도 이 이상 벗어날 수 가 없음
		// map = new int[2*N][2*N]; // 아무리 커도 이 이상 벗어날 수 가 없음 
		
		////////////////////////////////////////////////////////////////////////////////
		// bfs(N, N);
		// System.out.println(1.0 - answer);
		
		visited[14][14] = true; 
        dfs(14, 14, 0, 1.0); 
        System.out.println(answer); 
	}
}

