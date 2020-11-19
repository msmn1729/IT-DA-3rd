import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2812_우창완 {
	//처음에 순서에 상관없이 모든 요소를 넣고 sort로 정렬함 x 순서바꾸면 안된다
	//int 로 정수를 받은뒤에 k번째 수를 기준으로 k번째보다 큰숫자만 처리 x 자릿수가 50만이라 int의 범위를 아득히 넘어간다
	//arraylist와 array를 사용하려고 해봤으나 마지막 요소를 비교하고, 삽입과 삭제가 용이한 자료구조가 적절하다고 판단
	//시간복잡도에 관해서는 최악의 경우 o(n^2)을 접근하지는 않을지 걱정이든다 해결x
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		String a=sc.next();
		Deque<Character> dq=new ArrayDeque<Character>();
		for(int i=0; i<a.length(); i++) {
			while(k>0&&!dq.isEmpty()&&dq.getLast()<a.charAt(i)) {
				dq.removeLast();
				k--;
			}
			dq.addLast(a.charAt(i));
		}
		//왜 print(deque.getlast로 반복문 돌리면 안될까?
		StringBuilder ans = new StringBuilder();
        while (dq.size() > k) {
            ans.append(dq.removeFirst());
        }
        System.out.println(ans);
	}
}
