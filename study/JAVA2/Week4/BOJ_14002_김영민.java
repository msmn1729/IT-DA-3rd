import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14002_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> tempResult = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int [] A = new int[N];
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int [] length = new int [N]; //부분수열의길이
		int [] index = new int [N];  //부분수열의속하는값들에대한인덱스
		
		Arrays.fill(index, -1); //인덱스 -1로 초기화 0에 접근할 수도 있기 때문에
		
		for(int i=0; i<N; i++) {
			length[i]=1;
			for(int j=0; j<N; j++) {
				if(A[j]<A[i] && length[i] <= length[j]) {
					length[i] = length[j]+1; //부분수열길이
					index[i] = j; // 해당인덱스를저장
				}
			}
		}
		
		int max = 0; //가장긴부분수열의길이
		for(int i=0; i<N; i++)
			if(length[i]>max) max = length[i];
		System.out.println(max);
		
		for(int i=0; i<N; i++) {
			if(length[i]==max) { //max일경우해당A값가져오기
				result.add(A[i]);
				tempResult.add(index[i]); //index값으로추적하기위해
                break;
			}
		}
		
		for(int i=0; i<tempResult.size(); i++) {
			int temp = tempResult.get(i); //index값을가져와서
			if(temp!=-1) { //-1이아니면
				result.add(A[temp]); //해당값저장하고
				tempResult.add(index[temp]); //해당인덱스값저장해서반복수행
			}
		}
		
		Collections.reverse(result); //max부터값을넣었기때문에reverse
	
		for(int i=0; i<max; i++) 
			System.out.print(result.get(i)+" ");
	}
}
