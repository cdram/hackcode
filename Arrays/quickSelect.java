import java.util.*;
import java.io.*;

class QuickSelect{
	
	
	private static <T extends Comparable<T>> T getSplitPoint(T[] list, int low, int high, int k){
		T pivot = list[low];
 		int left = low+1;
		int right = high;
		
		while(true){
			while(left <= right){
				if(list[left].compareTo(pivot) < 0){
					left++;
				}else{
					break;
				}
			}
			
			while(right > left){
				if(list[right].compareTo(pivot) >  0){
					right--;
				}else{
					break;
				}
			}
			
			//if left has crossed right, then there is no inconsistency
			if(left >= right) break;
			
			//swap the left and right
			T temp = list[right];
			list[right] = list[left];
			list[left] = temp;
			left++;
			right--;			
		}
		
		//swap the left-1 and pivot
		Integer split = left -1;
		list[low] = list[split];
		list[split] = pivot;		
		if(k  == split+1) return pivot;
		else if(k < split+1) return getSplitPoint(list, low, split-1,k);
		else return getSplitPoint(list, split+1, high,k);
	}
	
		
	public static void main(String[] args){
		Integer[] numbers = {1, 23, 12, 9, 30, 2, 50}; // 1,2,9,12,23,30,50
		int k = 7;		
		System.out.println("the "+ k +" th smallest  => " + getSplitPoint(numbers, 0, numbers.length-1, k));				
		System.out.println("the "+ k +" th largest  => " + getSplitPoint(numbers, 0, numbers.length-1, numbers.length-k+1));				
	}
}