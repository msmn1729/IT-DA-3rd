import java.util.Scanner;

/*
 * 아 
 * 3같은 한자리 소수는 어떻게 거르죠? 
 * 
 * 아 왜 틀리지?????????
 * 왜 ?
 * 
1000000
1003001
 */
public class Q1747 {

	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean flag = false;
		int num=n;
		while(true) {
			if(flag) {
				break;
			}
			num++;
			if(num>10) {
				//소수 판별
				if(isPrime(num)) {
					//팰린드롬 판별 
					// length = 4
					// 0 1 2 3 
					// 3 2 1 0
					String data[] = Integer.toString(num).split("");
					for(int i=0;i<data.length;i++) {
						if(data[i].equals(data[data.length-i-1])) {
							if(i==data.length-1) {
								System.out.println(num);
								flag=true;
								break;
							}
						}else break;
					}
				}
			}
		}
	}

	private static boolean isPrime(int num) {
		for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
	}
}
