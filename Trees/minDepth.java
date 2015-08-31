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
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int l = minDepth(root.left), r = minDepth(root.right), min = Math.min(l,r);
        return ((min > 0?min:Math.max(l,r))+1);
    }
    
}