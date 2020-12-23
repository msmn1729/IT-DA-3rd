import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062_김영민 {
	static int N, K;
	static String [] word;
	static int result=0;
	// a b c d e , f g h i j , k l m n o , p q r s t , u v w x y z	
	static boolean [] alphabet = new boolean [26];
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
		
		for(int i=0; i<N; i++) word[i] = br.readLine().replaceAll("[acint]", "");
		
		if(kCheck(K)==0) return;
		else {
			learn();
			K -= 5; //acint
		}
		
		dfs(0,0);
		System.out.print(result);
	}
	
	static void learn() {
		alphabet[0] = true; //a
		alphabet[2] = true; //c
		alphabet[8] = true; //i
		alphabet[13] = true; //n
		alphabet[19] = true; //t
	}
	
	static int kCheck(int K) {
		if(K<5) { //antic도배우지못할경우
			System.out.print(0);
			return 0;
		}
		else if(K==26) { //모든알파벳을배울수있으면
			System.out.print(N);
			return 0;
		}
		else return 1; //antic를배운경우
	}
	
	static void dfs(int idx, int count) {
		if (count == K) {
			solve();
			return;
        }
        for (int i = idx; i < 26; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                dfs(i, count + 1);
                alphabet[i] = false;
            }
        }
	}
	
	static void solve() {
		int count = 0;
        boolean check = true;
        for (int i = 0; i < N; i++) {
            String temp = word[i];
            for (int j = 0; j < temp.length(); j++) {
                if (!alphabet[temp.charAt(j)-'a']) {
                    check = false;
                    break;
                }
            }
            if(check) count++;
        }
        result = Math.max(count, result);
	}
}
