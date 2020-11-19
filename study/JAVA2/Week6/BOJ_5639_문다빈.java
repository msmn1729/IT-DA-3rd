import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BinarySearch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 이진트리이다
		// 왼쪽이 무조건 오른족보다 작아야함.
		String s;
		int n;
		int prev = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		s = br.readLine();
		list.add(Integer.parseInt(s));
		prev = list.get(0);
		
		while(s != null) {
			s = br.readLine();
			n = Integer.parseInt(s);
			for(int i = 0; i < list.size(); i++) {
				
			}
			if(prev < n) {
				list.add((2 * n) + 1, n);
			}
			else {
				list.add((2 * n) + 2, n);
			}
			prev = n;
			s = br.readLine();
		}		
	}
}
