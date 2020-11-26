package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
 * 노드로 이으면 되지 않을까 
 * 구현을 못하겠어... 
 */
class Class implements Comparable<Class>{
	int s;
	int t;
	ArrayList<Class> next = new ArrayList<>();
	
	public Class(int s1, int t1) {
		this.s=s1;
		this.t=t1;
	}

	@Override
	public int compareTo(Class ss) {
		if(this.s < ss.s) {
			return -1;
		}
		else if(this.s>ss.s) {
			return 1;
		}
		return 0;
	}
}
public class Q11000 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Class> arr = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String input[] = br.readLine().split(" ");
			Class data = new Class(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			arr.add(data);
		}
		
		Collections.sort(arr);
		
		
	}

}
