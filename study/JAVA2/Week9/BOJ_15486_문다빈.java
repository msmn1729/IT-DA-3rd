import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Goodbye {

	public static void main(String[] args) throws IOException {
		// �ູ�� �賶������ ����غ���
		int n;
		int start;
		long price;
		long value[];
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		n = Integer.parseInt(br.readLine());
		value = new long[n+2];//������ �ε����� ������� ���ϴ�..
				
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = i + Integer.parseInt(st.nextToken());
			price = Long.parseLong(st.nextToken());
			if(start <= n+1)
				value[start] = Math.max(value[start], value[i] + price);
			if(value[i] > value[i+1])
				value[i+1] = value[i];
		}
				
		System.out.println(value[n+1]);
	}

}
