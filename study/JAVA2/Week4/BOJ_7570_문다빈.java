import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Line { 
	public static void main(String[] args) throws IOException {
		//LIS 문제
		//오름 차순 정렬 된 부분 수열은 건드리 지않고 해야 최소의 경우가 나옴!
		//즉 연속적인 LIS의 특징을 만족하는 원소들을 제외한 나머지 원소의 개수만큼 이동이 발생
		//즉 최대길이를 가지는 연속 된 LSI의 원소 개수를 구하면 됌.
		int child[];
		int max = 0;
		int a;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		child = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			a = Integer.parseInt(st.nextToken());
			child[a] = child[a-1] + 1;//이전 번호를 가진 아이가 있다면 합산해서
			max = Math.max(child[a], max);
		}
		System.out.println(n - max);
	}
}
