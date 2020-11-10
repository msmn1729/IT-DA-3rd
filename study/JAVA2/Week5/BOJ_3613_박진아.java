package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Java의 변수명은 javaIdentifier, longAndMnemonicIdentifier, name, bAEKJOON
 * C++에서는 변수명에 소문자줄('_')을
 * 
 * 입력으로 주어진 변수명이 Java형식이면 -> C++형식으로 출력하고, 
 * C++형식이라면 Java형식으로 출력한다. 둘 다 아니라면 "Error!"를 출력한다.
 * 
 * long_And -> Error
 * __ -> Error
 * 
 * ㅡㅡ;
 */
public class Q3613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		boolean isJava=false, isCpp=false;
		
		int low=0,up=0,line=0; //소문자, 대문자, 줄  
		int arr[] = new int[input.length()];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)input.charAt(i);
			if(65<=arr[i]&&arr[i]<=90) up++;
			if(97<=arr[i]&&arr[i]<=122) low++;
			if(arr[i]==95) line++;
		}
		
		String res="";
		if(up==0) isCpp=true;
		if(line==0) isJava=true;
		
		if(!isJava && !isCpp) System.out.println("Error!");

		if(isJava) {
			for(int i=0;i<arr.length;i++) {
				//첫글자가 대문자일때 
				if(65<=arr[0]&&arr[0]<=90) {
					System.out.println("Error!");
					System.exit(0);;
				}
				
				if(65<=arr[i]&&arr[i]<=90) {
					res+="_";
					res+=(char)(arr[i]+32);
				}
				else {
					res+=(char)arr[i];
				}
			}
			System.out.println(res);
			System.exit(0);
		}
		
		if(isCpp) {
			for(int i=0;i<arr.length;i++) {
				//첫글자가 _ 
				if(arr[0]==95) {
					System.out.println("Error!");
					System.exit(0);;
				}
				if(arr[i]==95) {
					//마지막 글자가 _
					if(i+1>=arr.length) {
						System.out.println("Error!");
						System.exit(0);;
					}
					//연속한 __
					if(arr[i+1]==95) {
						System.out.println("Error!");
						System.exit(0);;
					}
					res+=(char)(arr[i+1]-32);
					i +=1;
				}
				else {
					res+=(char)arr[i];
				}
			}
			System.out.println(res);
		}
		
	}
}
