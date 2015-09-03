/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public int leftHeight(TreeNode root){
        return (root==null)?0:leftHeight(root.left)+1;
    }
    
    public int rightHeight(TreeNode root){
        return (root==null)?0:rightHeight(root.right)+1;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lH = leftHeight(root);
        int rH = rightHeight(root);
        
        if(lH == rH) return (2<<lH-1)-1;
        return 1+ countNodes(root.left)+countNodes(root.right);
    }
}
