package backjoon.study.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 캐슬 디펜스 https://www.acmicpc.net/problem/17135
/*
 캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다. 게임이 진행되는 곳은 크기가 N × M인 격자판으로 나타낼 수 있다. 
 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다. 격자판의 N번행의 바로 아래(N+1번 행)의 '모든 칸에는 성'이 있다.
 성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다. 
 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다. 궁수가 공격하는 적은 거리가 'D이하인 적 중에서 가장 가까운 적'이고, 
 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외된다. 
 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 
 모든 적이 격자판에서 제외되면 게임이 끝난다. 
 게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다. 따라서, 이 게임은 궁수의 위치가 중요하다. 
 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.
 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.
 첫째 줄에 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D가 주어진다. 
 둘째 줄부터 N개의 줄에는 격자판의 상태가 주어진다. 0은 빈 칸, 1은 적이 있는 칸이다. 제거할 수 있는 적의 최대 수를 출력한다.
 3 ≤ N, M ≤ 15 / 1 ≤ D ≤ 10 / 
 
 1) N+1행 0~M 열 중 3개를 뽑아 궁수를 배치한다 -> 이 배치를 그래프 탐색으로 하나? 백트래킹으로 조합 뽑아내기 방식이 좋을 것 같은데 
 2) large for(적이 없을 때 까지)로 적을 움직인다. -> / 아마 while이 나을 듯? 
 3) 일단 그 상태에서 궁수 포지션 중심으로 dfs 탐색으로 적을 만날때까지 and depth가 D이하일때까지, 근데 가장 가까워야한다?? 
    적 명수 만큼 시도 하되, Min postion 갱신? -> == 일때는 position x가 작은 걸 선택 / 거리는 |r1-r2| + |c1-c2|
 4) position 값 잡힌 적을 제거하면서 answer++ -> 모든 적의 포지션 y ++ 한다, map을 체크해서 모두 0인지 체크한다 
 5) larget for +1 // 가장 바깥이 궁수 배치임 
 */
public class CattleDefence {
	static int map[][];
	static class Position { int x, y; Position(int x, int y) { this.x = x; this.y = y; } }
	
	public static boolean isEnemy() { // 턴 진행 할지 말지
		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] != 0) return true;
			}
		}
		return false;
	}
	
	public static void attackArcher(int[] archerPosition) {
		while (isEnemy()) { // map에 적군이 없을때 까지 진행  
			// 궁수 포지션 중심으로 dfs 탐색으로 적을 만날때까지 and depth가 D이하일때까지
			// archerPosition Arr에서 0이 아닌 값들이 다 아처가 있음, 행의 값은 N + 1임 
			
		}
	}
	
	// 백트래킹, M중에 r개 뽑자 / N + 1 행의 배열 값 리턴하는 것 
	public static void combination(int[] arr, boolean[] visited, int start, int M, int r) {
	    if(r == 0) {
	    	int[] returnArr = new int[M];
	    	for (int i = 0; i < M; i++) {
	            if (visited[i]) returnArr[i] = arr[i];
	        }
	    	
	        // 3개가 뽑혔음 -> 여기서 2) ~ 5) 
	    	// System.out.println(Arrays.toString(returnArr));
	    	attackArcher(returnArr);
	    	return;
	    }
	    else {
	    	for(int i = start; i < M; i++) {
		        visited[i] = true;
		        combination(arr, visited, i + 1, M, r - 1);
		        visited[i] = false;
		    }
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = BR.readLine().split(" ");
		int N = Integer.parseInt(temp[0]); // 행 -> y 
		int M = Integer.parseInt(temp[1]); // 열 -> x
		int D = Integer.parseInt(temp[2]); // 궁수의 공격 거리 제한 D
		map = new int[N + 1][M]; // 행. 열, 궁수 배치를 위한 + 1
		for (int i = 0; i < N; i++) {
			temp = BR.readLine().split(" "); // 0은 빈 칸, 1은 적이 있는 칸
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(temp[j]);
		}
		for (int i = 0; i < M; i++) map[N][i] = i + 1; // 위치 구분 위한 값 이니셜라이징 
		
		boolean visited[] = new boolean[M];
		combination(map[N], visited, 0, M, 3);
		
		
		///////////////////////////////////////////////////////////////////////////
		
		// 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 
		// 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외된다. 궁수의 공격이 끝나면, 적이 이동한다. 
		// 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 모든 적이 격자판에서 제외되면 게임이 끝난다.
		// 궁수는 성이 있는 칸에 배치 가능, 성이 있는 칸은 N + 1 행 모든 칸 
		
		
	}
}
