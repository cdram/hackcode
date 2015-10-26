/***
	Write a function that given an array representation of a binary tree will convert it into a typical tree format.
	The following is a visual representation of expected input and output:

	Input: [7, 3, 9, 2, 4, 8, 10]
	Output:
	7
	/ \
	3 9
	/\ /\
	2 4 8 10
***/
import java.util.*;
import java.io.*;

class Node{
	int val;
	Node left;
	Node right;
	
	public Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class ArrToTree{	
	
	private static Node convertArrayToTree(int[] arr){
		Queue<Node> q = new LinkedList<Node>();

		Node node = new Node(arr[0]);
		q.add(node);
		
		int count = 0;
		
		while((2*count)+1 < arr.length-1){
			Node n = q.poll();
			n.left = new Node(arr[(2*count)+1]);
			q.add(n.left);
			
			if((2*count)+2 < arr.length-1){
				n.right = new Node(arr[(2*count)+2]);
				q.add(n.right);
			}
			count = count + 1;	
		}
		
		return node;
	}
	
	private static void inorder(Node root){
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}	
	
	public static void main(String[] args){
		int [] arr = {7, 3, 9, 2, 4, 8, 10};
		System.out.println("Input Array : " + Arrays.toString(arr));
		inorder(convertArrayToTree(arr));
		
		int [] arr1 = {7, 3, 9, 2, 4, 8};
		System.out.println("Input Array : " + Arrays.toString(arr1));
		inorder(convertArrayToTree(arr1));
	}

}