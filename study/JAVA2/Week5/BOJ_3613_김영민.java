import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ_3613_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean error = false;
		String str = br.readLine();
		
		if(str.charAt(0)=='_' || str.charAt(str.length()-1)=='_') error = true; // 첫글자나마지막글자가'_'
		if(str.charAt(0)<97 || str.charAt(0)>122) error = true; // 첫글자가대문자
		
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i)=='_') {
				if(str.charAt(i+1)=='_') error = true; //'_'가연속두번
				else if(str.charAt(i+1)<=90) error = true; //'_'뒤에대문자
			}
			else if(str.charAt(i+1)<=90) {
				if(str.charAt(i+1)=='_') error = true; //대문자뒤에'_'
			}
		}
		
		if(error) {
			System.out.print("Error!");
			return;
		}
		
		String [] input = str.split("_");
		
		//c++
		if(input.length!=1) {
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)<=90) {
					System.out.print("Error!"); //c++대문자
					return;
				}
			}
			
			StringBuilder builder = new StringBuilder();
			for(int i=0; i<input.length; i++) {
			builder = new StringBuilder(input[i]);
				if(i!=0) { 
					char temp = input[i].charAt(0);
					builder.setCharAt(0, (char)(temp-32));
				}
				bw.write(builder.toString());
			}
		} 
		//java
		else {
			String [] temp = input[0].split("");
			for(int i=0; i<temp.length; i++) {
				char tempChar = temp[i].charAt(0);
				if((tempChar-90<=0)) bw.write("_"+(char)(tempChar+32));
				else bw.write(tempChar);
			}
		}
		bw.flush();
		bw.close();
	}
}
