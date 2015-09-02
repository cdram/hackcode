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
    
    public List<List<Integer>> levelOrderHelper(TreeNode root, int level, List<List<Integer>> list){
        if(root == null)
            return list;
        
        if(list.size()-1 >= level){
            list.get(level).add(root.val);
        }else{
            List l = new ArrayList<Integer>();
            l.add(root.val);
            list.add(l);
        }
        list = levelOrderHelper(root.left, level +1, list);
        list = levelOrderHelper(root.right, level +1, list);
        return list;
    }
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        return levelOrderHelper(root, 0, list);
    }
}
