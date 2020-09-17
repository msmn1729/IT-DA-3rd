package itda_2020;

import java.util.*;

public class BOJ_2251_박소현 {

	static boolean[][] visited ;
	static boolean[] res;
	static int A,B,C;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		visited = new boolean[201][201];
		res = new boolean[201];
		
		Scanner scan = new Scanner(System.in); 
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();
		
		dfs(0,0,C);
		
		for ( int i = 1;i<201;i++) {
			if (res[i]) {
				System.out.print(i+" ");
			}
		}
		
	}
	
	static void dfs(int va, int vb, int vc) 
	{
		
		if(visited[va][vb]) { 
			return;        
			}
		
		if(va==0) {res[vc]=true; }
		 
		visited[va][vb] = true; //이거 없었어서 

		if(va+vb > B) {//a 다부엇더니 b가 꽉 차고 a에 남음 
			dfs((va+vb)-B,B,vc);}
		else {
			dfs(0,va+vb,vc); } //a 다 넣고 b에 자리 남음 
		
	
		if(va+vc > C) {//a 다부엇더니 c가 꽉 차고 a에 남음
			dfs((va+vc)-C,vb,C);}
		else {
			dfs(0,vb,va+vc); }//a 다 넣고 c에 자리 남음 
		
		
		if(vb+vc > C) {//b 다부엇더니 c가 꽉 차고 b에 남음 
			dfs(va,(vb+vc)-C,C);}
		else {
			dfs(va,0,vb+vc); } //b 다 넣고 C에 자리 남음 
		
		
		if(va+vb > A) {//b 다부엇더니 a가 꽉 차고 b에 남음 
			dfs(A,(vb+va)-A,vc);}
		else {
			dfs(va+vb,0,vc); } //b 다 넣고 a에 자리 남음 
		
		if(va+vc > A) {//c 다부엇더니 a가 꽉 차고 c에 남음 
			dfs(A,vb,(vc+va)-A);}
		else {
			dfs(vc+va,vb,0); } //c 다 넣고 a에 자리 남음 
		
		if(va+vc > B) {//c 다부엇더니 b가 꽉 차고 c에 남음 
			dfs(A,vb,(vc+va)-B);}
		else {
			dfs(va,vc+vb,0); } //c 다 넣고 b에 자리 남음 



	}

}

//이건 그냥 dfs로 시작해야지 .
//삼차원하다가 이차원으로 바꿈
