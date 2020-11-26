package itda_2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1946_박소현 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        
        //int[] Grade2 = new int[N+1]; 
        //int[] tmp = new int[N+1]; 
        
        for (int t = 0; t < T; t++ ) {
        	int N = Integer.parseInt(st.nextToken());
            int[] Grade1 = new int[N+1]; 

            for (int i = 1; i<=N;i++) {
            	Grade1[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
                
            }
            
            Deque<Integer> dq = new ArrayDeque<>();
            for(int i = 0; i<Grade1.length;i++) {
            	while(!dq.isEmpty() && dq.getLast() < Grade1[i]) {
            		dq.removeLast();
            	}
            	//아 이거getLast도 틀렸군.. 망했다 
            	
            	dq.addLast(Grade1[i]);
            }

            StringBuilder ans = new StringBuilder();
            // 위 for문에서 K가 0이 되기 전에 끝난 경우를 대비하여
            // dq.size() - K만큼만 출력한다.
            for (int i = 0; i< dq.size();i++) {
                ans.append(dq.removeFirst());
            }
     
            bw.write(ans.toString() + "\n");
            bw.flush();
            bw.close();
            br.close();
        }
	}

}
