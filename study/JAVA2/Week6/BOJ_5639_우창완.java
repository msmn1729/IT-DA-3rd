import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_5639_¿ìÃ¢¿Ï {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list=new ArrayList<>();
		int cnt =0;
		Scanner sc=new Scanner(System.in);
		String n;
		while((n=br.readLine())!=null&& n.length()!=0) {
			list.add(Integer.parseInt(n));
			cnt++;
		}
	}

}
