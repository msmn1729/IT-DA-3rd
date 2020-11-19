package backjoon.study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 크게 만들기 https://www.acmicpc.net/problem/2812
/*
 N자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수를 구하는 프로그램
 첫째 줄에 N과 K가 주어진다. (1 ≤ K < N ≤ 500,000)
 둘째 줄에 N자리 숫자가 주어진다. 이 수는 0으로 시작하지 않는다.
 
 */
public class MakeBigger {
	public static void main(String args[]) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String number = br.readLine();
        Stack<Character> stack = new Stack<Character>();

        //////////////////////////////////////////////////////////////////
        
        // 선택 할 수 있는 개수, 자리수 만큼 for, 스택으로 큰 것만 선택한다! 
        int canCount = N - M;
        for(int i = 0; i < N; i++){
        	char num = number.charAt(i); // char to int
        	
        	while (!stack.isEmpty() && M > 0) {
            	if (num > stack.peek()) { // stack top값보다 index의 char가 더 클 경우
            		M--; // M = M - 1, 뺄거 1개 골랐으니까 
            		stack.pop();
            	} else break;
            } // inner while
        	
        	stack.push(num);
        } // for
        
        while (stack.size() > canCount) stack.pop(); // 같은 값 입력됐을때 처리 
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        System.out.print(sb);
    }
	/*
	{
		#include <string>
		#include <vector>
		#include <iostream>
		using namespace std;
		
		string solution(string number, int k) {
		    string answer = "";
		    answer = number.substr(k); 
		    for(int i = 0;i <k;i++){
		        int j = 0;
		        do{
		            if(number[i] >= answer[j]){
		                char temp = answer[j];
		                answer[j] = number[i];
		                number[i] = temp;
		                j++;
		            }else{
		                break;
		            }
		        }while(1);
		    }
		    return answer;
		}	
	}
	
	////
	
	{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(BR.readLine(), " ");
		StringBuilder SB = new StringBuilder();
		int N = Integer.parseInt(ST.nextToken());
		int K = Integer.parseInt(ST.nextToken());
		String target_num = BR.readLine();
		boolean[] target_bool = new boolean[target_num.length()]; 
		
		for (int i = 0; i < target_num.length(); i++) target_bool[i] = true;
		
		int ori_index = 0;
		int tar_index = ori_index + 1;
		int sub_counter = 0;
		while(sub_counter < K) {
			if(target_num.charAt(ori_index) > target_num.charAt(tar_index)) {  
				target_bool[tar_index] = false;
				sub_counter++;
				tar_index++;
			} else if(target_num.charAt(ori_index) < target_num.charAt(tar_index)) { 
				target_bool[ori_index] = false;
				ori_index = tar_index;
				tar_index++;
				sub_counter++;
			} else { 
				ori_index = tar_index;
				tar_index++;
			}
		} // while
		
		for (int i = 0; i < target_bool.length; i++) {
			if(target_bool[i]) SB.append(target_num.charAt(i));
		} // for 
		
		System.out.println(SB);
	}
	*/
}
