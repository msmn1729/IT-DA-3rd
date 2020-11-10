import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CallingNumber {
	
	public static void main(String[] args) throws IOException {
		// 접두어가 되면 전화를 걸 수 없드아..
		// Trie 알고리즘인데 이렇게는 못풀겠음..
		// String 메소드인 startsWith사용
		// sort를 해야하더라..
		int t;
		int n;
		boolean sw;
		
		ArrayList<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			sw = true;
			n = Integer.parseInt(br.readLine());
			for(int j = 0; j < n; j++) {
				list.add(br.readLine());
			}
			Collections.sort(list);
			for(int j = 1; j < list.size(); j++) {
				if(list.get(j).startsWith(list.get(j - 1))) {
					sw = false;
					break;
				}
			}
			list.clear();
			if(sw == false) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
		
	}

}
