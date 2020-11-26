package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 현우는 앞으로 N일  
 * M번만 통장에서 돈을 빼서 쓰기로 하였다. 
 * 현우는 통장에서 K원을 인출하며, 
 * 통장에서 뺀 돈으로 하루를 보낼 수 있으면 그대로 사용하고, 
 * " 모자라게 되면 남은 금액은 통장에 집어넣고 " 다시 K원을 인출한다. 
 * 
 * 다만 현우는 M이라는 숫자를 좋아하기 때문에, 
 * 정확히 M번을 맞추기 위해서 
 * 남은 금액이 그날 사용할 금액보다 많더라도 
 * 남은 금액은 통장에 집어넣고 
 * 다시 K원을 인출할 수 있다. 
 * 
 * 현우는 돈을 아끼기 위해 
 * 인출 금액 K를 최소화하기로 하였다. 
4 4
100
400
300
100
 * 현우가 필요한 최소 금액 K를 계산하는 프로그램을 작성하시오.
 */


public class Q6236 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int day = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int arr[] = new int[day];
		for(int i=0;i<day;i++) {arr[i]=Integer.parseInt(br.readLine());}
		
		int low = 1;
		int high = 100000;
		
		while(low<=high) {
			int mid = (low+high)/2;
			int cnt = 1;//출금 
			int money = mid;//현재 돈  
			
			//mid값이 너무 작을 때 
			boolean flag = false;
			
			for(int i=0;i<day;i++) {
				if(mid<arr[i]) {
					flag =true;
					break;
				}
				if(money-arr[i]<0) {
					money = mid;
					cnt +=1;
				}
				money = money-arr[i];
			}
			
			//System.out.println(cnt+"\t"+mid+"\t"+money);
			
			if(flag) {low = mid+1;}
			else if(m>=cnt) {high = mid-1;}
			else low= mid+1;
		}
		System.out.println(low);
	}
}
