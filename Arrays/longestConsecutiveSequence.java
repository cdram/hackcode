/***
	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

	Your algorithm should run in O(n) complexity.
***/
public class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 1;
        Set<Integer> set =  new HashSet<Integer>();
        
        //form a de-duplicated set of numbers
        for(Integer i : nums){
            set.add(i);
        }
        
        for(int i=0;i<nums.length;i++){
            int currentCount = 1;
            
            //look for numbers immediately less the current one
            int current = nums[i]-1;
            while(set.contains(current)){
                currentCount++;
                set.remove(current);
                current = current-1;
            }
            //look for numbers immediately greater the current one
            current = nums[i]+1;
            while(set.contains(current)){
                currentCount++;
                set.remove(current);
                current = current+1;
            }
            //maintain the maximum count
            maxCount = Math.max(maxCount, currentCount);
        }
        
        return maxCount;
    }
}