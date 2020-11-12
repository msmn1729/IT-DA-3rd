import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//BFS를 이용해서 노드의 깊이로 풀수 있지 않을까?
	static int[][] arr;
	static boolean [] check;
	static int depth;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			depth=0;
			n=sc.nextInt();
			m=sc.nextInt();
			check=new boolean[n+1];
			arr=new int[n+1][n+1];
			for(int j=0; j<m; j++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				arr[x][y]=1;
				arr[y][x]=1;
			}
			System.out.println(BFS()-1);
		}

	}

	private static int BFS() {
		Queue<Integer> q=new LinkedList<>();
		q.add(1);
		check[1]=true;
		while(!q.isEmpty()) {
			depth++;
			int x= q.poll();
			for(int i=1; i<=n; i++) {
				if(!check[i]&&arr[x][i]==1) {
					q.add(i);
					check[i]=true;
				}
			}
		}
		return depth;
	}

}
