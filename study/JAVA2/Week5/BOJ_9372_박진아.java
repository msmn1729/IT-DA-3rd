package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  최대한 적은 종류의 비행기
 *  모든 국가들을 여행할 수 있도록 도와주자.
 *  상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
 *  
 *  첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,

각 테스트 케이스마다 다음과 같은 정보가 주어진다.

첫 번째 줄에는 
국가의 수 N(2 ≤ N ≤ 1 000)과 
비행기의 종류 M(1 ≤ M ≤ 10 000) 가 주어진다.

이후 M개의 줄에 a와 b 쌍들이 입력된다.
 a와 b를 왕복하는 비행기가 있다는 것을 의미한다. 
 (1 ≤ a, b ≤ n; a ≠ b) 
주어지는 비행 스케줄은 항상 
연결 그래프를 이룬다.
 
 * 엥 . . .
 */

public class Q9372 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N=0,M=0;
			String input[] = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M=Integer.parseInt(input[1]);
			
			for(int j=0;j<M;j++) {
				input=br.readLine().split(" ");
			}
			System.out.println(N-1);
			
		}
	}

}
