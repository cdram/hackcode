import java.io.*;
import java.util.*;


class TreeNode{
	int val;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(int val){
		this.val = val;
	}
	
}


class TwoSum{
		
	private static Boolean performTwoSum(TreeNode root, int target){
		Stack<TreeNode> forward = new Stack<>();
		Stack<TreeNode> reverse = new Stack<>();
		TreeNode fwd = root;
		TreeNode rev = root;
		Boolean flag1 = false;
		Boolean flag2 = false;
		int val1 = 0, val2 = 0;
		
		while(true){
			
			//perform forward in-order
			while(!flag1){
				if(fwd != null){
					forward.push(fwd);
					fwd = fwd.left;
				}else if(forward.isEmpty()){
					flag1 = true;
				}else{
					fwd = forward.pop();
					val1= fwd.val;
					fwd = fwd.right;
					flag1 = true;
				}		
			}
			
			//perform reverse in-order
			while(!flag2){
				if(rev != null){
					reverse.push(rev);
					rev = rev.right;
				}else if(reverse.isEmpty()){
					flag2 = true;
				}else{
					rev = reverse.pop();
					val2= rev.val;
					rev = rev.left;
					flag2 = true;
				}		
			}
			
			//if pair found return true
			if(val1 != val2 && (val1 + val2) == target){
				System.out.println("TwoSum Found => " + val1 + " & " + val2);
				return true;	
			}else if((val1 + val2) < target){ //if the sum is lesser than target, then start processing the normal in-order
				flag1 = false;
			}else if((val1 + val2) > target){ // if the sum is greater than target, start progressing the reverse in-order
				flag2 = false;
			}
			if(val1 >=  val2){ // if the any in-order completes one side of the tree, break!
				return false;
			}
		}
		
	}
		
	
	public static void main(String args[]){
		
		//create BST				
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
	    root.right.left = new TreeNode(16);
	    root.right.right = new TreeNode(25);
		int target = 33;
		
		System.out.println("Target => " + target);
		if(!performTwoSum(root, target)){
			System.out.println("No Pair Found!");
		}
		
		System.out.println("\n");
		target = 99;
		System.out.println("Target => " + target);
		if(!performTwoSum(root, target)){
			System.out.println("No Pair Found!");
		}
		
	}
	
}

