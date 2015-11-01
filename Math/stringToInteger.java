public class Solution {
    //we need this value as Integer.MAX_VALUE = 2147483647. So /10 => 214748364
    //thus we can conclude that when we hit the n-1 th digit is the number is > 214748364, then we will di
    public static final int maxNum = Integer.MAX_VALUE/10;
    
    public int myAtoi(String str) {
        int i = 0;
        int n = str.length();
        int sign  =1;
        int result = 0;
        
        //skip all white spaces
        while(i<n && Character.isWhitespace(str.charAt(i))) i++;
        
        //consider the optional sign + or -
        if(i < n && str.charAt(i) =='-'){
            sign  = -1;
            i++;
        }else if(i < n && str.charAt(i) =='+'){
            i++;    
        }
        
        //loop over all digit formatted characters
        while(i <  n && Character.isDigit(str.charAt(i))){
            int digit = Character.getNumericValue(str.charAt(i));
            //if the result is greater than maxNum then upon adding the new digit,
            //the result will definitely overflow. Else if the result == MaxNum and the 
            //current digit >= 8, then the result will definitely over flow
            if(result > maxNum || (result == maxNum && digit >=8)){
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            
            //if not, then proceed and add the new digit
            result = (result * 10) + digit;
            
            //increment the counter
            i++;
        }
        //return the result with appropriate sign value
        return sign * result;
    }
}