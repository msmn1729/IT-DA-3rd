package waterbottle2251;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 부피가 A,B,C(1<=A,B,C<=200)리터
 * 처음 앞의 두 물통은 비어있다. 
 * 세번째 물통은 가득(C리터)차 있다.
 * 물을 다른 물통으로 쏟아 부을 수 있는데 
 * 조건) 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지
 * 결과) A물통이 비어 있을 때, C물통에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램*/
public class WaterBottle {
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		int[] amount = new int[3];	//A,B,C의 부피를 담는 배열 amount
		for(int t=0;t<3;t++) {
			amount[t]=sc.nextInt();
		}
//		A,B,C의 부피가 200인데 인덱스 값을 사용하므로 200까지 나타내려고 각각 크기를 201로 했다.
		boolean[][] visited = new boolean[201][201];	
	    boolean[] answer = new boolean[201];	
		Queue<Pair> q = new LinkedList<>();
	    int []from = {0,0,1,1,2,2};
		int []to = {1,2,0,2,0,1};
		
		q.add(new Pair(0,0));
		visited[0][0]=true;
		answer[amount[2]] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y=p.y;
			int z = amount[2]-x-y;
			
			for (int i = 0; i < to.length; i++) {
				int[] next = {x,y,z};
				next[to[i]] += next[from[i]];		
				next[from[i]]=0;
				
				if(next[to[i]]>amount[to[i]]) {
					next[from[i]] +=next[to[i]]-amount[to[i]];
					next[to[i]]= amount[to[i]];
				}
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]]=true;
					q.add(new Pair(next[0],next[1]));
					if(next[0]==0) {
						answer[next[2]]=true;						
					}
				}
			}
		}
		for(int j=0;j<=amount[2];j++) {
			if(answer[j]) {
				System.out.print(j+" ");
			}
		}
	}
}
class Pair{
	int x,y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}