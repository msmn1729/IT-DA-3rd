package backjoon.study.graph;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 단절점과 단절선 https://www.acmicpc.net/problem/14675
/*
 그래프 이론에서 단절점(cut vertex)과 단절선(bridge)은 다음과 같이 정의 된다.
 - 단절점(cut vertex) : 해당 정점을 제거하였을 때, 그 정점이 포함된 그래프가 2개 이상으로 나뉘는 경우, 이 정점을 단절점이라 한다.
 - 단절선(bridge) : 해당 간선을 제거하였을 때, 그 간선이 포함된 그래프가 2개 이상으로 나뉘는 경우, 이 정점을 단절선이라 한다.
 이 단절점과 단절선을 우리는 트리(tree)에서 구하려고 한다. 그래프 이론에서 트리(tree)의 정의는 다음과 같다.
 트리(tree) : 사이클이 존재하지 않으며, 모든 정점이 연결되어 있는 그래프 / 트리의 정보와 질의가 주어질 때, 질의에 대한 답을 하시오.
 프로그램의 입력은 표준 입력으로 받는다. 입력의 첫 줄에는 트리의 정점 개수 N이 주어진다. (2 ≤ N ≤ 100,000) 트리의 정점은 1번부터 n번까지 존재한다. 
 다음 줄부터 N-1개의 줄에 걸쳐 간선의 정보 a, b가 주어진다. 이는 a정점과 b정점이 연결되어 있다는 뜻이며, 
 입력으로 주어지는 정보는 트리임이 보장된다.(1 ≤ a, b ≤ N) / 다음 줄에는 질의의 개수 q가 주어진다. (1 ≤ q ≤ 100,000) 
 다음 q줄에는 질의 t k가 주어진다. (1 ≤ t ≤ 2) t가 1일 때는 k번 정점이 단절점인지에 대한 질의, 
 t가 2일 때는 입력에서 주어지는 k번째 간선이 단절선인지에 대한 질의이다. t가 1일 때는 (1 ≤ k ≤ n)이며, t가 2일 때는 (1 ≤ k ≤ n - 1)이다.
 
 없애려는 정점이 하나만 이어져 있으면? '트리'에서는 없애려는 정점이 리프노드(단말노드)가 아닌 이상 모두 단절점이 되는게 아닌가? <- 얘도 포함되네
 1) 아 그냥 인접 정점 개수만 카운트 해도 될듯? 없애려는 정점의 인접 정점 개수가 1개면 무조건 단절점이 될 수 없음
 2) 그리고 모든 선이 단절선인거 아님? 
 
 ---------
 
 🔥 "그래프가 아니라 트리다",, 아래는 그래프 컴포넌트 측면에서의 단절점과 단절선 찾기 알고리즘임,, 이 문제는 '트리'임!!
 단절점 단절선 한 4년전에 들었던거 같은데 전혀 기억이 안남 ㅋㅋ
 - 우리는 어떤 정점 A에 연결된 모든 정점들 중 두 정점들 간에 정점 A를 거치지않고 갈 수 있는 
   우회경로가 존재하지 않는 경우가 존재한다면 정점 A는 단절점으로 판단할 수 있습니다.
 - 우리는 이를 이용하여 DFS에서 탐색되는 순서대로 discover번호를 매겨주면서 아직 탐색이 안된경우  (스패닝 트리, 탐색 이용) 
   해당 정점에서 DFS를 탐색하여 나오는 정점 중 discover번호가 가장 적은 정점을 탐색이 된 경우는 
   그 정점의 discover 번호만 비교하면서 가장 작은 discover 번호가 나의 discover 번호보다 크거나 같다면 그 정점은 단절점이 됩니다.
 이렇게 판별할 경우 예외로 처리해줘야 할 케이스가 있는데 그 경우는  루트가 되는 정점의 케이스입니다.
 // 단절점 https://www.acmicpc.net/problem/11266
 // 단절선 https://www.acmicpc.net/problem/11400
 // https://jason9319.tistory.com/119

 */
public class CutVertexBridge {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder SB = new StringBuilder();
		int N = Integer.parseInt(BR.readLine()); // 정점 개수 N, N - 1개의 줄에 걸쳐 간선의 정보 a, b
		int arr[] = new int[N];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer ST = new StringTokenizer(BR.readLine(), " ");
			arr[Integer.parseInt(ST.nextToken()) - 1]++; // 정점을 이어줄 필요도 없이 각 정점에 노드 개수만 ++ 
			arr[Integer.parseInt(ST.nextToken()) - 1]++;
		} // for 
		
		int Q = Integer.parseInt(BR.readLine()); // 질의의 개수 q, 
		// t가 1일 때는 k번 정점이 단절점인지에 대한 질의, t가 2일 때는 입력에서 주어지는 k번째 간선이 단절선인지에 대한 질의
		for (int i = 0; i < Q; i++) {
			StringTokenizer ST = new StringTokenizer(BR.readLine(), " ");
			if(ST.nextToken().equals("1") && arr[Integer.parseInt(ST.nextToken()) - 1] == 1) SB.append("no\n");
			else SB.append("yes\n");
		} // for
		System.out.println(SB);
	}
}
