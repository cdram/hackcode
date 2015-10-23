/***
	Given a sorted array of integers, find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
***/
public class Solution {
    
    private int[] helper(int[] nums, int start, int end, int target, int[] op){
        while(start <= end){
            int mid = start + ((end-start)/2);
            if(nums[mid] == target){
                op[0] = (op[0]==-1)?mid:Math.min(op[0], mid);
                op[1] = (op[1]==-1)?mid:Math.max(op[1], mid);
                //perform binary search for left of mid
                //cos the target might be a duplicate
                op = helper(nums, start, mid-1, target, op);
                //perform binary search for right of mid
                //cos the target might be a duplicate
                op = helper(nums, mid+1, end, target, op);
                return op;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        return op;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] op = {-1,-1};
        return helper(nums, 0, nums.length-1, target, op);
    }
}