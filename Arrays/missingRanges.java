/***
	Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
	For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
***/
public class Solution {
  
    //if both start and end are same, then we just need one entry, else get the range
    public String getRangeString(int start, int end){
        return (start==end)?String.valueOf(start):(start+"->"+end);
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        //if input array is empty, then just generate the range between lower and upper
        if(nums.length==0){
            list.add(getRangeString(lower, upper));
            return list;
        }
        
        //if the first element and the lower vary by more than 0, then it means that the input array starts
        //atleast by +1 of lower, so we need to at the minimum add the lower as an entry for output. So we 
        //generate the range of lower, first_element-1
        if(nums[0]-lower>0){
            list.add(getRangeString(lower, nums[0]-1));
            //set the lower as first element
            lower = nums[0];
        }
        
        //now just loop over the array finding the range if the difference is >=2. If the difference is just 1 then it
        //means that the two elements are contiguous, so no need to worry. If its 2 then it means we atleast miss one element,
        //so we find the range of lower+1, current_element-1
        for(int i=1;i<nums.length;i++){
            if(nums[i]-lower >=2){
                list.add(getRangeString(lower+1, nums[i]-1));
            }    
            lower = nums[i];
        }
        
        //for the last element, we need to get the range between last_element+1 and the upper
        if(lower+1 <= upper){
            list.add(getRangeString(lower+1, upper));
        }
        
        //return the list
        return list;
    }
}