/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * } https://www.dropbox.com/s/8q6pvl1rznyvrjl/Screenshot%202015-08-03%2018.47.29.png?dl=0
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null) return true;
        else if(p == null || q == null) return false;
        else if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}