package q1756;


import java.util.Scanner;

public class MakePizza {
	static int start,end;
	static int[] O ;
	static int[] r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D=sc.nextInt();
		int N=sc.nextInt();
		O = new int[D];
		r = new int[N];

		for(int i=0;i<D;i++) {
			O[i] = sc.nextInt();			
		}
		for(int j=0;j<N;j++) {
			r[j]=sc.nextInt();
		}
		
		start = 0;
		end = D;
		for(int i =0;i<N;i++) {
			find(r[i]);
			end--;	//반복문을 할 수록 피자가 end위치에 쌓이는데 이미 쌓인 부분은 제외해야 하므로 end에 -1을 해준다.
			if(end<0) {
				break;
			}
			start =0;
			
		}
		System.out.println(end+1);
	
	}
	static void find(int i) {

			while(start<end) {
				int mid = (start+end)/2;				
				if(i>O[mid]) {
					end=mid;
				}else
					start = mid+1;
		}
	}
	
}
