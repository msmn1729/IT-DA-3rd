package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 발은 상근이네 집에서 하고, 
 * 맥주 한 박스를 들고 출발한다. 
 * 맥주 한 박스에는 맥주가 20개 들어있다. 목
 * 이 마르면 안되기 때문에 50미터에 한 병씩 마시려고 한다.ㅋㅋ 또라이야?
 * 
 * 맥주를 더 구매해야 할 수도 있다. 미리 인터넷으로 조사를 해보니 다행히도 맥주를 파는 편의점이 있다. 
 * 편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다. 
 * 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다.
 * 
 * 집 
 * 편의점
 * 페스티벌 
 * 
 * 집을 기준으로 편의점 거리 정렬 하면... 편의점도 같이 정렬되지 않나 
 * --> BFS로 풂
 */


class Position {
	int x;
	int y;
	
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class Q9205 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		
		for(int q=0;q<t;q++) {
			int n = Integer.parseInt(br.readLine());
			Position position[] = new Position[n+1];
			boolean visited[] = new boolean[n+2];
			Queue<Position> Q = new LinkedList<>();
			boolean rs = false;
			
			String input[] = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]); int y = Integer.parseInt(input[1]);
			Position home = new Position(x,y);
			
			for(int i=0;i<n;i++) {
				input = br.readLine().split(" ");
				x = Integer.parseInt(input[0]);  y = Integer.parseInt(input[1]);
				Position m = new Position(x,y);
				position[i]=m;
			}
			
			input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);  y = Integer.parseInt(input[1]);
			Position goal = new Position(x,y);
			position[n]=goal;
			//입력끝 
			
			Q.add(home);
			
			while(!Q.isEmpty()) {
				Position cur = Q.poll();
				//현재 == 목표지점
				if(cur.equals(goal)) {
					rs= true;
					break;
				}
				
				for(int i=0;i<n+1;i++) {
					Position p = position[i];
					int d = Math.abs(p.x-cur.x)+Math.abs(p.y-cur.y);
					if(d<=1000 && visited[i]==false) {
						Q.add(position[i]);
						visited[i]=true;
					}
				}
			}
			if(rs) {System.out.println("happy");}
			else {System.out.println("sad");}
		}
	}
}