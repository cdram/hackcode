/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * } https://www.dropbox.com/s/3w7agfw8eferka5/Screenshot%202015-08-03%2018.48.16.png?dl=0
 */
public class Solution {

    public int sumNumbers(TreeNode root, int num){
        num = (num * 10) + root.val;
        if(root.left == null && root.right == null) return num;
        else if(root.left != null && root.right != null) return sumNumbers(root.left, num) + sumNumbers(root.right, num);
        else return (root.left != null)?sumNumbers(root.left, num):sumNumbers(root.right, num);
        
    }
    
    public int sumNumbers(TreeNode root) {
        return (root == null)?0:sumNumbers(root,0);
    }
}