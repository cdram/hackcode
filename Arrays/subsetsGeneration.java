/***

	Given a set of distinct integers, nums, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,3], a solution is:

	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]

***/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        
        if(nums.length == 0) return list;
        Arrays.sort(nums);
        
        return helper(list, new ArrayList<Integer>(),nums, 0);
    }
	
		/***
	                  	  1 
	               1,2            1,3     1,4    
	        1,2,3   	1,2,4     1,3,4   
	        1,2,3,4
	    ***/
	
    
    private List<List<Integer>> helper(List<List<Integer>> list, List<Integer> items, int[] nums, int current){
        if(current >= nums.length) return list;
        
        for(int i=current; i < nums.length;i++){
            List<Integer> l = new ArrayList<>(items);
            l.add(nums[i]);
            list.add(l);
            list = helper(list, l, nums, i+1);
        }
        return list;
    }
    
}