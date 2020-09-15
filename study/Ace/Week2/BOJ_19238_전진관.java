import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int N,M,fuels;
    private static int[][] map;
    private static Passenger[][] passengers;
    private static boolean[][] isVisited;

    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]); // 매트릭스 사이즈
        M = Integer.parseInt(temp[1]); // 승객 수
        fuels = Integer.parseInt(temp[2]); // 연료

        map = new int[N][N];
        passengers = new Passenger[N][N];



        for(int i=0;i<N;i++){
            temp = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        temp = br.readLine().split(" ");
        int y = Integer.parseInt(temp[0])-1; // 시작 지점
        int x = Integer.parseInt(temp[1])-1;


        for(int i=0;i<M;i++){
            temp = br.readLine().split(" ");
            // TODO : 손님 받아서 처리하는 방법
            int sy = Integer.parseInt(temp[0]);
            int sx = Integer.parseInt(temp[1]);
            int ey = Integer.parseInt(temp[2]);
            int ex = Integer.parseInt(temp[3]);

            passengers[sy-1][sx-1] = new Passenger(ey-1, ex-1);
        }

        for(int i=0;i<M;i++){
            Node start = search(y, x);

            if(start == null || start.time >= fuels){
                fuels = -1;
                break; // 끝내고 처리를 더 해주어야 한다. -1을 리턴해준다는지
            }

            fuels -= start.time;
            Node end = drive(start);

            if(end == null || end.time > fuels){
                fuels = -1;
                break;
            }

            fuels += end.time;
            y = end.y;
            x = end.x;
        }


        System.out.println(fuels);


    }

    private static Node drive(Node start){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.y, start.x, 0)); // 사용연료 0인채로 시작해야한다.
        isVisited = new boolean[N][N];
        isVisited[start.y][start.x] = true;

        int endY = passengers[start.y][start.x].ey;
        int endX = passengers[start.y][start.x].ex;

        passengers[start.y][start.x] = null;

        while(!q.isEmpty()){
            Node current = q.poll();

//            if(current.time > fuels){
//                break; // 연료를 다 썼을 경우.
//            }

            if(current.y == endY && current.x == endX){ // 목적지에 도달했을 경우.
                return current;
            }

            for(int i=0;i<4;i++){
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if(ny >= N || ny < 0 || nx >= N || nx < 0 || map[ny][nx] == 1 || isVisited[ny][nx])continue;

                isVisited[ny][nx] = true;
                q.add(new Node(ny, nx, current.time+1));
            }

        }

        return null;
    }

    private static Node search(int y, int x){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, 0));
        isVisited = new boolean[N][N];
        isVisited[y][x] = true;

        while(!q.isEmpty()){
            Node current = q.poll();

//            if(current.time > fuels){
//                break; // 연료를 다 썼을 경우.
//            }

            // TODO : 여기서 승객이 있는지를 확인하고 태운다.
            if(passengers[current.y][current.x] != null){
                return current;
            }

            for(int i=0;i<4;i++){
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if(ny >= N || ny < 0 || nx >= N || nx < 0 || map[ny][nx] == 1 || isVisited[ny][nx])continue;

                isVisited[ny][nx] = true;
                q.add(new Node(ny, nx, current.time+1));
            }
        }
        return null;
    }

    private static class Node{
        int y, x, time;
        Node(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", time=" + time +
                    '}';
        }
    }

    private static class Passenger{
        int ey, ex;
        Passenger(int ey, int ex){
            this.ey = ey;
            this.ex = ex;
        }
    }

}
