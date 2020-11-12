import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 어떻게 풀어야하지????
 * 와 진짜 트리 구현 불가. 
 * 접근 불가 
 * 
 */

class Tree{
	int nodeL;
	int nodeR;
	
	Tree(int l, int r){
		nodeL=l;
		nodeR=r;
	}
	
	void addNode(){
	}
}

public class Q5639 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number ="";
		ArrayList<Integer> node = new ArrayList<>();
		
		while((number = br.readLine()) != null && number.length() != 0) {
			node.add(Integer.parseInt(number));
	    }
	}
}
