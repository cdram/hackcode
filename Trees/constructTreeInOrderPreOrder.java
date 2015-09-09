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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int iStart = 0, iEnd = inorder.length -1;
        int pStart = 0, pEnd = inorder.length -1;
        return construct(inorder, iStart, iEnd, preorder, pStart, pEnd);
    }
    
    private TreeNode construct(int[] inorder, int iStart, int iEnd, int[] preorder, int pStart, int pEnd){
        if(iStart > iEnd) return null;
        if(pStart > pEnd) return null;
        if(iStart == iEnd) return new TreeNode(inorder[iStart]);
            
        int index = 0;
        for(int i=0;i< inorder.length;i++){
            if(preorder[pStart] == inorder[i]){
                index = i;
                break;
            }
        }
        
        TreeNode node = new TreeNode(preorder[pStart]);
        node.left  = construct(inorder, iStart, index-1, preorder, pStart+1, pStart+(index-iStart));
        node.right = construct(inorder, index+1, iEnd, preorder, pStart+index-iStart+1, pEnd);
        
    return node;
    }
}