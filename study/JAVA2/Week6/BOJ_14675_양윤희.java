package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main8 {
	
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> s = new ArrayList<String>();
        int N=sc.nextInt()+1;
        int[] bin =new int[N];		
        for(int i=0;i<N-2;i++) //트리의 선이 몇개 인지 더해줌
        {
        	bin[sc.nextInt()]++;
        	bin[sc.nextInt()] ++;
        }
        int cnt;
        int q=sc.nextInt();
        for(int i=0; i<q; i++) {
        	int t = sc.nextInt(), k = sc.nextInt();
        	if(t==1) { //트리는 단말노드면 단절점임
        		if(bin[k]==1) {
        			s.add("no");

        		}
        		else {
        			s.add("yes");
        		}
        	}
        	if(t==2) { //트리의 모든 선은 단절선이다
        		s.add("yes");
        	}        	
        }
		for(String st : s) {
			System.out.println(st);
		}
	}
}
