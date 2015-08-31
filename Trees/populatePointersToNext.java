/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * https://www.dropbox.com/s/t0xpre574oxuo75/Screenshot%202015-08-03%2018.45.20.png?dl=0
 */
public class Solution {
    public TreeLinkNode nextFinder(TreeLinkNode node){
        if(node == null) return null;
        if(node.left != null) return node.left;
        if(node.right != null) return node.right;
        return nextFinder(node.next);
    }
    
    
    public void connect(TreeLinkNode root) {
        if(root != null){
        
        if(root.left != null) root.left.next = root.right;
        if(root.right != null) root.right.next = null;
        
        
        if(root.next != null && root.right != null){
            root.right.next = nextFinder(root.next);
        }else if(root.next != null && root.left != null){
            root.left.next = nextFinder(root.next);
        }
        
        if(root.right != null)  connect(root.right);
        if(root.left != null)  connect(root.left);
    }
    }
}