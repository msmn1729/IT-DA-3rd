package BaekJoon;

import java.util.*;

public class HW_BJ_1743_AvoidFood {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); // 세로 길이
		int M = input.nextInt(); // 가로 길이
		int K = input.nextInt(); // 음식물 쓰레기 개수
		
		int Food_Map [][] = new int[N][M];
		int check [][] = new int[N][M];
		
		int move_x[] = {1, -1, 0, 0};
		int move_y[] = {0, 0, 1, -1};
		
		for(int k = 0; k < K; k++) {
			
			int r = input.nextInt();
			int c = input.nextInt();
			
			Food_Map[r-1][c-1] = 1;
		}
		
		Queue<Integer> Food_X = new LinkedList<>();
		Queue<Integer> Food_Y = new LinkedList<>();
		ArrayList<Integer> Answer = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				
				int count = 0;
				
				if(check[i][j] == 1 || Food_Map[i][j] == 0)
					//갔던 곳이거나, 음식물이 없는 좌표일 경우
					continue;
				
				else {
					Food_X.add(i);
					Food_Y.add(j);
					
					check[i][j] = 1;
					
					count = count + 1;
					
					
					while(!Food_X.isEmpty()) {
						
						int X = Food_X.poll();
						int Y = Food_Y.poll();
						
						for(int mx = 0; mx < move_x.length; mx++) {
							
							int go_x = X + move_x[mx];
							int go_y = Y + move_y[mx];
							
							if(go_x < 0 || go_y < 0 || go_x >= N || go_y >= M) // 범위 벗어날경우
								continue;
							
							if(check[go_x][go_y] == 1 || Food_Map[go_x][go_y] != 1) 
								// 이미 간 곳이거나 음쓰가 없으면
								continue;
							
							Food_X.add(go_x);
							Food_Y.add(go_y);
							
							check[go_x][go_y] = 1;
							
							count = count + 1;
						}
					}
					
					Answer.add(count);
				}
			}
		}
		
		System.out.println(Collections.max(Answer));
	}

}
