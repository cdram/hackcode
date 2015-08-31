/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * https://www.dropbox.com/s/fn09720tqzi28kk/Screenshot%202015-08-03%2018.46.43.png?dl=0
 */
public class Solution {
    
    
    public void connect(TreeLinkNode root) {
        if(root != null){
        
        if(root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = null;
        }
        
        if(root.next != null){
            root.right.next = root.next.left;
        }
        
        if(root.left != null)  connect(root.left);
        if(root.right != null) connect(root.right);
    }
    }
}