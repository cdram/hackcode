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
    public TreeNode flattenHelper(TreeNode root) {
        if(root == null) return null;
        TreeNode right = root.right;
        
        root.right = flattenHelper(root.left);
        root.left = null;
        TreeNode n = root;
        while(n.right != null) n = n.right;
        n.right = flattenHelper(right);
        return root;
    }
        
    
    public void flatten(TreeNode root) {
        flattenHelper(root.left);
    }
}
