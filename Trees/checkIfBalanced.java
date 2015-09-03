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
    
    public int depth(TreeNode node){
        if(node == null)
            return 0;
            
        int left = depth(node.left);
        int right = depth(node.right);
        
        if(left == -1 || right == -1){
            return -1;
        }
        
        if(left -right > 1 || right - left > 1){
            return -1;
        }
        
        return Math.max(left, right)+1;
    }
    
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int d = depth(root);
        System.out.println(d);
        if(d == -1){
            return false;
        }else{
            return true;
        }
        
    }
}
