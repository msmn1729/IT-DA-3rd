import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaCpp {

	public static void main(String[] args) throws IOException {
		//예외처리가 아주 상당히 귀찮은 문자열 문제..
		String s;
		String temp;
		String res = "";
		boolean sw = true;
		int cnt = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		
		if(s.contains("_")) {//cpp case
			if(s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_') {//제일 앞이나 뒤에 _가 올 경우
				System.out.println("Error!");
			}
			else {
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == '_') {
						++cnt;
						if(cnt >= 2) {//_가 두번 연속으로 나올 경우
							System.out.println("Error!");
							sw = false;
							break;
						}
					}
					else if(s.charAt(i) < 97) {//cpp case에서 대문자가 나오는 경우
						System.out.println("Error!");
						sw = false;
						break;
					}
					else {
						if(cnt == 1) {//_나온 직후에 나오는 문자의 경우
							cnt = 0;
							temp = (s.charAt(i) + "").toUpperCase();
							res = res.concat(temp);
						}
						else {
							res = res + s.charAt(i);
						}
					}
				}
				if(sw == true)
					System.out.println(res);
			}
		} 
		else {//java case
			if(s.charAt(0) < 97) {
				System.out.println("Error!");
			}//제일 앞의 문자가 대문자인 경우
			else {
				System.out.print(s.charAt(0));
				for(int i = 1; i < s.length(); i++) {
					if(s.charAt(i) < 97) {//대문자인 경우
						temp = (s.charAt(i) + "").toLowerCase();
						System.out.print("_" + temp);
					}
					else {//소문자인 경우
						System.out.print(s.charAt(i));
					}
				}
			}
		}
	}

}
