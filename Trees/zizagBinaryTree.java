/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; } https://www.dropbox.com/s/tsklk1jficnggho/Screenshot%202015-08-04%2012.09.02.png?dl=0
 * }
 */
public class Solution {
    
    public List<List<Integer>> zigzagHelper(List<List<Integer>> list, TreeNode root, int level){
        if(root == null) return list;
        
        if(level==0 || list.size()-1 < level){
            List l = new ArrayList<Integer>();
            l.add(root.val);
            list.add(l);
        }else if(list.size()-1 >= level && (level+1)%2 == 0){
            list.get(level).add(0,root.val);
        }else if(list.size()-1 >= level && (level+1)%2 != 0){
            list.get(level).add(root.val);
        }
        
        list = zigzagHelper(list, root.left, level+1);
        list = zigzagHelper(list, root.right, level+1);
        return list;
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list  = new ArrayList<>();
        return zigzagHelper(list, root, 0);
        
    }
}