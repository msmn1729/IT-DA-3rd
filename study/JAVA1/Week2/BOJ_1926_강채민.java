import java.util.*;

public class Main{

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); // 세로
		int M = input.nextInt(); // 가로
		
		int Geulim [][] = new int[N][M];
		int check [][] = new int[N][M];
		
		int move_x[] = {1, -1, 0, 0};
		int move_y[] = {0, 0, 1, -1};
		
		for(int n = 0; n < N; n++)
			for(int m = 0; m < M; m++)
				Geulim[n][m] = input.nextInt();
		
		Queue<Integer> Geulim_X = new LinkedList<>(); // 그림 X좌표
		Queue<Integer> Geulim_Y = new LinkedList<>(); // 그림 Y좌표
		
		ArrayList<Integer> Find_Max = new ArrayList<>(); // 그림의 넓이를 다 담을 ArrayList. 이중에서 가장 큰 값을 출력한다.
		
		int picture_count = 0; // 전체 그림의 개수 
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				
				int onepicture_count = 0; // 한 그림의 크기
				
				if(check[i][j] == 1 || Geulim[i][j] == 0) // 간 곳이거나 그림이 아니면
					continue;
				
				Geulim_X.add(i);
				Geulim_Y.add(j);
				
				check[i][j] = 1; // 갔다고 체크해주기.
				
				picture_count = picture_count + 1; // 전체 그림 개수 증가
				
				while(!Geulim_X.isEmpty()) {
					
					int X = Geulim_X.poll();
					int Y = Geulim_Y.poll();
					
					onepicture_count = onepicture_count + 1; // 한 그림의 크기 증가.
					
					for(int mx = 0; mx < move_x.length; mx++) { // 상하좌우로 움직이면서
						
						int go_x = X + move_x[mx];
						int go_y = Y + move_y[mx];
						
						if(go_x < 0 || go_y < 0 || go_x >= N || go_y >= M) // 범위 벗어날경우
							continue;
						
						if(check[go_x][go_y] == 1 || Geulim[go_x][go_y] == 0) // 갔던곳이거나 그림이 아니라면
							continue;
						
						Geulim_X.add(go_x);
						Geulim_Y.add(go_y);
						
						check[go_x][go_y] = 1;
					}
				}
				
				Find_Max.add(onepicture_count); // ArrayList에다가 한 그림의 크기 넣기.
			}
		}
		
		System.out.println(picture_count); // 전체 그림의 개수 출력.
		
		if(picture_count == 0) // "단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다."
			System.out.println(0);
		
		else
			System.out.println(Collections.max(Find_Max));
		
	}

}
