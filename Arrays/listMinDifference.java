/***
	Given a List of Numbers get the minimum difference between two numbers across the list.
	The List is unsorted.
***/
import java.io.*;
import java.util.*;

class MinDifference{
	
	private static int getMinDifference(Integer[] arr){
		int val = Integer.MAX_VALUE;
		int min = arr[0];
		int max = arr[0];
		
		for(int i=1;i<arr.length;i++){	
			val = Math.min(Math.min(Math.abs(arr[i]-min), Math.abs(arr[i]-max)), val);
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}
		return val;
	}	
		
	public static void main(String[] args){
		Integer[] arr = {55,99,6,29,1,523,3};					
		System.out.println("The Minimum Difference in  " + Arrays.toString(arr) + " : " + getMinDifference(arr));
		
		Integer[] arr1 = {5,4,8,3,2};					
		System.out.println("The Minimum Difference in  " + Arrays.toString(arr1) + " : " + getMinDifference(arr1));
	}
}