import java.util.Scanner;

class Node{
	Node left;
	Node right;
	int val;
	
	Node(int val){
		this.val = val;
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		
		Node root = new Node(r);
		
		while(s.hasNext()) {
			int n = s.nextInt();
			root = insertNode(root, n);
		}
	}
	
	public static Node insertNode(Node node, int input) {
		Node curNode = null;
		
		if(node == null) {
			Node n = new Node(input);
			return n;
		}
		
		//왼쪽
		if(node.val > input) {
			curNode = insertNode(node.left, input);
			node.left = curNode;
			//node.left = new Node(input)
		}
		
		//오른쪽
		else {
			curNode = insertNode(node.right, input);
			node.right = curNode;
		}
		
		return node;
	}

}
