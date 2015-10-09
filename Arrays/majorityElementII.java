/***
	Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
***/


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int e1 = -1, e2 = -1, c1 = 0, c2 = 0;
        
        //an Array can have at the most only 2 Elements that appear more than n/3 times
        //find the majority elements E1/E2 using Bayer-Moore's
        for(Integer num : nums){
            if(c1==0){
                e1 = num;
                c1++;
            }else if(e1==num){
                c1++;
            }else if(c2==0){
                e2 = num;
                c2++;
            }else if(e2==num){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        
        //reset the counter back to 0 and then increment them based on the identified elements
        c1=0;c2=0;
        for(Integer num : nums){
            if(num==e1) c1++;
            else if(num==e2) c2++;
        }
        
        List<Integer> list = new ArrayList<>();
        if(c1 > nums.length/3) list.add(e1);
        if(c2 > nums.length/3) list.add(e2);
        
        return list;
    }
}