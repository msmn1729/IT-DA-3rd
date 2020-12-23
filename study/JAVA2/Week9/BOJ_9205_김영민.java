import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_김영민 {

	static int n;
	static Queue<Location> q = new LinkedList<Location>();
	static Location [] location;
	static boolean [] visited;
	
	static class Location {
		int x;
		int y;
		Location (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			location = new Location[n+2];
			visited = new boolean[n+2];
			
			// home=0, convenience, festival=n+1;
			for(int j=0; j<n+2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				location[j] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
	        q.add(location[0]);
	        
			bfs();
		}
	}
	
	static void bfs() {
		boolean check = false;
	    
		while (!q.isEmpty()) {
            Location now = q.poll();
            
            if(now==location[n+1]) { //도착
            	check = true;
            	break;
            }
            
            for(int i=1; i<n+2; i++) {
            	if(visited[i]==false && distance(now, location[i])<=1000) { //50*20
            		q.add(location[i]);
            		visited[i] = true;
            	}
            }
        }
	    
	    if(check) System.out.println("happy");
	    else System.out.println("sad");
	}
	
	public static int distance(Location start, Location end) { // x좌표의차이+y좌표의차이
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
    }
}


