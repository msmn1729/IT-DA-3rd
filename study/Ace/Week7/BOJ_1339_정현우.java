package backjoon.study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 단어 수학 https://www.acmicpc.net/problem/1339
/*
 민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.
 단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 
 이때, 각 알파벳 대문자를 "0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제"이다. 
 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.
 예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 
 두 수의 합은 99437이 되어서 최대가 될 것이다. / N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.
 첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 
 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 "최대 길이는 8"이다. 
 서로 다른 문자는 서로 다른 숫자를 나타낸다.
 
 "가장 긴 문자열"에서 "큰 자리수 알파벳"을 "가장 큰 숫자로" 바꾼다면? 진짜 존나 어렵게 풀었는데 런타임 에러다 
 1) 알파벳 obj만들어서 data와 length를 가지고
 2) 항상 가장 긴 문자열 중에서 가장 큰 자리수 알파벳을 찾으면서 (sort) 
 3) 그 값 -65 으로 index로하는 알파벳 매칭 26사이즈 배열 값에 nowMax(지금 할당할 수 있는 가장 큰 숫자)를 넣어준다
 4) 그리고 결과를 더해준다. 
 => 문자가 가장 긴게 8개라서, 그리고 N이 10이라서 이런 개뻘짓도 가능하다 
 근데 가정부터 틀렸다. 10 / ABB BB BB ---- BB 경우 B에 9 A에 8이 들어가야한다. 무작정 가장 긴 문자열 가장 큰 자리수가 아니라는 
 아니 그럼 단순한 그냥 그리디가 아니잖아 미르틴~  
 
 자리수 맞추기.. '알파벳 별 자리수' -> 주어진 자리 수의 값들을 전부 더하고, 가장 자리수가 큰 알파벳부터 높은 숫자를 순차적으로 부여
 */
public class MathOfWord {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(BR.readLine());
		int alphaValues[] = new int[26];
		int nowMax = 9;
		for (int i = 0; i < N; i++) {
			char[] temp = BR.readLine().toCharArray();
			int pos = (int) Math.pow(10, temp.length - 1); // 최대 자릿수 계산 
			for (int j = 0; j < temp.length; j++) {
				alphaValues[temp[j] - 'A'] += pos; // 자릿수 계산 누적합으로 
				pos /= 10; // 다음 자릿수로 
			}
		}
		
		int answer = 0;
		Arrays.sort(alphaValues);
		for (int i = alphaValues.length - 1; i > -1; i--) { // 가장 큰놈 부터 접근 
			if (nowMax == 0) break;
			answer += alphaValues[i] * nowMax--;
		}
		System.out.println(answer);
		// System.out.println(Arrays.toString(alphaValues));
	}

	/*
	static class Alpha implements Comparable<Alpha> {
		String data;
		int nowLen;
		Alpha(String data, int nowLen) {
			this.data = data;
			this.nowLen = nowLen;
		}
		public void setNowLen(int setNumber) { this.nowLen = setNumber; }
		
		@Override
		public int compareTo(Alpha o) {
			// TODO Auto-generated method stub
			return o.nowLen - this.nowLen;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(BR.readLine());
		int alphaValues[] = new int[26];
		
		int howMany = 0; // sort 포함한 본체 솔루션 for문 횟수 정하기 위해서! 
		Alpha alpha[] = new Alpha[N];
		for (int i = 0; i < N; i++) {
			String temp = BR.readLine();
			alpha[i] = new Alpha(temp, temp.length());
			howMany += temp.length();
		}
		
		int nowMax = 9;
		for (int i = 0; i < howMany; i++) {
			Arrays.sort(alpha);
			int targetIndex = alpha[0].data.charAt(alpha[0].data.length() - alpha[0].nowLen) - 65;
			if(alphaValues[targetIndex] == 0) {
				alphaValues[targetIndex] = nowMax;
				nowMax--;
			}
			alpha[0].setNowLen(alpha[0].nowLen - 1);	
		}
		
		System.out.println(Arrays.toString(alphaValues));
		
		int answer = 0;
		for (Alpha alp : alpha) {
			StringBuilder SB = new StringBuilder();
			for (int i = 0; i < alp.data.length(); i++) SB.append(alphaValues[alp.data.charAt(i) - 65]);
			answer += Integer.parseInt(SB.toString());
		}
		System.out.println(answer);
	}
	*/
}
