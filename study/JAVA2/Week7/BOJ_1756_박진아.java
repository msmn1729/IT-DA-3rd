package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * FI
 * N: 피자 수 
 * 첫번째 피자의 깊이
 * 
 * oven[1] == 최상단 
 * oven[d] == 최하단 == D 
 * 
 * D, N
 * 오븐의 지름 
 * 피자 지름
 * 
 * 흠 왜 이탐색이지 
 * 이중포문하면 ... 시간초과인데 어카면 되지 
 * 메모제이션하면 되는데 
 * 
 * 아 문제를 잘못이해함  
 * 
 * (최소값)2 ~ 최대값(5)
 * (오븐) 5 6 4 3 6 2 3
 * (피자)   5   2 3 
 * 
 * 아 오븐의 중앙값을 기준으로 피자를 넣을수 있는지 없는지 확인하면(이진탐색)
 * 풀수있을거같은데 시간이 없네... 
 * 죄송합니다 부장님    
 * 
 */
public class Q1756 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] =br.readLine().split(" ");
		int D = Integer.parseInt(input[0]); int n= Integer.parseInt(input[1]);
		input =br.readLine().split(" ");
		int ovenarr[] = new int[D];for(int i=0;i<D;i++) {ovenarr[i]=Integer.parseInt(input[i]);}
		input =br.readLine().split(" ");
		int pizzaarr[] = new int[n];for(int i=0;i<n;i++) {pizzaarr[i]=Integer.parseInt(input[i]);}
		
		
		int rs[] = new int[300001];
		int index=0;
		boolean Ok=false;
		
		
		for(int i=D-1;i>=0;i--) {
			//i는 오븐 맨 마지막 
			System.out.println(ovenarr[i]);			
			
			if(index>=n) {break;}
			int pizza = pizzaarr[index];
			if(ovenarr[i]>pizza) {
				rs[i]=1;
				System.out.println("오븐"+i+"\t"+"오븐넓"+ovenarr[i]+"\t"+"잪ㅈ크"+pizza);
				i=i-1;
				index+=1;
			}else continue;
		}
		
		
		
	}

}
