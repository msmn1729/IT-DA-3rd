import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 
 * 처음에는 앞의 두 물통은 비어 있고, 
 * 세 번째 물통은 가득(C 리터) 차 있다. 
 * 이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 
 * 이때에는 한 물통이 비거나, 
 * 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다. 
 * 이 과정에서 손실되는 물은 없다고 가정한다.
 * 
 * 이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 
 * 첫 번째 물통(용량이 A인)이 비어 있을 때, 
 * 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, C가 주어진다.
8 9 10

출력
첫째 줄에 공백으로 구분하여 답을 출력한다. 각 용량은 오름차순으로 정렬한다

[접근]
물 붓기 : 
1) 어떤 물통이 빔
2) 어떤 물통이 가득 찰 때가지 물을 부을 수 있음

A가 비어있을 때 C에 담긴 물의 양?


하노이 탑 같네 
모든 경우의 수를 탐색하고 조건에 맞는 결과값을 result에 저장

<a,b>
<a,c>
<b,a>
<b,c>
<c,a>
<c,b>
총 6가지 경우의 수 

[고민]
종료 조건을 어떻게 해야하지 
경우의 수 작성하는 방법을 몰라서 구글링 했음;;


 */
public class Q2251 {
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int A, B, C;
	static boolean[][][] visited = new boolean [201][201][201];
	static int cups[][][] = new int [201][201][201];
	static Queue<Cups> q = new LinkedList<Cups>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		A = Integer.parseInt(input[0]);
		B = Integer.parseInt(input[1]);
		C = Integer.parseInt(input[2]);
		
		// 현재 컵들에 담긴 양을 저장하는 Cups클래스 
		q.add(new Cups(0,0,C));
		
		while(!q.isEmpty()) {
			Cups curCups = q.poll();
            
            // 현재 컵들의 물의 양
			int curA = curCups.curA;
			int curB = curCups.curB;
			int curC = curCups.curC;
			
			if(visited[curA][curB][curC]) {
				continue;
			}
			
			if(curA==0) {
				result.add(curC);
			}
			
            visited[curA][curB][curC] =true;

             //A -> B            
			if(curB+curA<=B) { 
				q.add(new Cups(0,curA+curB,curC));
			}else {
				q.add(new Cups(curA+curB-B,B,curC));
            }
            //A -> C
			if(curC+curA<=C) {
                q.add(new Cups(0,curB,curC+curA));
            }
            else {
                q.add(new Cups(curA+curC-C,curB,C));
            }

            //B -> A
			if(curA+curB <= A) { 
				q.add(new Cups(curA+curB,0,curC));
			}else {
				q.add(new Cups(A,curB+curA-A,curC));
            }
            //B -> C
            if(curC+curB<=C) {
                q.add(new Cups(curA,0,curC+curB));
            }
            else {
                q.add(new Cups(curA,curB+curC-C,C));
            }

            //C -> A
			if(curA+curC<=A) {
				q.add(new Cups(curA+curC,curB,0));
			}
			else {
				q.add(new Cups(A,curB,curC+curA-A));
            }
            //C -> B
			if(curB+curC<=B) {
				q.add(new Cups(curA,curB+curC,0));
			}
			else {
				q.add(new Cups(curA,B,curC+curB-B));
            }
            
            
			
		}
		
		Collections.sort(result);
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i)+" ");
		}
	}
}

class Cups{
	
	public Cups(int curA, int curB, int curC) {
		this.curA=curA;
		this.curB=curB;
		this.curC=curC;
	}
	
	int curA;
	int curB;
	int curC;
}
