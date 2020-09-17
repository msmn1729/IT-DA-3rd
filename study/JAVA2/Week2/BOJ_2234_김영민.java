import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2234_김영민 {

	static int n, m;
	static int count=0;
	static int maxRoom=0, room=0, maxBroken=0, brokenRoom=0;
	static int [][]map;
	static int [][]visited;
	static boolean[][] checked;
	static int [] roomSize = new int[2501]; 
	static int [] offsetm = {0,-1,0,1}; //1서2북4동8남
	static int [] offsetn = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visited = new int[m][n];
		checked = new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j]==0) {
					count++;
					room = 0;
					dfs(i,j);
					roomSize[count] = room;
					if(room>maxRoom) maxRoom = room;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(maxRoom);
		
		brokenWall(0, 0);
		System.out.print(maxBroken);
	}
	
	static void dfs(int i, int j) {	
		//11
		//1011 & 0001(1) -> 0001
		//1011 & 0010(2) -> 0010
		//1011 & 0100(4) -> 0000
		//1011 & 1000(8) -> 1000
		
		visited[i][j] = count;
		room++;
		
		int wall = 1;
		
		for(int k=0; k<4; k++) {
			if((map[i][j] & wall) != wall) {
				int tempi = i+offsetm[k];
				int tempj = j+offsetn[k];
				if(tempi>=0 && tempi<m) {
					if(tempj>=0 && tempj<n) {
						if(visited[tempi][tempj]==0) {
							dfs(tempi, tempj);
						}
					}
				}
			}
			wall *= 2;
		}
	}
	
	static void brokenWall(int i, int j) {
		int room1 = visited[i][j];
		
		for(int k=0; k<4; k++) {
			int tempi = i+offsetm[k];
			int tempj = j+offsetn[k];
			if(tempi>=0 && tempi<m) {
				if(tempj>=0 && tempj<n) {
					if(!checked[tempi][tempj]) {
						checked[tempi][tempj] = true;
						int room2 = visited[tempi][tempj];
						if(room1 != room2)	{
							brokenRoom = roomSize[room1]+roomSize[room2];
							if(brokenRoom > maxBroken) maxBroken = brokenRoom;
						}
						brokenWall(tempi, tempj);
					}
				}
			}
		}
	}
}
