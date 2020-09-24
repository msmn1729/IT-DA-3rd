package itda;
import java.io.*;

public class BOJ_10164_김민정 {

	public static int n, m, k, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		n=Integer.parseInt(input[0]); 
		m=Integer.parseInt(input[1]); 
		k=Integer.parseInt(input[2]);
		
		init();
		System.out.println(getVal()+"");
	}
	
	private static void init(){
		map = new int[n+1][m+1];
		int i, j; 
		map[0][1]=1;
		for(i=1;i<=n;i++)
			for(j=1;j<=m;j++)
				map[i][j] = map[i-1][j]+map[i][j-1];
	}
	
	private static int getVal(){
		if(k==0) 
			return map[n][m];
		int ax, ay, bx, by;
		
		ax = k/m+(k%m>0?1:0);
        ay = k-(ax-1)*m;
		bx = n-ax+1;
        by = m-ay+1;
        
		return map[ax][ay] * map[bx][by];
	}

}
