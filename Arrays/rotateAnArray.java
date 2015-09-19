public class Solution {
    
    private int[] reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
    
    
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k - nums.length;
        }
            
            int diff =nums.length -k;
            nums = reverse(nums, 0, diff-1);
            nums = reverse(nums, diff, nums.length-1);
            nums = reverse(nums,0, nums.length-1);
    }
}