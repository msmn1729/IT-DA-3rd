import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		Stack<Integer> stack = new Stack<>();
		
		String [] temp = br.readLine().split("");
		int [] arr = new int [N];
		
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(temp[i]);
		
		stack.push(arr[0]);
		
		int count = 0;
		
		for(int i=1; i<N; i++) {
			while (count < K && !stack.isEmpty() && stack.peek() < arr[i]) {
				stack.pop();
				count++;
			}
			stack.push(arr[i]);
	    }
		
		for(int i=0; i<N-K; i++) System.out.print(stack.get(i));
	}
}
