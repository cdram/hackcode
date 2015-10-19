/***
	Given a collection of numbers, return all possible permutations.

	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
***/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> input = new ArrayList<Integer>();
        for(int i =0;i<nums.length;i++) input.add(nums[i]);
        return helper(list, input, 0);
    }
    
    private List<List<Integer>> helper(List<List<Integer>> list, List<Integer> input, int index){
        if(index >=  input.size()){
            list.add(new ArrayList<>(input));
            return list;
        }
        
        for(int i=index; i< input.size(); i++){
            swap(input, i, index);
            list = helper(list, input, index+1);
            swap(input, i, index);
        }
        
        return list;
    }
    
    private void swap(List<Integer> input, int i, int j){
        int temp = input.get(j);
        input.set(j, input.get(i));
        input.set(i, temp);
    }
}