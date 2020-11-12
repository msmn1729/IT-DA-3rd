package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



class Main9 {
	static String arr[];
	static ArrayList<String> res = new ArrayList<String>();
	static int n,t, min,idx;
	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());		
			arr= new String[n];
				for(int j=0;j<n;j++) {
					arr[j]=br.readLine();
            }
				Arrays.sort(arr);
				dp();
		}
		for(String data: res) {
			System.out.println(data);
		}
	}
	static void dp() {
		for(int i=0; i<n-1; i++) {
			int current = arr[i].length();
            int next = arr[i + 1].length();
            if (current < next) {
                if (arr[i + 1].indexOf(arr[i]) > -1) {
                	res.add("NO");
    				return;
		
                }
		
            }
		}
		res.add("YES");
		return;
	}
}

