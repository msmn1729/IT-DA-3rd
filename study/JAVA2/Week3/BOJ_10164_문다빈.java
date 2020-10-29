import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Course {
	public static void main(String[] args) throws IOException {
		//아래로 인접 : +m 동쪽으로 인접 : +1
		int check[];//1번째 차원 : 그 항까지 가는데 걸린시간, 2번쨰 차원 : 그 항의 수
		int n, m;
		int K;
		int temp;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(m == 1 || n == 1) {
			System.out.println(1);
		}
		else {
			if(K != 0) {
				if(K % m == 0) {
					check = new int[K + 1];
					for(int i = 1; i <= K; i++) {
						if(i >= 1 && i <= m)
							check[i] = 1;
						else if(i % m == 1) 
							check[i] = 1;
						else {
							check[i] = check[i - 1] + check[i - m];
						}
					}
					System.out.println(check[K]);
				}
				else if(K % m == 1) {
					check = new int[m * (n - (K / m)) + 1];
					for(int i = 1; i <= m * (n - (K / m)); i++) {
						if(i >= 1 && i <= m)
							check[i] = 1;
						else if(i % m == 1) 
							check[i] = 1;
						else {
							check[i] = check[i - 1] + check[i - m];
						}
					}
					System.out.println(check[m * (n - (K / m))]);
				}
				else {
					check = new int[((K / m) + 1) * (K % m) + 1];
					for(int i = 1; i <= ((K / m) + 1) * (K % m); i++) {
						if(i >= 1 && i <= K % m)
							check[i] = 1;
						else if(i % (K % m) == 1) 
							check[i] = 1;
						else {
							check[i] = check[i - 1] + check[i - (K % m)];
						}
					}
					
					temp = check[((K / m) + 1) * (K % m)];
					check = new int[(n - (K / m)) * ((m - (K % m)) + 1) + 1];
					
					for(int i = 1; i <= (n - (K / m)) * ((m - (K % m)) + 1); i++) {
						if(i >= 1 && i <= ((m - (K % m)) + 1))
							check[i] = 1;
						else if(i % ((m - (K % m)) + 1) == 1) 
							check[i] = 1;
						else {
							check[i] = check[i - 1] + check[i - ((m - (K % m)) + 1)];
						}
					}
					
					temp = temp * check[(n - (K / m)) * ((m - (K % m)) + 1)];
					System.out.println(temp);
				}
			}
			else {
				check = new int[(m * n) + 1];
				for(int i = 1; i <= m * n; i++) {
					if(i >= 1 && i <= m)
						check[i] = 1;
					else if(i % m == 1) 
						check[i] = 1;
					else {
						check[i] = check[i - 1] + check[i - m];
					}
				}
				System.out.println(check[m * n]);
			}
		}
	}
}
