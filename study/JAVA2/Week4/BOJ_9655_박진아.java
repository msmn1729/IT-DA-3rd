import java.util.Scanner;

/*
간단한 홀짝문제
5
3 1 1 
1 3 1
1 1 1 1 1

4
3 1
1 3
1 1 1 1

 */
public class Main {

	static int dp[] = new int[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
			
			if(N==1) {
				System.out.println("SK");
			}
			if(N==2) {
				System.out.println("CY");
			}
			if(N>=3) {
				if(N%2 ==1) {
					System.out.println("SK");
				}
				else{
					System.out.println("CY");
				}
			}
	}

}
