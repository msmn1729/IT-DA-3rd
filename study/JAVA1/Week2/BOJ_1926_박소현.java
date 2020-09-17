package itda_2020;

import java.io.*;
import java.util.*;

public class BOJ_1926_박소현 {
	
	static boolean[][] visited ;
	static int[][] Map;
	static int N,M;
	static int MAX = 0;
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in); 
		N = scan.nextInt();
		M = scan.nextInt();
		visited = new boolean[501][501];
		Map = new int[501][501];
		
		for(int i = 0; i<N; i++) {
			for (int j = 0; j < M ; j++) {
				Map[i][j] = scan.nextInt();
			}
		}
		
		for(int i = 0; i<N; i++) {
			for (int j = 0; j < M ; j++) {
				if (!visited[i][j]) {
					checkMap(i,j);
				}
			}
		}
		
		
		System.out.println(count);
		System.out.println(MAX);
	}

	static void checkMap(int x, int y) {
		if(Map[x][y]==0) {
			visited[x][y]= true;
			return ;
		}
		else {
			bfs(x,y);
			visited[x][y]= true;
			return ;
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q= new LinkedList<>();
		
		q.add(new Node(x,y,1));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x][node.y]= true;
		
		if (node.y-1 >= 0 && node.y-1 < M && Map[node.x][node.y-1]==1 && visited[node.x][node.y-1]==false) {
			q.add(new Node(node.x, node.y-1,node.depth+1));
		}
		
		else if (node.y+1 >= 0 && node.y+1 < M && Map[node.x][node.y+1]==1 && visited[node.x][node.y+1]==false) {
			q.add(new Node(node.x, node.y+1,node.depth+1));
		}
		
		else if (node.x-1 >= 0 && node.x-1 < N && Map[node.x-1][node.y]==1 && visited[node.x-1][node.y]==false) {
			q.add(new Node(node.x-1, node.y,node.depth+1));
		}
		
		else if (node.x+1 >= 0 && node.x+1 < N && Map[node.x+1][node.y]==1 && visited[node.x+1][node.y]==false) {
			q.add(new Node(node.x+1, node.y,node.depth+1));
		}
		
		else {
			if (MAX <= node.depth) {
				MAX = node.depth;
			}
			count ++; 
			return ;
		}
		
		}
		
		
		
		}
		
		
	}
	
	class Node{
	    int x;
	    int y;
	    int depth;

	    Node(int _x, int _y, int _depth){
	        this.x = _x;
	        this.y = _y;
	        this.depth = _depth;
	    }
}
