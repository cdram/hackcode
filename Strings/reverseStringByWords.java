import java.io.*;
import java.util.*;


class ReverseString{
			
	private static char[] reverse(char[] arr, int start, int end){
		while(start < end){
			Character c = arr[start];
			arr[start] = arr[end];
			arr[end] = c;
			start++;
			end--;
		}		
		return arr;
	}
		
	public static void main(String[] args){
		String s = "Hey! How are you?";
		char[]arr = s.toCharArray();

		int  i =0, start=0;
		while(i<arr.length){
			if(arr[i] == ' '){
				arr = reverse(arr, start, i-1);
				start = i+1;
			}
			i++;
		}
		arr = reverse(arr, start, i-1);
		arr = reverse(arr, 0, arr.length-1);
		System.out.println("Input => " + s);
		System.out.println("Reverse => " + new String(arr));
	}
	
}