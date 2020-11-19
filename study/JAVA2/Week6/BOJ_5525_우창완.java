import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_¿ìÃ¢¿Ï {
	private static int ans=0;
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j=0;
		for(int i=1;i<pattern.length();i++) {
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i)==pattern.charAt(j)) 
				pi[i] =++j;
		}
		return pi;
	}
	static void KMP(String origin, String ptn) {
		int[] pi = getPi(ptn);
		int j=0;
		for(int i=0;i<origin.length();i++) {
			while(j>0 && origin.charAt(i)!=ptn.charAt(j)) {
				j=pi[j-1];
			}
			if(origin.charAt(i)==ptn.charAt(j)) {
				if(j==ptn.length()-1) {
					ans++;
					j=pi[j];
				}
				else	j++;
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		String origin=br.readLine();
		StringBuilder pattern = new StringBuilder("I");
		for(int i=0; i<n; i++) {
			pattern.append("OI");
		}
		KMP(origin,pattern.toString());
	}



}
