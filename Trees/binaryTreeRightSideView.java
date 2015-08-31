/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * } https://www.dropbox.com/s/93hjz7q3hfm3glf/Screenshot%202015-08-03%2018.49.19.png?dl=0
 */
public class Solution {
    public List<Integer> rightSideViewHelper(TreeNode root, List<Integer> list, int level) {
        if(root == null) return list;
        
        if(list.size()-1 >= level){
            list.set(level, root.val);
        }else{
            list.add(root.val);
        }
        list = rightSideViewHelper(root.left, list, level + 1);
        list = rightSideViewHelper(root.right, list, level + 1);
        return list;
    }
        
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return rightSideViewHelper(root, list, 0);
    }
}