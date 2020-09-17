import java.util.*;

public class Main{
	
	static int N;
	static ArrayList<Integer> Answer = new ArrayList<>();
	static int arr[];

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		
		//arr = new int [(int) Math.pow(10, N)];
		arr = new int [8 * (int) Math.pow(10, N-1)];
		System.out.println(arr.length);
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i < Math.sqrt(arr.length); i++) {
			
			if(arr[i] == 0)
				continue;
			
			for(int j = i+i; j < arr.length; j+=i) {
				arr[j] = 0;
			}
			
		}
		
		
		dfs(0, 0);
		
		Collections.sort(Answer);
		
		for(int a = 0; a < Answer.size(); a++) 
			System.out.println(Answer.get(a));
	}

	public static void dfs(int i, int n) { // 숫자, 카운트
		
		if(n == N) { // 자리수를 다 채웠으면
			Answer.add(i);
			return;
		}
		
		String string_i = Integer.toString(i);
		String tmp_string = "";
		int tmp_int = 0;
		
		for(int df = 1; df <= 9; df++) {
			String string_df = Integer.toString(df);
			
			tmp_string = string_i + string_df;
			
			tmp_int = Integer.parseInt(tmp_string);
			
			if(arr[tmp_int] != 0) { // 소수라면
				dfs(tmp_int, n+1);
			}
		}
		
	}

}
