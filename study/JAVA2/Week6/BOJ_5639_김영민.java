import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_김영민 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String number;
		while((number = br.readLine()) != null && number.length() != 0) {
			Node node = new Node(Integer.parseInt(number));
			makeTree(root, node);
		}
		
		postorder(root);
	}

	static void makeTree(Node from, Node to) {
		if(from.number > to.number) {
			if(from.left!=null) makeTree(from.left, to);
			else from.left=to;
		}
		else {
			if(from.right!=null) makeTree(from.right, to);
			else from.right=to;
		}
	}
	
	static void postorder(Node root) {
		if(root.left != null) postorder(root.left);
		if(root.right != null) postorder(root.right);
		System.out.println(root.number);
	}
}

class Node {
	int number;
	public Node(int number) {
		this.number = number;
	}
	Node left;
	Node right;
}