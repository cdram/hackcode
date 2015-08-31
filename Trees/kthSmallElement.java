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
    
    public List helper(TreeNode root, List list, int k){
        if(root == null) return list;
        helper(root.left, list, k);
        list.add(root.val);
        helper(root.right, list, k);
        return list;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        list = helper(root, list, k);
        return list.get(k-1);
    }
}