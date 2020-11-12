import java.util.*;

public class 3613_ㅊㅁ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String check = input.next();
		
		String result = "";
		
		/**
		 * 1. 런타임 에러 방법
		 */
		
		if(check.contains("_")) { // 자바로 바꿔주기
			
			
			String answer [] = check.split("_");
			
			result = result + answer[0];
			
			for(int a = 1; a < answer.length; a++) {
				
				char upp_first = Character.toUpperCase(answer[a].charAt(0));
				
				result = result + upp_first + answer[a].substring(1);
			}
			
			
		}
		
		else {
			
			int point = 0;
			
			for(int c = 0; c < check.length(); c++) {
				
				if(Character.isUpperCase(check.charAt(c))) {
					
					result = result + check.substring(point, c) + "_" + 
								Character.toLowerCase(check.charAt(c));
					
					point = c+1;
				}
			}
			
			result = result + check.substring(point);
			
		}
		
		System.out.println(result);
		
		/**
		 * 2. 먼저 자바인지 C++인지 ERROR인지 판단해주기.
		 * 그 다음에 다른 언어로 바꿔주기.
		 */
		
		String flag = "";
		
		char[] answer;
		
		answer = check.toCharArray();
		
		/**
		 * 1. 먼저 해당 언어 유형이 JAVA인지, C++인지, ERROR인지 판단해주기.
		 */
		
		
		if(Character.isUpperCase(answer[0]) || answer[0] == '_')  // 맨 첫글자가 대문자 이거나 "_"이면 ERROR
			flag = "ERROR";
		
		else { // 맨 첫글자가 대문자가 아니라면
			
			for(int a = 1; a < answer.length; a++) { // 두번째 글자부터 탐색 시작.
				
				if(answer[a] == '_') { // 글자에 언더바가 나온다면, C++언어일 가능성.
					
					if(flag.equals("JAVA")) { // 이미 언어가 자바로 설정되어 있으면
						
						flag = "ERROR"; // 에러로 바꿔주기.
						break;
					}
					
					else { 
						// 자바 언어가 아니여도, 
						//1. 마지막에 _가 포함되어 있는지, 2. _의 연속이 아닌지 판단해줘야 한다.
						
						//1. 마지막에 "_" 가 포함되어 있는가
						if(a == answer.length - 1) {
							flag = "ERROR"; // 에러로 바꿔주기.
							break;
						}
						
						//2. "_" 의 연속인가
						else if(answer[a+1] == '_') {
							flag = "ERROR"; // 에러로 바꿔주기.
							break;
						}
						
						else //위의 해당 사항이 아니면
							flag = "C++";
					}
				}
				
				else if(Character.isUpperCase(answer[a])) { // 대문자가 나온다면
					
					/**
					 * 1. 원래 글자가 C++인지 확인해주기.
					 */
					
					if(flag.equals("C++")) {
						flag = "ERROR";
						break;
					}
					
					else 
						flag = "JAVA";
					
				}
				
			}
		}
		
		if(flag.equals("ERROR")) {
			System.out.println("Error!");
		}
		
		else if(flag.equals("C++")) {
			
			for(int i = 0; i < answer.length; i++) {
				
				if(answer[i] == '_') {
					result = result + Character.toUpperCase(answer[i+1]);
					i++;
				}
				
				else
					result = result + answer[i];
			}
			
			System.out.println(result);
		}
		
		else { // flag = "JAVA"
			
			for(int i = 0; i < answer.length; i++) {
				
				if(Character.isUpperCase(answer[i])) 
					result = result + "_" + Character.toLowerCase(answer[i]);
				
				else
					result = result + answer[i];
			}
			
			System.out.println(result);
		}
		
	}

}
