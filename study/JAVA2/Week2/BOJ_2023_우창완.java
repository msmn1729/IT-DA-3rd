import java.io.*;
//문제의 메모리 조건을 안보고 소수를 구별해내는 에라토스테네스의 체로 풀려고 시도함 하지만 문제의 메모리 조건 4mb이여서 10^8승의 문제조건으로는 풀지 못한다
//또한 top down 방식으로 풀 시에, 소수를 판별해내는 시간 복잡도O(N^2)이므로 TOP DOWN 보다는 Bottom-up이 적절하다.
//public class BOJ_2234_우창완 {
//	public static int []array =new int[10000001];
//	private static BufferedWriter wr= new BufferedWriter(new OutputStreamWriter(System.out));
//	
//	public static void dfs(int first, int cur, int number) throws IOException {
//		if(number==0) {
//			System.out.println(first);
//			return;
//		}
//		int temp=cur/10;
//		
//		if(array[temp]!=0) {
//			dfs(first, temp , number-1);
//		}else {
//			return;
//		}
//	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String temp[]=br.readLine().split(" ");
//		int number=Integer.parseInt(temp[0]);
//		double min= Math.pow(10, number-1);
//		double max=Math.pow(10, number)-1;
//		array[1]=0;
//		for(int i=2; i<=max; i++) {
//			array[i]=i;
//		}
//		for(int i=2; i*i<=max; i++) {
//			if(array[i]==0) continue;
//			for(int j=2*i; j<=max; j=j+i) {
//				array[j]=0;
//			}
//		}
//		for(int i=(int) min; i<=max; i++) {
//			//n의 자리 숫자중에서 소수가 아닌 수의 n-1자리 검사
//			if(array[i]!=0) {
//				dfs(array[i],array[i],number-1);
//			}
//		}
//		wr.flush();
//		wr.close();
//	}
//}
public class BOJ_2023_우창완{
	private static BufferedWriter wr= new BufferedWriter(new OutputStreamWriter(System.out));
	public static int number;
	
	public static boolean isDecimal(int num) {
		//소수일때 true 를 반환한다.
		for(int i=2; i<num; i++){
			if(num%i==0) return false;
		}
		return true;
	}
	public static void dfs(int current, int cnt) {
		if(number==cnt) {
			if(isDecimal(current)) System.out.println(current);
		}
		int temp=current*10;
		for(int i=1; i<=9; i+=2) {
//			왼쪽에서부터 10의 자리, 100의 자리 ,,,N-1의 자리가 소수인지 체크
			int target=temp+i;
			if(isDecimal(target)) {
				dfs(target, cnt+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String temp[]=br.readLine().split(" ");
		number = Integer.parseInt(temp[0]);
//		소수가 되려면 앞자리가 2,3,5,7 중에 하나여야 한다
		int [] deci= {2,3,5,7};
		for(int i=0; i<4; i++) {
			dfs(deci[i],1);
		}
	}
}