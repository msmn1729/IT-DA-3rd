package backjoon.study.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 폭발 https://www.acmicpc.net/problem/9935
/*
 상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.
 폭발은 다음과 같은 과정으로 진행된다.
 1. 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
 2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
 3. 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
 상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다.
 첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.
 둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.
 두 문자열은 모두 "알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만" 이루어져 있다.
 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
 
 100만 최대 길이다. 없애고 붙이고 없애고 붙이고를 반복하기엔 100만에서 2개 모두 반복이라 했을때 시간초과 당연히 날듯 
 그래서 contains 같은 함수로 substring을 반복하는 경우는 절대 X / for한번으로 쑈부봐야한다 
 한 번 전체 탐색을 하면서 같은 부분이 시작되는 Index를 계속해서 기억해나가면서 그 반복되는 횟수만큼만 substring을 한다면?
 그럴 필요 없이 char arr를 이용하면 substring쓸 필요가 없다! / 근데 그 index덩어리들이 존나 헷갈린다 
 
 - 덩어리 만큼 스택에 쌓으면서 push / pop (top or peek) 비교가 완탐 다음으로 쉽게 비교 가능한 방법인 것 같다 
 */

public class ExplosionOfString {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String origin = BR.readLine();
		String bomb = BR.readLine();
		String answer = solution(origin, bomb); 
		System.out.println((answer.length() == 0) ? "FRULA" : answer);
	}
	
	private static String solution(String origin, String bomb) { 
		char[] tempTarget = new char[origin.length()]; 
		int idx = 0; 
		for (int i = 0; i < origin.length(); i++) { 
			tempTarget[idx] = origin.charAt(i); // tempTarget에 일단 그대로 옮기고 
			if (isBomb(tempTarget, idx, bomb)) idx -= bomb.length(); // bomb이 되는지 안되는지 체크
			idx++; 
		} 
		// System.out.println(String.valueOf(tempTarget, 0, idx));
		return String.valueOf(tempTarget, 0, idx); 
	} 
	
	private static boolean isBomb(char[] tempTarget, int idx, String bomb) { 
		if (idx < bomb.length() - 1) return false; // 길이 부터 다르면 볼 필요도 음따  
		for (int i = 0; i < bomb.length(); i++) { 
			if (bomb.charAt(i) != tempTarget[idx - bomb.length() + 1 + i]) return false; 
		} 
		return true; 
	}
}
