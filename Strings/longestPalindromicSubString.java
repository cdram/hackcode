public class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1) return s;
        //Keep track of the length of the maximum palindrome
        int maxLength = 1;
        //Keep track of the starting point of the palindrome
        int start=0;
        int low, high;
        
        for(int i=1;i<s.length();i++){
            //find the even palindrome. In an Even Palindrome the middle two items
            //must be same
            low = i-1;
            high = i;
            while(low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                //if this palindrome is longer than the current max palindrome
                if(high-low+1 > maxLength){
                    start = low; //update the starting index to the start of the palindrom
                    maxLength = high-low+1; //update the reigning length
                }
                low--;
                high++;
            }
            
            //find the odd palindorm. In an Odd Palindrome elements around the middle are same
            low = i-1;
            high=i+1;
            while(low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                //if this palindrome is longer than the current max palindrome
                if(high-low+1 > maxLength){
                    start = low; //update the starting index to the start of the palindrome
                    maxLength = high-low+1; //update the reigning length
                }
                low--;
                high++;
            }
        }
        System.out.println(maxLength);
        return s.substring(start, start+maxLength);
    }
}