import java.io.*;
import java.util.*;



class CompleteTree{

	
	private static String getPath(int n){
		//get the height of the complete binary tree
		int height = (int)Math.ceil(Math.log(n+1)/Math.log(2));
		//position of the new node to be inserted (into the heap)
		int node = n+1;
		
		String[] arr = new String[height-1];
		
		while(height > 1){
			//if the node is of even number then its in the left subteee of the parent
			arr[height-2] = (node%2 == 0)?"left":"right";
			//get the parent
			node = node/2;
			//reduce the height to move to the level of the parent
			height--;
		}
				
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args){
		int totalNodes = 9;				
		System.out.format("\nPath to the %d th node from root => '%s' \n",  totalNodes+1, getPath(totalNodes));
			
	}
}