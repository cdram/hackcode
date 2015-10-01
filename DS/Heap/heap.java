import java.io.*;
import java.util.*;

class Heap<T extends Comparable<T>>{
	
	private ArrayList<T> list;
	
	public Heap(){
		list = new ArrayList<>();
	}
	
	private void siftUp(){
		//k is the last element which has to be sifted up
		int k = list.size()-1;
		//while k < 0, as 0th position is the first element of the array and it has no parent
		while(k > 0){
			int  p = (k-1)/2;
			T item = list.get(k);
			T parent = list.get(p);
			//compare the item to it parent and if the item > parent, we sift up!
			if(item.compareTo(parent) > 0){
				list.set(p, item);
				list.set(k, parent);
				k = p;
			}else{ // else the item is in the right place, so break!
				break;
			}
		}
	}
	
	private void siftDown(){
		//k is the first element of the array which has to be put in the proper position in the heap
		int k = 0;
		int left = (2 * k) +1;
		//the loop works as long as the left child of k is in the bounds of the array,ie. k is not a leaf node
		while(left < list.size()){						
			//initialize the max index as left
			int max = left;
			int right = left + 1;
			
			//check whether k has a right node? 
			if(right < list.size() && list.get(right).compareTo(list.get(left)) > 0){
				//if right child value is greater than the left child, point the max index to right
				max = max + 1;
			}
			
			//compare the item in the max index to the item k, if k is lesser, sift down!
			if(list.get(k).compareTo(list.get(max)) < 0){
				T temp = list.get(k);
				list.set(k, list.get(max));
				list.set(max, temp);
				//reset k as max
				k = max;
				//recompute the left child index
				left = (2 * k) + 1;
			}else{
				//if k > max then k is in the proper position, so we break!
				break;
			}			
		}	
	}
	
	public T delete() throws NoSuchElementException{
		if(list.size() == 0){
			throw new NoSuchElementException();
		}else if(list.size() == 1){
			return list.remove(0);
		}else{
			T item = list.get(0);
			list.set(0, list.remove(list.size()-1));
			siftDown();
			return item;
		}
	}
	
	public void insert(T item){
		list.add(item);
		siftUp();
		System.out.println(list.toString());
	}
	
	
	
	
	
	
	public static void main(String args[]){
		List<Integer> nums = Arrays.asList(3,43,22,123,444,1,2,5,2);
		Heap heap = new Heap();
		for(Integer n : nums){
			heap.insert(n);
		}
		for(Integer n : nums){
			System.out.println(heap.delete());
		}		
	}
	
	
}

