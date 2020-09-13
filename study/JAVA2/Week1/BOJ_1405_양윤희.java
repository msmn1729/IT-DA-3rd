package BOJ;

import java.util.Scanner;


/*
 시간 복잡도: O(|V|+|E|)
 사용한 알고리즘: DFS(깊이 우선 탐색)
사용한 자료구조: 이차원 배열, 재귀
*/
class BOJ_양윤희_1405 {
	
	static int n;
	static double ans=0, p[];
	static int vy[] = {0,0,1,-1}; //Y축 
	static int vx[] = {1,-1,0,0}; //X축
	static boolean map[][]; //방문했는지 확인할 수 있는 bool형 배열
	
	public static void dfs(int x, int y, int dep, double res){
		if(dep ==n) { //깊이가 N과 같으면 값을 반환한다. 
			ans +=res;
			return;
		}
		for(int i=0; i<4; i++) { //동서남북으로 이동
			int ny =y+vy[i]; 
			int nx = x+vx[i];
			if(ny>=29 || nx>=29 || ny<0 || nx<0) continue; //n의 범위를 넘어서면 반복문 나가기
			
			if(!map[ny][nx]) {
				map[nx][nx] =true; 
				dfs(ny,nx,dep+1,res*p[i]);
				map[nx][nx] =false; //방문한 곳으로 만듬
				}
			}
			
		}

	public static void main(String args[])  {		
		
       Scanner sc = new Scanner(System.in);       
       
       p = new double[4];
       map = new boolean[29][29];
       
       n = sc.nextInt();
       for(int j=0; j<4; j++) {
    	   p[j] = sc.nextInt() * 0.01;
       }
       map[14][14] = true; //시작 위치 
       dfs(14,14,0,1.0); //(14,14)의 위치에서 시작
       System.out.printf("%.10f", ans);
	}
}