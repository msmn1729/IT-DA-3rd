package backjoon.study.binarySearch;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 중량제한 https://www.acmicpc.net/problem/1939
/*
 N(2≤N≤10,000)개의 섬으로 이루어진 나라가 있다. 이들 중 몇 개의 섬 사이에는 다리가 설치되어 있어서 차들이 다닐 수 있다.
 영식 중공업에서는 두 개의 섬에 공장을 세워 두고 물품을 생산하는 일을 하고 있다. 물품을 생산하다 보면 공장에서 다른 공장으로 
 생산 중이던 물품을 수송해야 할 일이 생기곤 한다. 그런데 각각의 다리마다 중량제한이 있기 때문에 무턱대고 물품을 옮길 순 없다. 
 만약 중량제한을 초과하는 양의 물품이 다리를 지나게 되면 다리가 무너지게 된다.
 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램을 작성하시오.
 첫째 줄에 N, M(1 ≤ M ≤ 100,000)이 주어진다. 다음 M개의 줄에는 다리에 대한 정보를 나타내는 
 세 정수 A, B(1 ≤ A, B ≤ N), C(1 ≤ C ≤ 1,000,000,000)가 주어진다. 
 이는 A번 섬과 B번 섬 사이에 중량제한이 C인 다리가 존재한다는 의미이다. 서로 같은 두 도시 사이에 여러 개의 다리가 있을 수도 있으며, 
 모든 다리는 양방향이다. "마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수"가 주어진다. 
 공장이 있는 두 섬을 연결하는 경로는 항상 존재하는 데이터만 입력으로 주어진다.

 start -> end 까지 갈껀데 각 다리가 중량 제한'C'가 있음 / BFS(start to end) 하면서 큐에 넣을때 중량제한을 min으로 갱신하면?
 단순 갱신으로 하면 안됨. C(중량제한)이 1,000,000,000 이 최대에 정점이 10만개임. 
 1) pair를 가지는 list배열에 입력 다 받아 두기, [index] => (pair는 인접, 중량제한 쌍으로)
 2) 입력 받으면서 최소와 최대 중량 제한을 기억해두고 그 값 기준 mid로 탐색 시작
 3) bfs -> mid 보다 크거나 같을때 (작거나 같을때 라면 상황이 반대로 됨) -> 다음 노드로 갈 수 있음 
 4) 그렇게 target node(end point)에 도착할 수 있다면, left(low)값 갱신 / 반대 경우라면 right(high) 갱신
 5) 탐색 결과 값 출력 / 
 
 Map<Integer, ArrayList<Integer[]>>로 단순 BFS로 할 수 있을 것 같았는데 오히려 bfs할때 너무 인덱스 헷갈려서 그냥
 position 이용하려고 했는데 awt 에 position이라는 class가 있어서 걍 써먹음 
 */
public class WeightLimit {
	
	static int N,M;
    static ArrayList<Point> arrList[];
    static boolean visit[];
    static int begin, end;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arrList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) arrList[i] = new ArrayList<>();
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            low = Math.min(low, val);
            high = Math.max(high, val);
            // 중량 제한 최소와 최대값 기억해두기 
            arrList[u].add(new Point(v, val)); 
            arrList[v].add(new Point(u, val));
        }
        
        st = new StringTokenizer(br.readLine());
        begin = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        // binarySearch  
        while(low <= high) {
            visit = new boolean[N + 1]; // start기준으로 계속 갱신 하기때문에 2차원일 필요가 없음 
            int mid = (low + high) / 2;
            if(bfs(mid)) low = mid + 1; // bfs돌면서 end에 도착할수 있다(도착 했다) -> 최소를 올려
            else high = mid - 1; // mid값 보다 크거나 같은 것을 찾을 수 없다 -> 최대를 줄여
        }
        // System.out.println(low + ", " + high);
        System.out.println(high);
    }
	
    private static boolean bfs(int mid) {
        // TODO Auto-generated method stub
        Queue<Integer> que = new LinkedList<Integer>();
        visit[begin] = true; 
        que.add(begin);
        while(!que.isEmpty()) {
            int now = que.poll();
            if(now == end) return true;
            
            // for each로는 하기 더 복잡함 
            for(int i = 0; i < arrList[now].size(); i++) { // arrList[now] 에 인접한 node들 다 있음
            	// x는 다음 노드 int / y는 중량제한 => mid값 보다 크거나 같으면 진입하겠다! 
                if(!visit[arrList[now].get(i).x] && mid <= arrList[now].get(i).y) { 
                    visit[arrList[now].get(i).x] = true;
                    que.add(arrList[now].get(i).x);
                }
            } // for 
        } // while 
        return false;
    }
    
	/*
	static Map<Integer, ArrayList<Integer[]>> bridges;
	static boolean[][] visited;
	
	public static void addAjacent(int origin, int target, int C) {
		if(bridges.containsKey(origin)) {
			Integer[] temp = {target, C};
			bridges.get(origin).add(temp);
		}
		else {
			ArrayList<Integer[]> temp = new ArrayList<>();
			Integer[] _temp = {target, C};
			temp.add(_temp);
			bridges.put(origin, temp);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(BR.readLine(), " ");
		bridges = new HashMap<Integer, ArrayList<Integer[]>>();
		int N = Integer.parseInt(ST.nextToken());
		int M = Integer.parseInt(ST.nextToken());
		for (int i = 0; i < M; i++) {
			ST = new StringTokenizer(BR.readLine(), " ");
			int A = Integer.parseInt(ST.nextToken());
			int B = Integer.parseInt(ST.nextToken());
			int C = Integer.parseInt(ST.nextToken());
			
			addAjacent(A, B, C); // A -> B
			addAjacent(B, A, C); // B -> A
		} // for
		
		//////////////////////////////////////////////////////////////////
		
		visited = new boolean[N][N]; // 방문 표시는 2차원 배열로 따로
		ST = new StringTokenizer(BR.readLine(), " ");
		int start = Integer.parseInt(ST.nextToken());
		int end = Integer.parseInt(ST.nextToken());
		
		Queue<ArrayList<Integer[]>> que = new LinkedList<>();
		que.add(bridges.get(start));
		while (!que.isEmpty()) {
			ArrayList<Integer[]> now = que.poll();
			for (Integer[] pair : now) {
				if(!visited[start][pair[0]]) {
					visited[start][pair[0]] = true;
					que.add(bridges.get(pair[0]));
				}
			}
		}
	}
	*/
}
