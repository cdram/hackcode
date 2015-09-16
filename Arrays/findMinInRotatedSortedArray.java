public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int mid = -1;
        
        while(left <= right){
            mid = left + (right -left)/2;
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) return nums[left];
            else if(nums[left] <= nums[mid]){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return nums[right];
    }
}