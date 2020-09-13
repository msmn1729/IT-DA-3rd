package BOJ;
import java.util.*;
/*
시간 복잡도: O(n+m)
사용한 알고리즘: BFS(너비 우선 탐색)
사용한 자료구조: 인접 리스트, 배열
*/
class BOJ_양윤희_5567 {
    static final int max_int_N = 501; //최댓값 +1
    static final int max_int_m = 10001; //최댓값 +1

    static int n, m, a, b, cnt=0;
    static int[] check = new int[max_int_m]; //check는 최단 거리를 저장할 배열
    static ArrayList<Integer> v[] = new ArrayList[max_int_N]; //간선의 정보를 인접 리스트

    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);        //n정점의 수, m 간선의 수
        n = sc.nextInt();
        m = sc.nextInt();
        
        //거리 정보를 저장할 check 배열을 -1로 초기화한다.
        for(int i=1; i<=n; i++) {
            check[i] = -1;
            v[i] = new ArrayList<>();
        }
        //간선 저장
        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            //양방향 그래프로 만든다.
            v[a].add(b);
            v[b].add(a);
        }
        //너비 우선 탐색 수행
 
            System.out.println(bfs());
        
    }

    public static int bfs(){
        Queue<Integer> q = new LinkedList<>(); //q 생성
        check[1] = 0; //시작점까지의 최단 거리는 0
        q.add(1); //큐에 시작점 넣어주기

        //큐가 비어있을 때까지 계속
        //큐가 비었다는 의미는 시작점에 연결된 모든 다른 정점들을 방문했다는 의미
        while(!q.isEmpty()){
        	//q에서 가장 앞에 있는 정보를 넣어준다.
            int node = q.poll();
            
            //임의의 정점에서 연결된 다른 모든 정점들을 next에 넣는다.
            for(int i=0; i<v[node].size(); i++){
                int next = v[node].get(i);
                //만약 방문하지 않았다면
                if(check[next] == -1){
                	//q에 넣기 전에 방문했음을 체크한다.
                	//여기서 체크안하면 다른 정점이 여기를 또 방문할 수도 있음
                	//간선을 타고 이동할 때마다 1씩 증가, 이전 정점까지의 거리에 1을 더해준다.
                    check[next] = check[node] + 1;
                    //친구 사이의 거리가 2일때까지만 돌리게 한다.
                    if(check[next] ==3) {
                    	return cnt;
                    }
                    //다음 정점을 큐에 넣는다.
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}