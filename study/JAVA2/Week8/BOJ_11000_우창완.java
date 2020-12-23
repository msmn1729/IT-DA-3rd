import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11000_¿ìÃ¢¿Ï {
	static class Pair{
		int start;
		int end;
		Pair(int start, int end){
			this.start=start;
			this.end=end;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Pair> li= new ArrayList<>();
		Queue<Pair> q=new LinkedList<>();
		for(int i=0; i<n; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			li.add(new Pair(start,end));
		}
		Collections.sort(li, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.end> o2.end) return 1;
				else if(o1.end==o2.end) return 0;
				else return -1;
			}
		});

		int cnt=1;
		int answer=1;
		q.add(new Pair(li.get(0).start, li.get(0).end));
		//System.out.println(li.get(n-1).end);
		for(int i=1; i<n; i++) {
			//System.out.println(q.peek().end);
			if(q.peek().end>li.get(i).start) {
				cnt++;	
				q.add(new Pair(li.get(i).start, li.get(i).end));
				answer=Math.max(answer, cnt);
			}	
			else {
				while(q.peek().end<=li.get(i).start&&!q.isEmpty()) {
					cnt--;
					q.remove();
				}
			}
		}
		System.out.println(answer);
	}

}
