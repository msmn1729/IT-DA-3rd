package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*번외문제
 * 단지번호 붙이기
 * 집이 있는 곳을 발견하면, 해당 집과 연결된 집들을 모두 방문하면서 단지 내 집의 수를 count
 * 여기서 집들을 방문하면서 단지번호를 저장해준다.
 * */
public class Main2{
	static int dx[] = {-1,1,0,0}; //x죄표
	static int dy[] = {0,0,-1,1}; //y좌표
	
	static public class pos{
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		String input;
		for(int i=0; i<N; i++) {
			input = br.readLine();
			for(int j=0;j<N; j++) {
				map[i][j] = input.charAt(j) - '0'; //int로 자료형 change 문자'0'을 뺴줘야한다
			}
		}
		int mark =1, cnt;
		Queue<pos> q = new LinkedList<>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		//모든 좌표를 확인하면서
		for(int i =0 ; i< N; i++) {
			for(int j=0; j<N; j++) {
				//집이 있다면
				if(map[i][j]==1) {
					cnt = 1; //해당 단지내 집의 수를 count하기 위한 변수
					mark++; //단지 번호
					q.add(new pos(i,j));
					map[i][j] = mark;
					
					while(!q.isEmpty()) {
						pos now = q.poll();
						
						for(int d = 0; d< 4; d++) {
							int xx = now.x + dx[d]; //상하좌우 탐색
							int yy = now.y + dy[d];
							//map의 범위를 벗어나면 pass
							if(xx<0 || yy<0 || xx>=N || yy>=N ) continue;
							//집이 없거나, 이미 단지가 정해진 집이라면 pass
							if(map[xx][yy] !=1 )continue;
							//단지를 정해주고 queue에 넣기
							
							map[xx][yy] = mark; //같은 단지로 만들기
							cnt++;
							q.add(new pos(xx,yy)); //여기서 또 상하좌우 탐색
						}
					}
					//단지 내 집의 수를 list에 넣어주기
					res.add(cnt);
				}
			}
		}
		System.out.println(mark - 1);
		
		//단지내 집의 수를 오름차순으로 정렬
		res.sort(null);
		for(int x: res)
			sb.append(Integer.toString(x) + '\n');
		System.out.println(sb);
	}
}
