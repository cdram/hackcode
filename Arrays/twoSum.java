public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] output = new int[2];
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                output[0] = map.get(nums[i])+1;
                output[1] = i+1;
                break;
            }else{
                map.put(target-nums[i], i);
            }    
        }
        return output;
    }
}