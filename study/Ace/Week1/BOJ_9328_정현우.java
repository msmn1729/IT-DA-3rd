package backjoon.study.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 열쇠 https://www.acmicpc.net/problem/9328
/*
 상근이는 1층 빌딩에 침입해 매우 중요한 문서를 훔쳐오려고 한다. 상근이가 가지고 있는 평면도에는 문서의 위치가 모두 나타나 있다. 
 빌딩의 문은 모두 잠겨있기 때문에, 문을 열려면 열쇠가 필요하다. 상근이는 일부 열쇠를 이미 가지고 있고, 일부 열쇠는 빌딩의 바닥에 놓여져 있다.
 상근이가 훔칠 수 있는 문서의 최대 개수를 구하는 프로그램을 작성하시오.
 첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스의 수는 100개를 넘지 않는다.
 각 테스트 케이스의 첫째 줄에는 지도의 높이와 너비 h와 w (2 ≤ h, w ≤ 100)가 주어진다. 
 다음 h개 줄에는 빌딩을 나타내는 w개의 문자가 주어지며, 각 문자는 다음 중 하나이다.
 '.'는 빈 공간을 나타낸다. / '*'는 벽을 나타내며, 상근이는 벽을 통과할 수 없다. / '$'는 상근이가 훔쳐야하는 문서이다.
 알파벳 대문자는 문을 나타낸다. / 알파벳 소문자는 열쇠를 나타내며, 그 문자의 대문자인 모든 문을 열 수 있다.
 마지막 줄에는 상근이가 이미 가지고 있는 열쇠가 공백없이 주어진다. 만약, 열쇠를 하나도 가지고 있지 않는 경우에는 "0"이 주어진다.
 상근이는 처음에는 빌딩의 밖에 있으며, 빌딩 가장자리의 빈 공간이나 문을 통해 빌딩 안팎을 드나들 수 있다. 
 각각의 문에 대해서, 그 문을 열 수 있는 열쇠의 개수는 0개, 1개, 또는 그 이상이고, 각각의 열쇠에 대해서, 
 그 열쇠로 열 수 있는 문의 개수도 0개, 1개, 또는 그 이상이다. 열쇠는 여러 번 사용할 수 있다.
 
 비트마스크 느낌으로? boolean key[index], index를 input으로 받고, 그 인덱스 값을 아스키코드값으로 정수값으로 치환해서 저
 1) 들어갈 수 있는지 없는지 체크? -> 들어갈 수 있는 곳 부터 bfs? 
 2) 들어간 지점부터 탐색을 한다, bfs, map[position] 값 마다 다르게 
 2 - 1) 키 값은 keyValue[input index] ~ input index는 아스키코드 값 차이로 얻는 정수값으로 
 2 - 2) 그 값이 일치한다면 열 수 있는 문이고 값을 바꾸면 된다
 2 - 3) 문제는 빡치는게 나중에 열 수 있는 경우다 시발!! 어케하누~?
 
 */
public class TheKey {
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static char[][] map;
	static boolean[][] visited;
	static boolean[] keyValue;
	static int answer;
	static class Position{ int x, y; Position(int x, int y){ this.x = x; this.y = y; } }
		
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(BR.readLine());
		while (T-- > 0) {
			String[] temp = BR.readLine().split(" ");
			int h = Integer.parseInt(temp[0]); // y 
			int w = Integer.parseInt(temp[1]); // x
			map = new char[h][w]; // y x 
			visited = new boolean[h][w];
			answer = 0;
			
			for (int i = 0; i < h; i++) {
				String temp_ = BR.readLine();
				for (int j = 0; j < w; j++) map[i][j] = temp_.charAt(j); 
			}
			String keys = BR.readLine();
			if(!keys.equals("0")) { // 키가 있는 경우 
                for(int i = 0; i < keys.length(); i++) keyValue[keys.charAt(i) -'a'] = true; // input을 index로 
            }
			
			/////////////////////////////////////////////////////////////////////////
			
			// BFS 
			Queue<Position> q = new LinkedList<>();
	        q.add(new Position(0,0));
	        visited[0][0] = true;
	        
	        while(!q.isEmpty()) {
	        	Position now = q.poll();
	            for(int i = 0; i < 4; i++) { // 상하 좌우 
	                int nextX = now.x+ direction[i][0];
	                int nextY = now.y+ direction[i][1];
	                if(nextX >= 0 && nextY >= 0 && nextX < w && nextY < h) { // check out of bound
	                    if(!visited[nextY][nextX] && map[nextY][nextX] != '*') {
	                    	// 아스키코드 ~ 알파벳 대문자 만난 경우 
	                        if(map[nextY][nextX] - 'A' >= 0 && map[nextY][nextX] - 'A' <= 25) { 
	                            if(keyValue[map[nextY][nextX] - 'A']) { // 아스키코드로 열쇠를 가지고 있는지 체크
	                                map[nextY][nextX]='.'; // 문 없애기 
	                                q.add(new Position(nextX,nextY));
	                                visited[nextY][nextX]=true;
	                            }
//	                            else {
//	                                // 해당하는 열쇠가 없을경우 
//	                                
//	                            }
	                        }
	                        // 아스키코드 ~ 알파벳 소문자 만난 경우 
	                        else if(map[nextY][nextX] - 'a' >= 0 && map[nextY][nextX] - 'a' <= 25) { 
	                        	keyValue[map[nextY][nextX] - 'a'] = true; // key 포함 시켜주고 
	                            visited[nextY][nextX] = true;
	                            q.add(new Position(nextX, nextY));
	                        }
	                        //빈칸 인 경우 그대로 
	                        else if(map[nextY][nextX] == '.') {    
	                            visited[nextY][nextX] = true;    
	                            q.add(new Position(nextX, nextY));
	                        }
	                        // 문서 발견 
	                        else if(map[nextY][nextX] == '$') {    
	                            answer++;
	                            visited[nextY][nextX] = true;
	                            q.add(new Position(nextX, nextY));
	                        }
	                        
	                        // 나중에 획득한 열쇠 처리 

	                    } // value check
	                } // if bound check
	            } // for 상하 좌우 
	        } // bfs - inner while 
			
			
		} // while test case
	}
}
