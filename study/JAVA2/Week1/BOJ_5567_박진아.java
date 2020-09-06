import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
/*
 * 결혼식에 초대할 사람의 수를 구하는 프로그램
 * 첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)
 * 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)
 * 다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계
6
5
1 2
1 3
3 4
2 3
4 5
 * 쌍방관계 (양방향) 
 * 자신의 친구
 * 친구의 친구 
 *
 * 깊이탐색으로 풀면 될듯
 * 
 */
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine()); // 동기 수 
	int m = Integer.parseInt(br.readLine()); // 리스트 길이 
	int marr[][] = new int [n+1][n+1];
	
	
	String input[]; int a=0,b=0;
	for(int i=1;i<m+1;i++) {
		input=br.readLine().split(" ");
		a=Integer.parseInt(input[0]); b=Integer.parseInt(input[1]);
		marr[a][b] = marr[b][a] = 1;
	}
	
	
	int count = 0;
	int check[] = new int[n+1]; // 초대한 친구를 체크하는 리스트
	for(int i=1;i<n+1;i++) {
		for(int j=1;j<n+1;j++) {
			if(marr[1][j]==1) { // 친구일때 
				int friend = j;
				check[1]=1; check[friend] =1;
				for(int k=1;k<n+1;k++) { // 친구의 친구일때 
					if(marr[friend][k]==1 && check[k] != 1) {
						check[k]=1;
					}
				}
			}
		}
	}
    for(int k=1;k<n+1;k++) {if(check[k]==1) count++; }
    System.out.println(count -1); //체크리스트에 자신을 제외! 
    }
}