package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * 태스트 케이스 T 
 * 지원자의 수 N
 * 
 * 1차 서류, 면접 순위 
 * 
 * 선발 최대 인원수 
 * 
3 2
1 4 <--
4 1 <-- 
2 3
5 5 <-- 탈락 





3 6 <-- 탈락  
7 3 <-- 탈락 
4 2
1 4 <-- 
5 7 <-- 탈락 
2 5 <-- 탈락 
6 1 <--


1 1
2 3
3 5
4 6 
 * 
 * 즉, 어떤 지원자 A의 성적이 
 * 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 
 * 모두 
 * 떨어진다면 
 * A는 결코 선발되지 않는다.
 * 
 * 두 부류 다 1등하면 1명입사 
 * 
 * 탈락 기준:
 * 1)서류 1등한 사람
 *  면접 점수 낮은사람 다 탈락 
 * 2)면접 1등한 사람 
 *  서류 점수 낮은사람 다 탈락 
 * 
 * 
 * 
 * 
 * 2차배열..? 
 * 
 * 100000명 
 * 
 * fireWithResume -> fireWithInterview  for문 하면 시간초과 나는데 ................. 
 * 
 * 
 * 
 * 자료구조를 ... 
 * ArrayList 
 * apply[1]= (서류점수, 인터뷰점수) 
 * 
 * 
 * 
 */


public class Q1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			
			int resume[] = new int[100001];
			int interview[] = new int[100001];
			
			
			int resume1 =0;
			int interview1=0;
			
			for(int j=0;j<n;j++) {
				String input[] = br.readLine().split(" ");
				resume[j]=Integer.parseInt(input[0]);
				interview[j]=Integer.parseInt(input[1]);
				if(resume[j]==1) resume1=j;
				if(interview[j]==1) interview1=j;
			}
			//j는 사원이름 
			//서류: 3 1 4 2 5 -> 지원자 정보를 같이 저장후 sort하면 되지않을까 
			//면접: 2 4 1 3 5 
			
			fireWithResume(resume, interview, resume1);
			fireWithInterview(resume, interview, interview1);
		}
		
	}

	private static void fireWithInterview(int[] resume, int[] interview, int interview1) {
		
		
	}

	private static void fireWithResume(int[] resume, int[] interview, int resume1) {
		// 인터뷰 점수 낮은사람 아웃 
		int data = interview[resume1];
		for(int i=0;i<interview.length;i++) {
			
		}
	}
}
