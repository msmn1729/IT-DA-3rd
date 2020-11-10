package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main9 {
	static char[] c_arr;
	static ArrayList<Character> res = new ArrayList<Character>();
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     c_arr = br.readLine().toCharArray();
	        
	        
	     if((c_arr[0]>='A' &&c_arr[0]<='Z' )||c_arr[0]=='_') { //첫글자가 대문자, _면 error
	        	System.out.println("Error!");
	        	return;
	        }
	     if(c_arr[c_arr.length-1]=='_') { //마지막 글자가 _면 error
	    	 System.out.println("Error!");
	        	return;
	     }
		for(int i=1; i<c_arr.length; i++) {
			
		

			if(i>2 && c_arr[i-2]=='_' && c_arr[i-1]=='_') {//_가 연속 두번일 경우 error
				System.out.println("Error!");
	        	return;
				
			}	
			if(c_arr[i] =='_') { //_가 한개인 경우 무시
				continue;
			}
			if(c_arr[i]<'A' || (c_arr[i]<'a' && c_arr[i]>='[') || c_arr[i]>'z') {//알파벳이 아니면 error
				System.out.println("Error!");
	        	return;
			}

		}
		int cnt=0;
		for(int i=1; i<c_arr.length; i++) {
			if(c_arr[i]=='_') { //_포함되면 c
				c();
				cnt++;
				return;
			}
			if(i==c_arr.length-1 && cnt==0) {
				java();
			}
		}
		for(char i: res) {
			System.out.print(i);
		}
	}
	
	static void c() {
		for(int i=0; i< c_arr.length; i++) {
			if(c_arr[i]>='A' &&c_arr[i]<='Z') { //대문자가 있으면 ERROR
				System.out.println("Error!");
	        	return;
			}
			if(c_arr[i]=='_') {
				continue;
			}
			if(i>1 && c_arr[i-1]=='_') {
				res.add((char) (c_arr[i]-32));
				continue;
				
			}
			res.add(c_arr[i]);
		}
	}
	static void java() {
		for(int i=0; i< c_arr.length; i++) {
			if(c_arr[i]>='A' && c_arr[i]<='Z') {
				res.add('_');
				res.add((char) (c_arr[i]+32));
				continue;
			}
			res.add(c_arr[i]);
		}
	}
}

