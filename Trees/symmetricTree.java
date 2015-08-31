/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; } https://www.dropbox.com/s/24xh3xsuu35hirc/Screenshot%202015-08-03%2018.48.52.png?dl=0
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        else if(left.val == right.val) return (isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right));
        else return false;
    }
        
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
}