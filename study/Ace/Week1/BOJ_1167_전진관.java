
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] edge;
	static int v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		v = Integer.parseInt(br.readLine());
		edge = new ArrayList[v+1];
		for(int i=1;i<=v;i++)edge[i] = new ArrayList();
		
		for(int i=0;i<v;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());				
				if(to == -1)continue;
				int vol = Integer.parseInt(st.nextToken());
				
				edge[from].add(new Node(to, vol));								
			}
		}
		
		// 데이터 전처리 작업 끝 .
		Node deepestNode = Bfs(1);
		int res = Bfs(deepestNode.to).vol;
		System.out.println(res);
		
	}
	
	public static Node Bfs(int start) {
		
		Queue<Node> q = new LinkedList();
		boolean[] check = new boolean[v+1];
		
		q.add(new Node(start, 0));
		check[start] = true;
		int max = 0;
		int resNode = 0;
		// 위의 값들을 아래 포문에서 비교를통해서 저장하고 가는 것이 맞는 것인지 확인. -- 넣는것으로 진행  
		// 1에서 시작하는 걸로 1에서 연결되어 있는 것들을 q에 넣는 식으로 진행. 
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<edge[node.to].size();i++) {
				Node next = edge[node.to].get(i);
				
				if(!check[next.to]) {
					int nTo = next.to;
					int nVol = next.vol + node.vol;
					
					if(nVol > max) {
						max = nVol;
						resNode = nTo;
					}
					q.add(new Node(nTo, nVol));
					check[nTo] = true;
				}	 
			}		
		}
		
		return new Node(resNode, max);
	}
	
	static class Node{
		int to;
		int vol;
		
		Node(int to, int vol){
			this.to = to;
			this.vol = vol;
		}
	}
}
