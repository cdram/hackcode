import java.io.*;
import java.util.*;


class MergeSort{
	
	private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right, List<T> list){
		
		int lLen =  left.size();
		int rLen =  right.size();
		int len = list.size();
		int i=0, j=0, k=0;
		while(i<lLen && j < rLen){
			if(left.get(i).compareTo(right.get(j)) < 0){
				list.set(k,left.get(i));
				i++;
				k++;
			}else{
				list.set(k,right.get(j));
				j++;
				k++;
			}				
		}
		
		while(i < lLen){
			list.set(k,left.get(i));
			i++;
			k++;
		} 
		
		while(j < rLen){
			list.set(k,right.get(j));
			j++;
			k++;
		} 
		
		return list;
	}	
		
	
	private static <T extends Comparable<T>> List<T> mergeSort(List<T> list){
		if(list.size() < 2) return list;
		int mid = list.size()/2;
		
		List<T> left = new  ArrayList<T>(mid);
		List<T> right = new  ArrayList<T>(list.size()-mid);
		
		for(int i=0;i<mid;i++) left.add(list.get(i));
		for(int i=mid;i<list.size();i++) right.add(list.get(i));
		
		mergeSort(left);
		mergeSort(right);
		return merge(left, right, list);		
	}
	
	
	public static void main(String[] args){
		System.out.println("Sort Integers =>");
		List<Integer> numbers =  Arrays.asList(4,2,8,23,11,5,7,5,5,5);
		numbers = mergeSort(numbers);
		for(Integer t : numbers){
			System.out.println(t);
		}

		System.out.println("Sort Strings =>");		
		List<String> places = Arrays.asList("La Plata", "Buenos Aires", "Córdoba");
		places = mergeSort(places);
		for(String s : places){
			System.out.println(s);
		}
		
	}
}
