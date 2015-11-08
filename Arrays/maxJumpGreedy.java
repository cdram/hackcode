/***
	Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Determine if you are able to reach the last index.

	For example:
	A = [2,3,1,1,4], return true.

	A = [3,2,1,0,4], return false.
***/
public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int jump = nums[i];
    
        //start from the first position to the jump. Idea is at any point of time, we calculate the max Jump
        //we can do. Once we reach that max-jump position we will figure out whether we can complete the next jump,
        //if not we return false
        for(i=0;i<=jump;i++){
            jump = Math.max(jump, i+nums[i]);
            if(jump >=  nums.length-1) return true;
        }
        return false;
    }
}