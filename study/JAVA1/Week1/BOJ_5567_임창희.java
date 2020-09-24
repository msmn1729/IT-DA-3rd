package marry5567;
/*
 * 	1은 상근이 이다.
 * 입력 : 상근이의 동기의 수 n(2<=n<=500)
 * 			리스트의 길이 m (1<=m<=10000)
 * 			m개 줄에는 친구관계 a(i)b(i) (1<=a(i)<b(i)<=n)
 * 			a(i)와 b(i)가 친구라는 뜻이다.*/


import java.util.*;
import java.util.Scanner;

public class Marry {
	static int n,m,count;
	static String[] list;
	static boolean[] clist;
	static int[][] arr;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		n=sc.nextInt();

		m = sc.nextInt();
		
		list =new String[m];
		

		sc.nextLine();
		for(int i =0;i<list.length;i++) {
			list[i]=sc.nextLine();	
		}
		String[][] nlist =new String[m][2];
		int[][] klist =new int[m][2];
		clist = new boolean[m];
		
		for(int j =0; j<m;j++) {
			nlist[j]=list[j].split(" ");
			for(int k=0;k<nlist[0].length;k++) {
				klist[j][k]= Integer.parseInt(nlist[j][k]);
			}
		}
		friend(klist,clist);
	}
	static void friend(int[][] nlist, boolean[] clist){
		ArrayList<Integer> my_friend = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int friend_n;
		for(int i=0;i<nlist.length;i++) {
			if(nlist[i][0]==1 && clist[i]==false) {
				my_friend.add(nlist[i][1]);
				clist[i]=true;
			}else if(nlist[i][1]==1 && clist[i]==false) {
				my_friend.add(nlist[i][0]);
				clist[i]=true;
			}
		}
		friend_n=my_friend.size();
		
		for(int j=0;j<friend_n;j++) {
			for(int i=0;i<nlist.length;i++) {
				if(nlist[i][0]==my_friend.get(j) && clist[i]==false) {
					my_friend.add(nlist[i][1]);
					clist[i]=true;
				}else if(nlist[i][1]==my_friend.get(j) && clist[i]==false) {
					my_friend.add(nlist[i][0]);
					clist[i]=true;
				}
			}
		}
		
		for(int k=0;k<my_friend.size();k++) {
			if(!(result.contains(my_friend.get(k)))) {
				result.add(my_friend.get(k));
			}
		}
		System.out.println(result.size());
		
	}
}

