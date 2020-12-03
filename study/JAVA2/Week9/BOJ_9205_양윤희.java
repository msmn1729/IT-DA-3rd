package BOJ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

//9200
//dfs로 구한다음 차이를 구
public class Main11 {
	 static int[][] map;
	 
	 static int count, y, x, homey, homex;
	 static String res = "happy";
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
        map = new int[10001][10001];
        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++) {
        	res = "happy";
            int n = sc.nextInt();
            homey = sc.nextInt();
            homex = sc.nextInt();
        	
            for(int nc = 0; nc<n+1; nc++) {
            	y = sc.nextInt();
            	x = sc.nextInt();
            	map[y][x] = 1;
            }
        	y = sc.nextInt();
        	x = sc.nextInt();
        	map[y][x] = 1; 
            dfs(homey, homex);
        }
	}
	
	static void dfs(int level, int value) {
		for(int i=0; i<x; i++) {
			if(map[level][i]==1) {
				if(Math.abs(level))
			}
		}
	
	}
}


