public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length ==0) return 0;
        
        int currentMax = nums[0];
        int currentMin = nums[0];
        int max = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int val = nums[i] * currentMax;
            currentMax = Math.max(Math.max(val, nums[i]), nums[i]*currentMin);
            currentMin = Math.min(Math.min(val, nums[i]), nums[i]*currentMin);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}