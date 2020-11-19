package q5639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
// 50 30 24 5 28 45 98 52 60
// 5 28 24 45 30 60 52 98 50
public class BinarySearchTree {
	static Node root;
	static ArrayList<Integer> postorderArr;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		postorderArr = new ArrayList();
		root = new Node(Integer.parseInt(bf.readLine()));
		String str = null;
		while((str = bf.readLine()) !=null && str.length() != 0) {
			Node node = new Node(Integer.parseInt(str));
			putNode(root,node);
		}
		postorder(root);
		for(int i:postorderArr) {
			System.out.println(i);
		}
		
	}
	static void postorder(Node node) {
		if(node.left != null) {
			postorder(node.left);
		}
		if(node.right!= null) {
			postorder(node.right);
		}
		postorderArr.add(node.data);
	}
	static void putNode(Node startNode, Node inputNode) {
		if(startNode.data > inputNode.data) {
			if(startNode.left != null) {
				putNode(startNode.left,inputNode);
			}else {
				startNode.left = inputNode;
			}
		}
		if(startNode.data < inputNode.data) {
			if(startNode.right != null) {
				putNode(startNode.right,inputNode);
			}else {
				startNode.right = inputNode;
			}
		}
		
	}
}
class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
}
