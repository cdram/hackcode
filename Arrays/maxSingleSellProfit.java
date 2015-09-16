import java.io.*;
import java.util.*;
import java.lang.*;




class SingleSell{
	
	
	private static int performSingleSell(int[] arr){
		if(arr.length == 0) {
		            return 0;
		        }
		        int profit = 0;
		        int cheapest = arr[0];

		        for (int i = 0; i < arr.length; i++) {

		            cheapest = Math.min(cheapest, arr[i]);
		            profit = Math.max(profit, arr[i] - cheapest);

		        }
		        return profit;
		
	}

	
	public static void main(String args[]){
		int [] arr = { 2, 7, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5};
		System.out.println("Index of 6 " + performSingleSell(arr));
	}
		
	
}