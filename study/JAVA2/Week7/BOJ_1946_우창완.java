import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1946__��â�� {
	public static class Pair{
		//x resume y interv
		int x;
		int y;
		Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		ArrayList<Pair> li=new ArrayList<>();
		for(int i=0; i<t; i++) {
			int n= sc.nextInt();
			li.clear();
			for(int j=0; j<n; j++) {
				int resume=sc.nextInt();
				int interv=sc.nextInt();
				li.add(new Pair(resume,interv));
			}
			//resume������ ���� sort
			Collections.sort(li, new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					if(o1.x>o2.x) return 1;
					else return -1;
				}
			});
			int min=li.get(0).y;
			int cnt=0;
			//resume�� ���ĵǾ� �����Ƿ� interview�� min���� ������ ���������� interview������ �����ش�.
			for(int j=1; j<n; j++) {
				if(min<li.get(j).y) cnt++;
				min=Math.min(min, li.get(j).y);
			}
			System.out.println(n-cnt);
		}
	}

}
