import java.io.*;
import java.util.*;



class NumberPalindrome{
	
		
	private static String nextGreatestPalindrome(String input){
		//convert the input string num into an integer
		int inputInt = Integer.parseInt(input);
		//if the string is of even length, then we need to start replacement from half length
		//else we preserve the middle character, if its odd length
		int counter = (input.length()%2==0)?0:1;
		char[] arr = input.toCharArray();
		int len = arr.length;
			
		//replace the end part with the first part to form a palindrome
		for(int i = (len/2)+counter;i<len;i++){
			arr[i] = arr[len-1-i];
		}
		
		//get the output integer
		int output = Integer.parseInt(String.valueOf(arr));
		
		//if output < input and middle number isn't 9, then we just increment the middle numbers in case of even,
		// and just the middle number in case of odd
		if(output < inputInt && arr[len/2] != '9'){
			output = output + (int)Math.pow(10, len/2) + ((counter==0)?(int)Math.pow(10,(len/2)-1):0);
		}else if(output < inputInt && arr[len/2] == '9'){
			//if output < input and middle number is 9, then we round of the number to the next greatest 10^n value 191 => 200
			//2992 => 3000 and so one and then call the same method of the new number
			output = (Character.getNumericValue(arr[0]) +1) * (int)Math.pow(10,len-1);
			return nextGreatestPalindrome(String.valueOf(output));
		}
		
		//return the string value
		return String.valueOf(output);
	}
		
		
	public static void main(String args[]){
		String[] nums = {"421", "123", "397", "1234","1997"};
		int[] counter = new int[nums.length];
		
		for(int i=0;i<nums.length;i++){
			System.out.format("The next-greatest palindrome number for %s : %s", nums[i], nextGreatestPalindrome(nums[i]));
			System.out.println();
		}						
	}
	
	
	
}