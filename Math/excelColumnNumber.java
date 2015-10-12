/***
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
***/
import java.io.*;
import java.util.*;



class ExcelColumnNumber {
    public static int titleToNumber(String s) {
        int value = 0;
        char[] arr = s.toCharArray();
        int start = (int)'A';
        for(int i = 0;i<arr.length;i++){
            value = value + (int)Math.pow(26,arr.length-1-i)  *((int)arr[i]-start+1);
        }
        return value;
    }
	
	
	public static void main(String[] args){
		System.out.println("Value of AA => " + titleToNumber("AA"));
		System.out.println("Value of ABC => " + titleToNumber("ABC"));	

	}
}