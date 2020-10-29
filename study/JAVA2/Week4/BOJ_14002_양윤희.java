package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main11 {
	static int n, val[], lis[],parval[],paridx[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		val = new int[n];
		lis = new int[n]; //
		parval = new int[n]; //수열 값 저장 배열
		paridx = new int[n]; //인덱스 저장 배열
		for (int i = 0; i < n; i++) {
			val[i] = Integer.valueOf(st.nextToken());  //값 입력받기
			lis[i] =1;
		}
		
		dp();
	}

	static void dp() {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(val[j] < val[i] && lis[i] == lis[j]) { //기준값을 val[i]로 잡고 그 전 값들을 비교함, 그 전값들보다 크고  길이를 증가할 수 있는지 확인  
					lis[i]++; 
					parval[i] = val[j]; //수열 값에 다가 값 저장
					paridx[i] = j; //인덱스 저장
				}
			}
		}
		int maxidx=0;
		int max=0;
		for (int i = 0; i < lis.length; i++) {
			if(max < lis[i]) { //lis배열 중 가장 큰 값이 가장 긴 증가 수열의 길이가 되는 것
				max=lis[i];
				maxidx=i;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(val[maxidx]); //리스트에 가장 큰 값 추가
		
		int idx=maxidx;
		
		while(parval[idx]!=0) {
			list.add(parval[idx]);
			idx = paridx[idx]; //수열값을 순서에 따른 idx에 따라 저장
		}
		
		Collections.sort(list);
		
		System.out.println(max); //수열의 길이 출력
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" "); //출력
		}
	}
}
