import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	static Stack<Character> st = new Stack();
	static char[] words;
	static char[] c4;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		words = br.readLine().toCharArray();
		c4 = br.readLine().toCharArray();
		
		for(int i=0;i<words.length;i++) {
			char temp = words[i];
			st.add(temp);
			if(st.size()>=c4.length && temp == c4[c4.length-1])explore();
		}		
		
		char[] res = new char[st.size()];
		for(int i=res.length-1;i>=0;i--) {
			
			res[i] = st.pop();		
		}
		
		if(res.length==0) {
			System.out.println("FRULA");
		}else {
			for(int i=0;i<res.length;i++) {
				bw.write(res[i]);
			}
			bw.flush();
		}
		
	}
	
	public static void explore() {
		
		char[] temp = new char[c4.length];
		boolean flag = true;
//		System.out.println(st.size());
		for(int i=c4.length-1;i>=0;i--) {		
			temp[i] = st.pop();			
		}
		
		for(int i=0;i<c4.length;i++) {
			if(c4[i] != temp[i]) {
				// 문자열이 폭발하지 않는다면 넣고서 다시 패스. 
				flag = false;
			}
		}
		if(!flag) {
			for(int i=0;i<temp.length;i++) {
				st.add(temp[i]);
			}
		}		
	}
}
