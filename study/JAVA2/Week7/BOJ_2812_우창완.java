import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2812_��â�� {
	//ó���� ������ ������� ��� ��Ҹ� �ְ� sort�� ������ x �����ٲٸ� �ȵȴ�
	//int �� ������ �����ڿ� k��° ���� �������� k��°���� ū���ڸ� ó�� x �ڸ����� 50���̶� int�� ������ �Ƶ��� �Ѿ��
	//arraylist�� array�� ����Ϸ��� �غ����� ������ ��Ҹ� ���ϰ�, ���԰� ������ ������ �ڷᱸ���� �����ϴٰ� �Ǵ�
	//�ð����⵵�� ���ؼ��� �־��� ��� o(n^2)�� ���������� ������ �����̵�� �ذ�x
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
		//�� print(deque.getlast�� �ݺ��� ������ �ȵɱ�?
		StringBuilder ans = new StringBuilder();
        while (dq.size() > k) {
            ans.append(dq.removeFirst());
        }
        System.out.println(ans);
	}
}
