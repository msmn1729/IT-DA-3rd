package BOJ;
import java.io.*;
import java.util.*;
/*
 * bfs
 * 1)번 소인수분해나 규칙이 있을 거라고 생각
 * C 의 경우의 수는 A, B, C, C-A, C-B, 이렇게 있을 거라고 생각함
 * 
 * 
 * public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int res[]= new int[4];
		int a = Integer.parseInt(bf.readLine());
		int b = Integer.parseInt(bf.readLine());
		int c = Integer.parseInt(bf.readLine());

		if(a>200 || b>200 || c>200) {
			return;
		}
		int d = c-a;
		int e = c-b;
		if(d<0) {
			res = new int[] {a,b,c,e}; 만약 A가 C보다 크다면 PASS
		}
		if(e<0) {
			res = new int[] {a,b,c,d}; 만약 B가 C보다 크다면 PASS
		}
		if(e<0 && d<0) {
			res = new int[] {a,b,c}; A, B 둘 다 크면 PASS
		}
		res = new int[] {a,b,c,d,e};

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i : res){ //중복검사
            if(!arrayList.contains(i))
                arrayList.add(i);
        }
        Collections.sort(arrayList); //오름차순 정렬
        for(int j : arrayList) {
        	   System.out.print(j + " ");
        	} 
        	System.err.println();
        
	}  
 * 
 * 위의 경우가 맞다고 생각했는데 런타임 에러가 떠서 C++로 코드를 수정해 봄
 * 
 * #include <iostream>
#include <algorithm>
#include<vector>
using namespace std;


	int main(){
		int a,b,c;
		vector<int> s;
		cin>>a>>b>>c;

		if(a>200 || b>200 || c>200) {
			return -1;
		}
		
		int d = c-a;
		int e = c-b;
		
		if(d<0) {
			s.push_back(a);
			s.push_back(b);
			s.push_back(c);
			s.push_back(e);

		}
		if(e<0) {
			s.push_back(a);
			s.push_back(b);
			s.push_back(c);
			s.push_back(d);		
			}
		if(e<0 && d<0) {
			s.push_back(a);
			s.push_back(b);
			s.push_back(c);
		}
		
		s.push_back(a);
		s.push_back(b);
		s.push_back(c);
    	s.push_back(d);
		s.push_back(e);
		s.erase(unique(s.begin(),s.end()),s.end());	    
        sort(s.begin(), s.end());
        for(size_t i=0; i<s.size(); i++){
        	cout<<s[i]<<" ";
		}

	}


 * 
 * 위의 코드가 틀려서 블로그에 검색해서 BFS로 완전 탐색 해야함을 알게 됨
 * 근데 문제를 처음 봤을 떄는 완전탐색을 해야하는 경우인지 판단이 잘 서지 않았다.
 * A->B
 * A->C
 * B->A
 * B->C
 * C->A
 * C->B 6가지의 경우 탐색
 * 
 * */
public class BOJ_2251_양윤희 {
	
	static boolean[][][] visited;
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static int max_a,max_b,max_c; //A,B,C 물통의 부피
	
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    String[] t =br.readLine().split(" ");
	    max_a = Integer.parseInt(t[0]);
	    max_b = Integer.parseInt(t[1]);
	    max_c = Integer.parseInt(t[2]);

		visited = new boolean[max_a+1][max_b+1][max_c+1];
		visited[0][0][max_c] = false; //C물통에 처음으로 물을 다 부으므로 0,0,C 방문 처리

		q.add(new Node(0,0,max_c));
		bfs();
		Collections.sort(list); //오름차순 정렬
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	

	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();

			if(visited[node.a][node.b][node.c]) {
				continue; //방문한 경우이면 PASS
			}
			visited[node.a][node.b][node.c] = true;

			if(node.a+node.b <=max_a) { //B->A A가 넘치지 않을 떄 
				q.add(new Node(node.a+node.b,0,node.c)); //새로운 경우에 대해서 계속 탐색해줌
			}
			else {//B->A A가 넘칠 떄
				q.add(new Node(max_a,node.b+node.a-max_a, node.c));
			}
			if(node.a+node.c<=max_a) { //C->A A가 넘치지 않을 떄
				q.add(new Node(node.a+node.c,node.b,0));
			}
			else {//C->A A가 넘칠 때
				q.add(new Node(max_a,node.b,node.c+node.a-max_a));
			}
			if(node.a+node.b<=max_b) { //A->B
				q.add(new Node(0,node.a+node.b,node.c));
			}
			else {
				q.add(new Node(node.a+node.b-max_b,max_b,node.c));
			}
			if(node.c+node.b <=max_b) {//C->B
				q.add(new Node(node.a, node.b+node.c, 0));
			}
			else {
				q.add(new Node(node.a,max_b,node.c+node.b-max_b));
			}
			if(node.a+node.c <=max_c) {//A->C
				q.add(new Node(0,node.b,node.a+node.c));
			}
			else {
				q.add(new Node(node.a+node.c-max_c, node.b, max_c));
			}
			if(node.b+node.c <=max_c) {// B->C
				q.add(new Node(node.a,0,node.c+node.b));
			}
			else {
				q.add(new Node(node.a,node.b+node.c-max_c,max_c));
			}
			if(node.a==0) { //A 물통에 물이 0인경우 결과에 추가함
				list.add(node.c);
			}
		}		
	}
}


class Node{
    int a,b,c;
    Node(int a, int b ,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}