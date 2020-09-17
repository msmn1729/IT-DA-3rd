package itda;
import java.io.*;
import java.util.*;

class Node{
	int a,b,c;
	Node(int a, int b ,int c){
	        this.a=a;
	        this.b=b;
	        this.c=c;
	}
}
public class BOJ_2251_김민정 {

	public static int aSize, bSize, cSize ;
	public static boolean[][][] visited;
	public static Queue<Node> q = new LinkedList<Node>();
	public static ArrayList<Integer> res = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
	       aSize = Integer.parseInt(input[0]);
	       bSize = Integer.parseInt(input[1]);
	       cSize = Integer.parseInt(input[2]);
	       
	       visited = new boolean[aSize+1][bSize+1][cSize+1];
	       //start water capacity a=0, b=0, c is full.
	       q.add(new Node(0,0,cSize));
	       //find number of six cases
	       bfs();
	       //result is ascending order
	       Collections.sort(res);
	        for(int i=0 ; i< res.size(); i++) {
	            System.out.print(res.get(i)+" ");
	        }
	 }
	
	public static void bfs() {
		 
	     while(!q.isEmpty()) {
	    	 //import node information stored in the Queue(q)
	    	 Node node = q.poll();
	    	 //run in six cases if not visited
	         if(visited[node.a][node.b][node.c]) {
	                continue;
	         }
	         //store the remained amount of c's water in the res when the a's capacity is empty.
	         if(node.a==0) {
	                res.add(node.c);
	         }
	         //check all cases 
	         visited[node.a][node.b][node.c] = true;
	         //start :0 0 10   
	         if(node.a + node.b <= aSize) {
	                q.add(new Node(node.a+node.b,0,node.c));
	         }else{
	                q.add(new Node(aSize,node.b+node.a-aSize,node.c));
	         }
	         //C->A : 8 0 2
	         if(node.a + node.c <= aSize) {
	                q.add(new Node(node.a+node.c,node.b,0));
	         }else{
	                q.add(new Node(aSize,node.b,node.c+node.a-aSize));
	         }
	         //A->B : 0 8 2
	         if(node.b + node.a<= bSize){
	                q.add(new Node(0,node.a+node.b,node.c));
	         }else{
	                q.add(new Node(node.a+node.b-bSize,bSize,node.c));
	         }
	         //C->B : 0 9 1
	         if(node.b + node.c <= bSize){
	                q.add(new Node(node.a,node.b+node.c,0));
	         }else{
	                q.add(new Node(node.a,bSize,node.c+node.b-bSize));
	         }
	         //B->C : 0 8 2
	         if(node.c + node.a <= cSize) {
	                q.add(new Node(0,node.b,node.c+node.a));
	         }else{
	                q.add(new Node(node.a+node.c-cSize,node.b,cSize));
	         }
	         //B->C : 0 0 10 
	         if(node.c + node.b <= cSize){
	                q.add(new Node(node.a,0,node.c+node.b));
	         }else{
	                q.add(new Node(node.a,node.b+node.c-cSize,cSize));
	         }
	      }
	  }
}

