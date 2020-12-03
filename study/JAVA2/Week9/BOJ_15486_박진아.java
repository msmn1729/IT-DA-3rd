import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q14501 {
	
	static int[][] timetable= new int [16][2];
	static int money=0;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());

		String input[];
		for(int i=0;i<n;i++) {
			input=br.readLine().split(" ");
			timetable[i][0]=Integer.parseInt(input[0]);
			timetable[i][1]=Integer.parseInt(input[1]);
		}
		
		//근무 날짜와 벌은 돈 
		Calculate(0,0);
		
		System.out.println(money);
	}

	private static void Calculate(int date, int m) {//
		int nextdate=timetable[date][0]+date;
		int pay = timetable[date][1]; // 급여  10
		
		if(date==n) {
			money=Math.max(m, money);
			return;
		}
		
		//근무안했을 때 
		Calculate(date+1,m);
		
		//근무했을 때 
		if(nextdate<=n) {
			Calculate(nextdate,m+pay);
		}

	}
}
