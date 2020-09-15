import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Collections;

public class BOJ_2251_김영민 {

	static int A, B, C;
	static Queue<Node> q = new LinkedList<>();
	static boolean [][][] visited = new boolean[201][201][201];
	static ArrayList<Integer> answer = new ArrayList<Integer>();
	
	static class Node {
		int a,b,c;
		Node(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		q.add(new Node(0,0,C));
		bfs();
		
		Collections.sort(answer);
		
		for(int i : answer) System.out.print(i+" ");
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node now = q.poll();
			int a = now.a;
			int b = now.b;
			int c = now.c;
			
			if(visited[a][b][c]) continue;
			
			visited[a][b][c] = true;
			if(a==0) answer.add(c);
			
			//물 옮기는 과정 생각하기
			//8 0 2 / 0 8 2 / 2 8 0 / 2 0 8 / 0 2 8
			//0 9 1 / 8 1 1 / 0 1 9
			
			//A에서 B로
			if(a+b<=B) q.add(new Node(0,a+b,c)); //한 물통이 비거나
			else q.add(new Node(a+b-B,B,c)); //다른 한 물통이 가득 찰 때
			//A에서 C로
			if(a+c<=C) q.add(new Node(0,b,a+c));
			else q.add(new Node(a+c-C,b,C));
			//B에서 A로
			if(b+a<=A) q.add(new Node(b+a,0,c));
			else q.add(new Node(A,b+a-A,c));
			//B에서 C로
			if(b+c<=C) q.add(new Node(a,0,b+c));
			else q.add(new Node(a,b+c-C,C));
			//C에서 A로
			if(c+a<=A) q.add(new Node(c+a,b,0));
			else q.add(new Node(A,b,c+a-A));
			//C에서 B로
			if(c+b<=B) q.add(new Node(a,c+b,0));
			else q.add(new Node(a,B,c+b-B));
		}
	}
}
