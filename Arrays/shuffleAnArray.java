import java.io.*;
import java.util.*;



class Shuffle{


	public static void main(String[] args){
		Random random = new Random();
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		for(Integer i : numbers){
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		for(int i = numbers.length-1;i>0 ; i--){
			int pos = random.nextInt(i+1);
			int temp = numbers[i];
			numbers[i] = numbers[pos];
			numbers[pos] = temp;
		}
		

		for(Integer i : numbers){
			System.out.print(i + " ");
		}
		
	}
}