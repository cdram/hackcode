/***
	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
***/

public class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        
        int max = Integer.MIN_VALUE;
        int maxIndex = -1; //index of the maxItem in the array
        int trap = 0;
        int lMax = height[0];
        int rMax = height[height.length-1];
        
        //find the maximum house height's index 
        for(int i=0;i<height.length;i++){
            if(height[i] >  max) {
                maxIndex = i;
                max = height[i];
            }
        }
        
        //traverse the array from the left to the maxIndex
        for(int i=1;i<maxIndex;i++){
            if(height[i] > lMax){
                lMax = height[i];
            }else{
                trap = trap + (lMax-height[i]);
            }
        }
        
        //traverse the array from the right to the maxIndex
        for(int i = height.length-2; i > maxIndex; i--){
            if(height[i] > rMax){
                rMax = height[i];
            }else{
                trap = trap + (rMax-height[i]);
            }
        }
        
        return trap;
    }
}