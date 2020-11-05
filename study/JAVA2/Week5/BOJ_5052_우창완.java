import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
//트리로 문자열을 검색해서 풀 수 있지만,, 너무어려워서 정렬로 풀었다
public class BOJ_5052_우창완 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n=Integer.parseInt(br.readLine());
			String []arr=new String[n];
			String answer="YES";
			for(int j=0; j<n; j++) {
				arr[j]=br.readLine();
			}
			//사전순으로 정렬
			Arrays.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			for(int j=0; j<n-1; j++) {
				int len=arr[j].length();
				if(len>arr[j+1].length()) continue;
				if(arr[j].equals(arr[j+1].substring(0, len)))	answer="NO";
			}
			System.out.println(answer);
		}

	}

}
