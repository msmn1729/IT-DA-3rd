import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Beer {

	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b){
			x = a;
			y = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//50미터마다 한 병씩
		//편의점에서 리필가능
		//최대 102개 좌표
		//bfs
		int t;
		int n;
		int now;
		int x;
		int y;
		int visited[];
		boolean sw;
		Graph[] graph;
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
	
		for(int i = 0; i < t; i++) {
			sw = false;
			n = Integer.parseInt(br.readLine());
			graph = new Graph[n + 2];
			visited = new int[n + 2];
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			graph[0] = new Graph(x, y);
			
			for(int j = 1; j <= n+1; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if(Math.abs(graph[0].x - x) + Math.abs(graph[0].y - y) <= 1000) {
					list.add(j);//graph의 인덱스 저장
					visited[j] = 1;
				}
				graph[j] = new Graph(x, y);
			}
		
			while(!list.isEmpty()) {
				now = list.get(0);
				if(now == n+1) {
					System.out.println("happy");
					sw = true;
					break;
				}
				for(int j = 1; j <= n+1; j++) {
					if(visited[j] == 0 && Math.abs(graph[now].x - graph[j].x) + Math.abs(graph[now].y - graph[j].y) <= 1000) {
						if(j == n+1) {
							System.out.println("happy");
							sw = true;
							break;
						}
						list.add(j);
						visited[j] = 1;
					}
				}
				if(sw == true)
					break;
				list.remove(0);
			}
			
			if(sw == false)
				System.out.println("sad");
			
			list.clear();
		}
	}

}
