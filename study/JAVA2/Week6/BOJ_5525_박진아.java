import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 아 시간초과 난다...
// 흠 
// 아... KMP 알고리즘 문제구나 

public class Q5525 {
	
	static int res=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		int m = Integer.parseInt(br.readLine());	
		String sarr[]= br.readLine().split("");
		//비교 data 
		String tmp[] = new String[n*2+1];
		for(int i=0;i<n*2+1;i++) {
			if(i%2==0) {tmp[i]="I";}
			else {tmp[i]="O";}
		}
		
		
		for(int i=0;i<m;i++) {
			System.out.println(i);
			if(sarr[i].equals("I")) {
				// i ... i+n*2+1
				// 0 ... n*2+1
				for(int j=0;j<n*2+1;j++) {
					if(i+j<m) {
						if(sarr[i+j].equals(tmp[j])) {
							if(j==n*2) {
								res++;
							}
						}
						else{
                            //이미 검사했던 index값 증가시키면 될줄 알았음	
							i+=1;
							break;
						}
					}
				}
			}
		}
		System.out.println(res);
	}
}
