package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
//11000
public class Main8{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] room = new int[n][2];

        for(int i=0; i<n; i++) {
            room[i][0] = sc.nextInt();
            room[i][1] = sc.nextInt();
        }
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o1[0] - o2[0];
                if (result != 0) return result;
                else return o1[1] - o2[1];
            }
        });
        
        PriorityQueue<Integer> roomSize = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
        	 
            if (!roomSize.isEmpty() && roomSize.peek() <= room[i][0]){
                roomSize.poll();
            }
            roomSize.add(room[i][1]);
        }
 
        System.out.println(roomSize.size());
	}
}
