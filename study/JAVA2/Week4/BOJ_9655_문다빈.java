import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stone {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//Â¦¼ö°³¸é Ã¢¿µÀÌ ½Â, È¦¼ö°³¸é »ó±ÙÀÌ ½Â
		int N;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}

}
