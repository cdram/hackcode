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
    public List<List<Integer>> pathSum(TreeNode root, int sum, List<List<Integer>> list, List temp) {
        if(root == null) return list;
        
        temp.add(root.val);
        
        if(sum - root.val == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<Integer>(temp));
        }else{
            list = pathSum(root.left, sum - root.val, list, temp);
            list = pathSum(root.right, sum - root.val, list, temp);
        }
        
        temp.remove(temp.size()-1);
        return list;
    }
        
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List temp = new ArrayList<Integer>();
        return pathSum(root, sum, list, temp);
    }
}