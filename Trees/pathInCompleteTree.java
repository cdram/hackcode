/***

Classical Min/Max Heaps are typically represented using arrays, since they’re complete trees. Imagine, though, that you’re using a Min-Heap represented using nodes. If you know the number of nodes already in the Min-Heap, write an algorithm to describe the path to the next open spot. For example, given the following Min-Heap:

          5
        /   \
      8      10
     / \    /  \
   12   9  13  20
  /  \
 18  15
You can get to the next open spot by going left-right-left from the root (i.e., to the left of the 9). If you know that there are nine elements in the tree, you should be able to come up with this path deterministically, without resorting to searching the tree, doing BFS, etc. Write that algorithm

***/

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