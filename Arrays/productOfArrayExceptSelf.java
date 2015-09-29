/*
	Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
	Solve it without division and in O(n)
	For example, given [1,2,3,4], return [24,12,8,6].
	Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 1) return nums;
        int[] output = new int[nums.length];
        
		//fill the output array in after products, ie, ith location is the product of all numbers (i+1 to array.length-1)
        output[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            output[i] = nums[i]*output[i+1];
        }
        
		//fill the input array with before product, ie. ith location is the product of all numbers (0 to i-1)
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i]*nums[i-1];
        }
        
		//set the first number of output to the first location of output array (as its the product of all the after products)
        output[0] = output[1];
		
		//figure out the products of all numbers other than the last one ith element  = (input[i-1]*output[i+1])
        for(int i=1;i<nums.length-1;i++){
            output[i] = nums[i-1]*output[i+1];
        }
		
		//last element will the before product from the input array
        output[nums.length-1] = nums[nums.length-2];
        
		//return the output array
        return output;        
    }
}