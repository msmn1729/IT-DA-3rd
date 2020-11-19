package q2812;

import java.util.Scanner;
import java.util.Stack;

public class MakeBig {
	static int N;
	static int K;
	static String number;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		number = sc.next();
		
		Stack<Character> stack = new Stack<Character>();
		stack.push(number.charAt(0));
//		
		int cnt = 0;
		
		for(int i= 1;i<number.length();i++) {
			char ch = number.charAt(i);
			while(!stack.isEmpty()) {
				if(cnt ==K) {
					break;
				}
				
				if(stack.peek() < ch) {
					stack.pop();
					cnt++;
				}else if(stack.peek()>=ch) {
					break;
				}
			}
			stack.push(ch);
		}
		StringBuilder sb = new StringBuilder();
		if(cnt <K) {
			int gap = K-cnt;
			for(int i=0;i<stack.size()-gap;i++) {
				sb.append(stack.get(i));
			}
		}else {
			for(int i=0;i<stack.size();i++) {
				sb.append(stack.get(i));
			}
		}
		System.out.println(sb.toString());
	}
}
