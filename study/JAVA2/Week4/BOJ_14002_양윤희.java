package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main11 {
	static int n, val[], lis[],parval[],paridx[];
	public static void main(String[] args) throws IOException {
		init();
		solve();
	}
	static void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		val = new int[n];
		lis = new int[n];
		parval = new int[n];
		paridx = new int[n];
		for (int i = 0; i < n; i++) {
			val[i] = Integer.valueOf(st.nextToken());
			lis[i] =1;
		}
	}
	static void solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(val[j] < val[i] && lis[i] == lis[j]) {
					lis[i]++;
					parval[i] = val[j];
					paridx[i] = j;
				}
			}
		}
		int maxidx=0;
		int max=0;
		for (int i = 0; i < lis.length; i++) {
			if(max < lis[i]) {
				max=lis[i];
				maxidx=i;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(val[maxidx]);
		int idx=maxidx;
		while(parval[idx]!=0) {
			list.add(parval[idx]);
			idx = paridx[idx];
		}
		Collections.sort(list);
		System.out.println(max);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}