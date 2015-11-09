import java.io.*;
import java.util.*;


class LocalMinima{
	
	private static int localMinima(int[] nums, int start, int end){
		
		while(start <= end){
				int mid = start + ((end-start)/2);
				if(mid-1 < 0 && mid+1 >= nums.length) return -1;
				if(nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1]) return nums[mid];
				if(nums[mid-1] < nums[mid]){
					end = mid;
				}else{
					start = mid;
				}
		}
		return -1;
	}
	
	private static int localMaxima(int[] nums, int start, int end){
		
		while(start <= end){
				int mid = start + ((end-start)/2);
				if(mid-1 < 0 && mid+1 >= nums.length) return -1;
				if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) return nums[mid];
				if(nums[mid-1] < nums[mid]){
					end = mid;
				}else{
					start = mid;
				}
		}
		return -1;
	}

	public static void main(String[] args){
		int[] nums = {9,7,2,8,5,6,3,4};
		int minima = localMinima(nums, 0, nums.length-1);
		int maxima = localMaxima(nums, 0, nums.length-1);
		System.out.println("Local Minima => " + Arrays.toString(nums) + " => " + minima); 
		System.out.println("Local Maxima => " + Arrays.toString(nums) + " => " + maxima); 
	}

}
