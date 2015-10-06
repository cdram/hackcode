import java.util.*;
import java.io.*;




class LexicoRank{	
	
	private static int fact(int input){
		int output = 1;
		for(int i = 2;i<=input;i++){
			output = output * i;			
		}		
		return output;
	}
	
	private static int[] fillArray(int[] charCount, String input){
		Arrays.fill(charCount, 0);
		for(Character c: input.toCharArray()){
			if(charCount[(int)c +1] == 0) charCount[(int)c +1] += 1;
		}
		
		for(int i=1;i<charCount.length;i++){			
			charCount[i] = charCount[i] + charCount[i-1];
		}
		
		return charCount;
	}	
	
	private static int getRank(String input){
		int[] charCount = new int[256];					
		int rank = 1;
		char[] arr = input.toCharArray();
		int combinations = -1;
		int lesser = -1;

				
		//fill the char count array with count of characters less than the current one in the string
		charCount = fillArray(charCount, input);
		
		//store the character count
		
		//Pretty Print the String Character Occurances
		System.out.println("Characters Less than the current character");
		System.out.println("-------------------------------------------");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i] + " => " + charCount[(int)arr[i]]);
		}
		
		System.out.println("Forumlae for Rank Calculation");
		System.out.println("------------------------------");
		//Loop the string characters
		for(int i=0;i<arr.length;i++){
			//total possibilities of character arrangements in the remianing part of the string, eg: first character has (n-1)! possibile combinations
			combinations = (arr.length-(i+1));
			//total number of characters lesser than this chracter in the string 
			lesser = charCount[(int)arr[i]];
			//pretty print the formula for every character
			System.out.println( arr[i] + " => " + Math.min(combinations,lesser) + " * "+ fact(combinations));
			rank = rank + (Math.min(combinations,lesser) * fact(combinations));
		}
		return rank;
	}
	
	
	public static void main(String[] args){
		String[] inputs = {"string", "baa"};				
		for(String input: inputs) System.out.format("\nThe Lexicographic Rank of '%s' : %d \n\n", input, getRank(input));
	}
}