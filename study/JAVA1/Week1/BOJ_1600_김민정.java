package itda;
import java.io.*;
import java.util.*;

public class BOJ_1600_김민정 {

	public static int K, W, H;
	public static int [][]map;
	public static boolean [][][]visit;
	
	static int dx[] = { 0,1,0,-1 };
	static int dy[] = { -1,0,1,0 };
	static int hdx[] = { 1,2,2,1,-1,-2,-2,-1};
	static int hdy[] = {-2,-1,1,2,2,1,-1,-2 };
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		String[] tmp = br.readLine().split(" ");
		
		W = Integer.parseInt(tmp[0]);
		H = Integer.parseInt(tmp[1]);
		
		map = new int[H][W];
		
	    for (int i = 0; i < H; i++)
	    {
	    	tmp = br.readLine().split(" ");
	    	
	        for (int j = 0; j < W; j++)
	        {
	        	 
	             map[i][j] = Integer.parseInt(tmp[j]) ;
	        }
	    }
	    
	    System.out.println(BFS());
	    
	    


	}
	
	public static int BFS() {
		
		
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(1,1,0,0));
		visit[1][1][0] = true;
        
        while(!queue.isEmpty()) {
        	
            Location loc = queue.poll();
            // 최단값 리턴 
            if(loc.y == H && loc.x == W)
                return loc.cnt;
            // 원숭이가 말처럼 움직일 수 있는 횟수가 남아있는 경우
            if(loc.k < K) {
                for(int d=0; d<8; d++) {
                    int newX = loc.x + hdx[d];
                    int newY = loc.y + hdy[d];
                    
                    if(1<=newY && newY<=H && 1<=newX && newX<=W) {
                        if(!visit[newY][newX][loc.k+1] && map[newY][newX] == 0) {
                            visit[newY][newX][loc.k+1] = true;

                            queue.add(new Location(newX, newY, loc.k+1, loc.cnt+1));
                        }
                    }
                }
            }
            
            // 원숭이가 말처럼 움직일 수 없는 경우 
            for(int d=0; d<4; d++) {
                int newX = loc.x + dx[d];
                int newY = loc.y + dy[d];
                if(1<=newY && newY<=H && 1<=newX && newX<=W) {
                	
                    if(!visit[newY][newX][loc.k] && map[newY][newX] == 0) {
                    	
                        visit[newY][newX][loc.k] = true;
                        
                        queue.add(new Location(newX, newY, loc.k, loc.cnt+1));
                    }
                }
            }
        }
        
        return -1;
		
		
	}
	
	public static class Location{
		int x;
		int y;
		int k;
		int cnt;
		
	    public Location(int x, int y, int k, int cnt) {
	           this.x=x;
	           this.y=y;
	           this.k=k;
	           this.cnt=cnt;
	     }
	}

}
