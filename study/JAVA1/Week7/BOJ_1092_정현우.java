package backjoon.study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 
/*
 지민이는 항구에서 일한다. 그리고 화물을 배에 실어야 한다. 모든 화물은 박스에 안에 넣어져 있다. 
 "항구에는 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다. 모든 크레인은 동시에" 움직인다.
 각 크레인은 무게 제한이 있다. 이 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다. 
 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하는 프로그램을 작성하시오.
 첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 각 크레인의 무게 제한이 주어진다. 
 이 값은 1,000,000보다 작거나 같다. 셋째 줄에는 박스의 수 M이 주어진다. M은 10,000보다 작거나 같은 자연수이다. 
 넷째 줄에는 각 박스의 무게가 주어진다. 이 값도 1,000,000보다 작거나 같은 자연수이다.
 첫째 줄에 모든 박스를 배로 옮기는데 드는 "시간의 최솟값"을 출력한다. 만약 모든 박스를 배로 옮길 수 없으면 -1을 출력한다.
 
 "무게 제한 큰놈이 가장 큰걸" 옮기게 한다면?? 쓸모없는 비용 발생 가능성 (뮤탈리스크 문제 상황 처럼) / 그럼 dp 개념이 필요한가?
 지금 옮겨야하는 무게와 가장 가까운 무게제한을 가진 크레인을 계속해서 사용한다면? 부르트 포스,, 시간초과 삘인디 
 가장 무거운 것을 옮길 수 있는 크레인부터 => 가장 가벼운 것을 옮길 수 있는 크레인까지 차례대로 분배한다. 
 */
public class Ship {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(BR.readLine());
		Integer[] weightLimit = new Integer[N];
		StringTokenizer ST = new StringTokenizer(BR.readLine(), " "); // N 개 -> 크레인 무게 제한!
		for (int i = 0; i < N; i++) weightLimit[i] = Integer.parseInt(ST.nextToken());
		Arrays.sort(weightLimit, Comparator.reverseOrder());
		
		int M = Integer.parseInt(BR.readLine());
		ArrayList<Integer> weightBox = new ArrayList<>();
		ST = new StringTokenizer(BR.readLine(), " "); // M 개 -> 각 박스 무게!  
		for (int i = 0; i < M; i++) weightBox.add(Integer.parseInt(ST.nextToken()));
		Collections.sort(weightBox, Collections.reverseOrder());
		
		//////////////////////////////////////////////////////////////////////////// 
		
		if (weightLimit[0] < weightBox.get(0)) System.out.println(-1);
		else { // 그 외의 경우
			int answer = 0;
			while (!weightBox.isEmpty()) { // 상자의 갯수가 0이 되기 전까지 반복
				int howMany = 0; // 크레인의 순서
				for (int i = 0; i < weightBox.size(); i++) {
					if (howMany == weightLimit.length) break; // 다 순회하여 박스를 담을 수 없는 경우 탈출
					if (weightLimit[howMany] >= weightBox.get(i)) { // 크레인이 들 수 있는 무게를 확인
						weightBox.remove(i); 
						howMany++; i--;
					}
				}
				answer++; //옮긴 시간
			} // while 
			System.out.println(answer);
		} // if ~ else 
	}
}
