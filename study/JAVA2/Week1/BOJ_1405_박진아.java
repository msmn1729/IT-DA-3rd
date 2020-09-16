package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1405 {
/*
 * 각 행동에서 로봇은 4개의 방향 중에 하나를 임의로 선택한다. 
 * 그리고 그 방향으로 한 칸 이동한다.
 * 로봇이 같은 곳을 한 번보다 많이 이동하지 않을 때, 
 * 로봇의 이동 경로가 단순하다고 한다. 
 * (로봇이 시작하는 위치가 처음 방문한 곳이다.) 
 * 로봇의 이동 경로가 단순할 확률을 구하는 프로그램을 작성하시오. 
 * 예를 들어, EENE와 ENW는 단순하지만, 
 * ENWS와 WWWWSNE는 단순하지 않다. (E는 동, W는 서, N은 북, S는 남)
 * 
 * 
 * 
 * 첫째 줄에 
 * N, 
 * 동쪽으로 이동할 확률, 
 * 서쪽으로 이동할 확률, 
 * 남쪽으로 이동할 확률, 
 * 북쪽으로 이동할 확률이 주어진다.
 *  N은 14보다 작거나 같은 자연수이고,  
 *  모든 확률은 100보다 작거나 같은 자연수 또는 0이다. 
 *  그리고, 동서남북으로 이동할 확률을 모두 더하면 100이다.
 *  
 *  2 25 25 25 25
 *  
 *  못풂 
 * 
 *  [접근]
 *  단순한 이동경로 : 지나간 곳을 지나가지 않음 
 *  단순한 이동경로 : 4*3 / 총 이동 경로 : 4*4 = 0.75 ?
 *  
 *  단순한 이동경로의 수는 dfs로 구할 수 있을거같음
 *  dfs의 탐색 깊이 = n 
 *
 *  이동할 확률은 어떻게 따지면 좋을까
 *  으음 
 *  이동할때마다 확률 곱하면 될까 ? ...
 *  
 *  동서남북에서 출발할때
 *  dfs로 갈 수 있는 이동경로를 탐색하고 
 *  확률을 곱하기
 *  그 후 동서남북 확률 모두 더하면 되지 않나  
 *  
 */
static int dx[]= {1,-1,0,0}, dy[]= {0,0,-1,1};
static int n;
static Double percent[] = new Double[4];
static int [][] map = new int[100][100];
static double result=0;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input[] =br.readLine().split(" ");
    boolean visited [][] = new boolean[14][14];
    
    n = Integer.parseInt(input[0]);
    
    for(int i=0;i<4;i++) {
        percent[i]=Double.parseDouble(input[i+1])*0.01;
        System.out.println(percent[i]);
    }
    
    System.out.println("done");
    int depth=1; int x =50; int y=50; 
    double tmp=1;

    dfs(depth,x,y,tmp);
    
    System.out.println(result);
}

private static void dfs(int depth, int x, int y, double tmp) {
    if(depth == n) {
        System.out.println("depth==n");
        result= result+tmp;
        return;
    }

    System.out.println("depth: "+depth);
    map[y][x]=1;
    
    // 동서남북 순서로 반복문 
    for(int i=0;i<4;i++) {
        int nextx= x+dx[i];
        int nexty= y+dy[i];
        
        System.out.println(nextx+" "+nexty);
        
        if(map[nexty][nextx]==0) {
            double p = percent[i];
            depth+=1;
            dfs(depth,nextx,nexty,tmp*p);
        }
    }
}
}