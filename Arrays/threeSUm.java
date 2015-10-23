/***
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
***/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int  i =0;i<=nums.length-3;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    List<Integer> l =  new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    list.add(l);
                    start++;
                    end--;
                    while(start<end && nums[start] == nums[start-1]) start++;
                    while(start<end && nums[end] == nums[end+1]) end--;
                }else if(nums[i] + nums[start] + nums[end] > 0){
                    end--;
                    while(start<end && nums[end] == nums[end+1]) end--;
                }else{
                    start++;
                    while(start<end && nums[start] == nums[start-1]) start++;
                }
            }
            while(i+1 < nums.length && nums[i+1] == nums[i]) i++;
        }
        
        return list;
    }
}