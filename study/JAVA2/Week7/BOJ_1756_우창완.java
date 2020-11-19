import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1756_우창완 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String []temp=br.readLine().split(" ");
		int depth=Integer.parseInt(temp[0]);
		int n=Integer.parseInt(temp[1]);
		int []radius= new int[depth];
		int []dow= new int[n];
		temp=br.readLine().split(" ");
		String[] temp2=br.readLine().split(" ");
		
		for(int i=0; i<depth; i++)	radius[i]=Integer.parseInt(temp[i]);
		for(int i=0; i<n; i++)	dow[i]=Integer.parseInt(temp2[i]);

		int min=1000000000;
		for(int i=0; i<depth; i++) {
			min=Math.min(radius[i], min);
			radius[i]=min;
		}
		int pos=depth;
		for(int i=0; i<n; i++) {
			int start=0;
			int end=pos-1;
			int target=dow[i];
			while(start<=end) {
				int mid= (start+end)/2;
				if(target>radius[mid]) {
					end=mid-1;
				}
				else {
					//작거나 같을때 
					start=mid+1;
					pos=mid;
				}
			}
		}
		if(pos<0) {
			System.out.println(0);
		}else {
			System.out.println(pos+1);
		}
	}
}
