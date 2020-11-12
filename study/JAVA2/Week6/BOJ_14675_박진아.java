import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * 숙제 못풀었음 
 * 조장님 죄송함다 ㅎㅎ; 
 * 
 * dfs로 분활되는지 체크하면 정답이 나올거 같음 
 * 
 */

class Pair {
	int a,b;
	public Pair(int a, int b) {
		this.a=a; this.b=b;
	}
}

public class Q14675 {
	
	//map
	static int[][]map = new int [100001][100001];
	//간선 
	static Pair[] line = new Pair[100001];
	//check
	static int[][]check = new int [1000001][1000001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String input[]=br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			line[i]=new Pair(a,b);
			map[a][b]=map[b][a]=1;
		}
		
		int q = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String input[]=br.readLine().split(" ");
			int t = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			if(t==1) {isVertex(k,n);}
			if(t==2) {isBridge(k,n);}
		}
		

	}
	private static void isBridge(int k, int n) {
		int ans=1;
		int[][]check = new int [1000001][1000001];
		
		int a=line[k].a;
		int b=line[k].b;
		//a랑 b의 연결이 끊기는거지?
		map[a][b]=map[b][a]=0;
		
		//영역 검사 후 나눠지면 yes 출력 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 &&check[i][j]==0) {
					if(ans>=2) {System.out.println("yes"); return;}
					dfs(i,j,n,check);
					ans+=1;
				}
			}
		}
		System.out.println("no");
		return;
		
	}
	private static void isVertex(int k, int n) {
		int ans=1;
		int[][]check = new int [1000001][1000001];
		
		for(int i=0;i<n;i++) {
			map[k][i] = 0;
			map[i][k] = 0;
		}
		
		//영역 검사 후 나눠지면 yes 출력 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 &&check[i][j]==0) {
					if(ans>=2) {System.out.println("yes"); return;}
					dfs(i,j,n,check);
					ans+=1;
				}
			}
		}
		System.out.println("no");
		return;
	}
	private static void dfs(int i, int j,int n, int[][] check) {
		check[i][j]=check[j][i]=1;
		//1,2 -> 2,3
		for(int m=0;i<n;m++) {
			if(map[j][m]==1) {
				int next=m;
				dfs(m,next,n,check);
			}
		}
		
	}

}
