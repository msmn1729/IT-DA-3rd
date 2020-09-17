package BaekJoon;

import java.util.*;

public class HW_BJ_2234_Castle {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		int Castle_Map [][] = new int [M][N];
		int Castle_Map2 [][] = new int [M][N]; // 구역 번호 저장할 새로운 Map
		int check [][] = new int [M][N];
		
		int move_x[] = {1, 0, -1, 0}; // 서북동남인데 이진수는 거꾸로 탐색하니까 순서는 남동북서로!
		int move_y[] = {0, 1, 0, -1};
		
		for(int m = 0; m < M; m++) 
			for(int n = 0; n < N; n++)
				Castle_Map[m][n] = input.nextInt();
		
		Queue<Integer>Castle_X = new LinkedList<>();
		Queue<Integer>Castle_Y = new LinkedList<>();
		
		ArrayList<Integer>Room_Area = new ArrayList<>();
		
		int room = 0;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				
				int count = 0;
				
				if(check[i][j] == 1)
					continue;
				
				else {
					
					Castle_X.add(i);
					Castle_Y.add(j);
					
					check[i][j] = 1;
					
					room = room + 1;
					
					Castle_Map2[i][j] = room; // 구역 번호 넣어주기.
					
					while(!Castle_X.isEmpty()) {
						
						int X = Castle_X.poll();
						int Y = Castle_Y.poll();
						
						count++; // 방의 크기 증가.
						
						
						int num = Castle_Map[X][Y];
						
						String Bnum = String.format("%04d",
								Integer.parseInt(Integer.toBinaryString(num))); //2진수 변환에  + 이걸 4자리로 변환.

						for(int s = 0; s < Bnum.length(); s++) {
							
							char tmp_s = Bnum.charAt(s);
							
							if(tmp_s == '1') //벽이면
								continue;
							
							
							int go_x = X + move_x[s];
							int go_y = Y + move_y[s];
							
							if(go_x < 0 || go_y < 0 || go_x >= M || go_y >= N) // 범위 벗어날경우
								continue;
							
							if(check[go_x][go_y] == 1)
								continue;
							
							Castle_X.add(go_x);
							Castle_Y.add(go_y);
							
							check[go_x][go_y] = 1;
							
							Castle_Map2[go_x][go_y] = room;
						}
					}
					
					Room_Area.add(count); // 한 방의 크기 ArrayList에 넣기.
				}
			}
		}
		
		System.out.println(room); // 이 성의 방의 개수
		
		/*for(int a = 0; a < Room_Area.size(); a++)
			System.out.println(Room_Area.get(a));*/
		
		System.out.println(Collections.max(Room_Area)); // 가장 넓은 방의 크기
		
		
		//잘 들어가있다! 구역 번호 별로
		/*for(int iii = 0; iii < M; iii++) {
			for(int jjj = 0; jjj < N; jjj++) {
				System.out.print(Castle_Map2[iii][jjj] + " ");
			}
			
			System.out.println();
		}*/
		
		int check2 [][] = new int [M][N];
		
		int max_area = 0; // 합해서 max일거 체크하기
		
		for(int r = 1; r <= room; r++) { // 구역 번호 별로 돌기!
			
			for(int ii = 0; ii < M; ii++) {
				
				for(int jj = 0; jj < N; jj++) {
					
					if(check2[ii][jj] == 1 || Castle_Map2[ii][jj] != r)
						continue;
					
					//queue는 어차피 초기화 되었으니까 다시 사용해도 되겠지?
					
					Castle_X.add(ii);
					Castle_Y.add(jj);
					
					check2[ii][jj] = 1;
					
					while(!Castle_X.isEmpty()) {
						
						int X = Castle_X.poll();
						int Y = Castle_Y.poll();
						
						//int area_index = Castle_Map2[X][Y];
						
						for(int mx = 0; mx < move_x.length; mx++) {
							
							int gogo_x = X + move_x[mx];
							int gogo_y = Y + move_y[mx];
							
							if(gogo_x < 0 || gogo_y < 0 || gogo_x >= M || gogo_y >= N) // 범위 벗어날경우
								continue;
							
							if(check2[gogo_x][gogo_y] == 1)
								continue;
							
							int go_area_index = Castle_Map2[gogo_x][gogo_y];
							
							if(r != go_area_index) {
								max_area = Math.max(max_area, 
										(Room_Area.get(r - 1) + Room_Area.get(go_area_index - 1)));
								
								continue;
							}
							
							Castle_X.add(gogo_x);
							Castle_Y.add(gogo_y);
							
							check2[gogo_x][gogo_y] = 1;
						}
					}
				}
			}
		}
		
		System.out.println(max_area);
	}

}
