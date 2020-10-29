package backjoon.study.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 뮤탈리스크 https://www.acmicpc.net/problem/12869 
/*
 수빈이는 강호와 함께 스타크래프트 게임을 하고 있다. 수빈이는 뮤탈리스크 1개가 남아있고, 강호는 SCV N개가 남아있다.
 각각의 SCV는 남아있는 체력이 주어져있으며, 뮤탈리스크를 공격할 수는 없다. 즉, 이 게임은 수빈이가 이겼다는 것이다.
 뮤탈리스크가 공격을 할 때, 한 번에 세 개의 SCV를 공격할 수 있다.
 첫 번째로 공격받는 SCV는 체력 9를 잃는다. 3^2
 두 번째로 공격받는 SCV는 체력 3을 잃는다. 3^1
 세 번째로 공격받는 SCV는 체력 1을 잃는다. 3^0
 SCV의 체력이 0 또는 그 이하가 되어버리면, SCV는 그 즉시 파괴된다. 한 번의 공격에서 같은 SCV를 여러 번 공격할 수는 없다.
 남아있는 SCV의 체력이 주어졌을 때, 모든 SCV를 파괴하기 위해 공격해야 하는 횟수의 최솟값을 구하는 프로그램을 작성
 첫째 줄에 SCV의 수 N (1 ≤ N ≤ 3)이 주어진다. 둘째 줄에는 SCV N개의 체력이 주어진다. 체력은 60보다 작거나 같은 자연수이다.
 첫째 줄에 모든 SCV를 파괴하기 위한 공격 횟수의 최솟값을 출력한다.
 
 12 10 4 => 2, 부르트포스 터진다 (모든 경우의 수가 넘모 많다) / 그래서 그래프 탐색이나 제귀로 전체 경우 체크는 힘들것 같다
 처음엔 그리디 적인 생각을 했다 ~ 가장 큰놈을 큰데미지 / 하지만 위 예시에서도 어긋난다  
 일단 DFS로 접근했다 -> 시간 초과 / 일단 h1 h2 h3 의 '순서'를 계속 기억하려고 하지말고 모든 '숫자'측면에서 접근하자 
 hp1=10, hp2=7, hp3=9 일 때와 hp1=9, hp2=10, hp3=7 일 때의 작업은 같은 작업 
 {-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -3, -9}, {-1, -9, -3} 의 6가지 작업 수가 있는데 
 3기의 hp 조합이 같다면 결국 같은 작업 // => 3차원 배열 이용 
 */
public class Mutal {
	static int N;
    static ArrayList<Integer> scv;
    static int[][][] visited;
    static int[] damage = new int[] {9, 3, 1};
    static int attackCount;
    
    private static void solveDFS(int hp1, int hp2, int hp3, int nowCounter) {
    	// 순서 필요없다! 그냥 숫자의 '조합'만 생각하기위해서 max, mid, min으로 선별 
        hp1 = Math.max(0, hp1); hp2 = Math.max(0, hp2); hp3 = Math.max(0, hp3); // 0 밑으로 내려가지마라! 
        int max = Math.max(Math.max(hp1, hp2), hp3);
        int min = Math.min(Math.min(hp1, hp2), hp3);
        int mid = hp1 + hp2 + hp3 - max - min;
        hp1 = max;
        hp2 = mid;
        hp3 = min;
        
        // 모두 0인지 체크! 
        if(hp1 <= 0 && hp2 <= 0 && hp3 <= 0) {
            attackCount = Math.min(nowCounter, attackCount);
            return;
        }
        
        // 3차원으로 '이미' 구조적으로 같은 경우의 수 가지치기 
        if(visited[hp1][hp2][hp3] == 1) return;
        else visited[hp1][hp2][hp3] = 1;
        
        // 불필요한 작업 제거, 얼리 이스케이프 
        if(attackCount < nowCounter) return;
        
        // 모든 경우의 수 조합 순환 
        solveDFS(hp1 - 9, hp2 - 3, hp3 - 1, nowCounter + 1);
        solveDFS(hp1 - 9, hp2 - 1, hp3 - 3, nowCounter + 1);
        solveDFS(hp1 - 3, hp2 - 9, hp3 - 1, nowCounter + 1);
        solveDFS(hp1 - 3, hp2 - 1, hp3 - 9, nowCounter + 1);
        solveDFS(hp1 - 1, hp2 - 3, hp3 - 9, nowCounter + 1);
        solveDFS(hp1 - 1, hp2 - 9, hp3 - 3, nowCounter + 1);
        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(BR.readLine());
        scv = new ArrayList<>();
        visited = new int[61][61][61]; // max
        attackCount = Integer.MAX_VALUE;
        
        StringTokenizer ST = new StringTokenizer(BR.readLine(), " ");
        for(int i = 0; i < N; i++) scv.add(Integer.parseInt(ST.nextToken()));
        for(int i = N; i < 3; i++) scv.add(0); // 0인 경우 런타임 에러 (out of bound 때매 0넣음) 
        
        solveDFS(scv.get(0), scv.get(1), scv.get(2), 0);
        System.out.println(attackCount);
    }
}
