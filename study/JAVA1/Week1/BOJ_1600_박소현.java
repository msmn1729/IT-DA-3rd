package itda_2020;

import java.io.*;
import java.util.*;

public class BOJ_1600_박소현 {
	private static int K,W,H;
	private static boolean visit[][];
	public static int[] dx = {-1,-1,1,1,-2,-2,2,2}; 
	public static int[] dy = {-2,2,-2,2,-1,1,-1,1};
	public static int [] dx2 = {1,-1,0,0};
	public static int [] dy2 = {0,0,-1,1};
	
	static int count = 0;
	static int array[][];
	
	static double result;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		array = new int [200][200];
		K = scan.nextInt();
		W = scan.nextInt();
		H = scan.nextInt();
		
		for (int i = 0; i < H ; i++ ) { 
			for (int j = 0; j < W ; j++ ) { 
			array[i][j] = scan.nextInt();
			}
		}
	}

}
