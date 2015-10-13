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
    
    //find the next Minimum node, given a node
    //ie. the left most node
    private TreeNode findMin(TreeNode node){
        if(node == null) return null;
        else if(node.left == null) return node;
        else return findMin(node.left);
    }
    
    //find the parent of a node
    private TreeNode findParent(TreeNode root, TreeNode p){
        if(root == p) return null;
        if(root.left == p || root.right == p) return root;
        return (p.val < root.val)?findParent(root.left, p):findParent(root.right, p);
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p == null) return p;
        //if the node has a right node, then find the minimum across of the right node's tree
        if(p.right != null) return findMin(p.right);
        //if the node doesnt have a right node, then get the parent
        TreeNode parent = findParent(root, p);
        //loop until the parent is either null or > then the requested node
        while(parent != null && parent.val < p.val){
            parent = findParent(root, parent);
        }
        //return parent
        return parent;
    }
}