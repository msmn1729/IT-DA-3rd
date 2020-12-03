package BOJ;

import java.io.BufferedReader;
import java.awt.Point;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main7 {
	static int[][] map;
	static int wallCnt;
    static ArrayList<Point> virus;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		map = new int[n][m];
	
	
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
				 // 벽 개수
                if(map[i][j] == 1) wallCnt++;
                // 바이러스의 위치 저장
                if(map[i][j] == 2) virus.add(new Point(i,j));


			}
		}
	}
}
