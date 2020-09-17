import java.util.*;

public class Main{

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//각 물통의 용량
		int A_Max = input.nextInt();
		int B_Max = input.nextInt();
		int C_Max = input.nextInt();
		
		//중복 체크를 위해서 
		int check [][][] = new int[A_Max+1][B_Max+1][C_Max+1];
		
		Queue<Integer> A_Multong = new LinkedList<>(); // A물통의 현재 들어있는 용량
		Queue<Integer> B_Multong = new LinkedList<>();
		Queue<Integer> C_Multong = new LinkedList<>();
		
		//A물통이 0 일때 C의 물통의 용량을 담는 정답 list
		ArrayList<Integer> Answer = new ArrayList<>();
		
		//처음에는 A물통 0, B물통 0, C물통 가득 으로 넣어주기
		A_Multong.add(0);
		B_Multong.add(0);
		C_Multong.add(C_Max);
		
		
		while(!A_Multong.isEmpty()) {
			
			int AMul = A_Multong.poll();
			int BMul = B_Multong.poll();
			int CMul = C_Multong.poll();
			
			if(check[AMul][BMul][CMul] == 1) // 이미 간곳이라면
				continue;
			
			if(AMul == 0) { // 정답
				Answer.add(CMul);
			}
			
			check[AMul][BMul][CMul] = 1;
			
			//1. C -> A
			if(AMul + CMul <= A_Max) {
				A_Multong.add(AMul + CMul);
				B_Multong.add(BMul);
				C_Multong.add(0);
				
			}
			
			else {
				A_Multong.add(A_Max);
				B_Multong.add(BMul);
				C_Multong.add(CMul + AMul - A_Max);
			}
			
			//2. C -> B
			if(BMul + CMul <= B_Max) {
				A_Multong.add(AMul);
				B_Multong.add(BMul + CMul);
				C_Multong.add(0);
			}
			
			else {
				A_Multong.add(AMul);
				B_Multong.add(B_Max);
				C_Multong.add(CMul + BMul - B_Max);
			}
			
			//3. B -> A
			if(AMul + BMul <= A_Max) { // A물통에 B물을 다 넣을 수 있다.
				A_Multong.add(AMul + BMul);
				B_Multong.add(0);
				C_Multong.add(CMul);
			}
			
			else { // A물통에 다 넣을 수 없으면, A를 가득 채우고 B는 그 나머지가 담긴다.
				A_Multong.add(A_Max);
				B_Multong.add(BMul + AMul - A_Max);
				C_Multong.add(CMul);
			}
			
			//4. B -> C
			if(CMul + BMul <= C_Max) {
				A_Multong.add(AMul);
				B_Multong.add(0);
				C_Multong.add(CMul + BMul);
			}
			
			else { 
				A_Multong.add(AMul);
				B_Multong.add(BMul + CMul - C_Max);
				C_Multong.add(C_Max);
			}
			
			//5. A -> B
			if(BMul + AMul <= B_Max) {
				A_Multong.add(0);
				B_Multong.add(BMul + AMul);
				C_Multong.add(CMul);
			}
			
			else { 
				A_Multong.add(AMul + BMul - B_Max);
				B_Multong.add(B_Max);
				C_Multong.add(CMul);
			}
			
			//6. A -> C
			if(CMul + AMul <= C_Max) {
				A_Multong.add(0);
				B_Multong.add(BMul);
				C_Multong.add(CMul + AMul);
			}
			
			else { 
				A_Multong.add(AMul + CMul - C_Max);
				B_Multong.add(BMul);
				C_Multong.add(C_Max);
			}
		}
		
		Collections.sort(Answer);
		
		for(int a = 0; a < Answer.size(); a++) {
			System.out.print(Answer.get(a) + " ");
		}
	}

}
