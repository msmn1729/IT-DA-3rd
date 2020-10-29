package BOJ;

import java.io.IOException;
import java.util.Scanner;

public class Main11 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N%2==0) {
			System.out.println("CY");
		}
		if(N%2!=0) {
			System.out.println("SK");
		}
	}
}
