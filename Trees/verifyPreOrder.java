public class Solution {
    
    private boolean helper(int[] preorder, int start, int end, int min, int max){
        if(start > end) return true;
        
        int root = preorder[start];
        if(root > max ||root < min) return false;
        int index = start;
        
        while(index <= end && preorder[index] <= root) index++;
        return helper(preorder, start+1, index-1, min, root) && helper(preorder, index, end, root, max);
    }
    
    public boolean verifyPreorder(int[] preorder) {
        
        return (preorder == null || preorder.length == 0 || preorder.length == 1 || preorder.length == 2)?true:helper(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}