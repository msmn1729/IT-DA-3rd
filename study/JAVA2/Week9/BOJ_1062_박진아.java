package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
anta	rc	tica
anta	hello	tica
anta	car	tica


a n t i <- 필수로 배움

r c
h e l o <- 못배움
c a r 

dfs로 하면 될거같은데....
모르겠어 

 */
public class Q1062 {
	
	static int rs=-1;
	static int k=0;
	static boolean visited[] = new boolean [27];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		k =Integer.parseInt(input[1]);
		
		if(k<5) {
			System.out.println(0);
			return;
		}
		else {
			String[] word = new String[n];
			visited['a'-97]=true; visited['n'-97]=true; visited['t'-97]=true; visited['i'-97]=true; visited['c'-97]=true;
			int cnt = 5;

			for(int i=0;i<n;i++) {
				String w = br.readLine();
				w.replace("a", "");
				w.replace("n", "");
				w.replace("t", "");
				w.replace("i", "");
				w.replace("c", "");
				word[i]=w;
			}
			DFS(0,0);
		}	
	}

	private static void DFS(int w, int cnt) {
		if(k==cnt) {
			rs=Math.max(rs, 0);
		}
	}
	
}
