import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
public class Main {
	
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<tc;i++) {
			int n = Integer.parseInt(br.readLine());
			Trie tree = new Trie();
			
			for(int j=0;j<n;j++) {
				String number = br.readLine();				
				tree.root.addChild(number);			
			}
			
			tree.printTrie(tree.root, "");
			if(n == cnt)bw.write("YES\n");
			else bw.write("NO\n");
			
			cnt = 0;
		}
		bw.flush();
	}
	
	static class Node{
		
		Map<Character, Node> childs = new HashMap();
		
		void addChild(String number) {
			
			if(number.length() >= 2) {
				char input = number.charAt(0);
				number = number.substring(1, number.length());
				
				if(!this.childs.containsKey(input)) {
					this.childs.put(input,  new Node());
				}
				
				this.childs.get(input).addChild(number);
			}
			
			else if(number.length() == 1) {
				if(!this.childs.containsKey(number)) {
					this.childs.put(number.charAt(0),  new Node());
				}
			}
			
		}		
		
	}
	
	static class Trie{
		
		Node root;
		
		
		Trie(){
			root = new Node();
		}
		
		void printTrie(Node root, String number){
			
//			System.out.println("number + " + number + " " + root.childs.size());
			
			if(root.childs.size() == 0) {
//				System.out.println("number " + number);
				cnt++;
				return;
			}
			
			for(char key : root.childs.keySet()) {				
				printTrie(root.childs.get(key), number + key);
			}
			
		}
	}
}
