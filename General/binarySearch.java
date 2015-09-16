import java.io.*;




class BSearch{
	
	
	private static int performBSearch(int[] arr, int target){
		int left = 0;
		int right = arr.length -1;
		int mid = 0;		
		
		
		while(left <= right){
			mid = left + (right-left)/2;
			if(arr[mid] == target) return mid;
			else if(arr[mid] > target){
				right = mid-1;
			}else{
				left = mid+1;
			}			
		}
		return -1;
	}

	
	public static void main(String args[]){
		int [] arr = {0,1,2,4,5,6,6,6,6,7};
		System.out.println("Index of 6 " + performBSearch(arr,6));
		System.out.println("Index of 3 " + performBSearch(arr,3));		
	}
		
	
}