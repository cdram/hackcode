/***
	Given a collection of numbers that might contain duplicates, return all possible unique permutations.

	For example,
	[1,1,2] have the following unique permutations:
	[1,1,2], [1,2,1], and [2,1,1].
***/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for(int i=0;i<nums.length;i++) input.add(nums[i]);
        return helper(list, input, 0);
    }
    
    private List<List<Integer>> helper(List<List<Integer>> list, List<Integer> input, int index){
        if(index >= input.size()){
            list.add(new ArrayList<Integer>(input));
            return list;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=index;i<input.size();i++){
            if(!set.contains(input.get(i))){
                set.add(input.get(i));
                swap(input, i, index);
                list = helper(list, input, index+1);
                swap(input, i, index);
            }
        }
        return list;
    }
    
    private void swap(List<Integer> input, int i, int j){
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }
}