import java.util.*;
import java.io.*;

class QuickSort{
	
	
	private static <T extends Comparable<T>> int getSplitPoint(T[] list, int low, int high){
		T pivot = list[low];
		int left = low + 1;
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
		list[low] = list[left-1];
		list[left-1] = pivot;		
		return left-1;
	}
	
	
	private static <T extends Comparable<T>> T[] sort(T[] list, int low, int high){
		if((high-low)<=0) return list;
		int splitPoint = getSplitPoint(list, low, high);
		sort(list, low, splitPoint-1);
		sort(list, splitPoint+1, high);
		return list;
	}
	
	public static <T extends Comparable<T>> T[] sortList(T[] list){
		if(list.length <=1) return list;
		list = sort(list, 0, list.length-1);
		return list;
	}
	
		
	public static void main(String[] args){
		Integer[] numbers = {4,2,8,23,11,5,7,5,5,5};
		numbers = sortList(numbers);
		for(Integer t : numbers){
			System.out.println(t);
		}
	}
}