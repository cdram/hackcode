public class Solution {
    //create the temporary support array
    //this will help to store the index of the next element after the prefix which contains the suffix
    // pattern  => i s s i p
    // temp     => 0 0 0 1 0
    //so if a pattern mismatches for character 'p', then we know that the substring of the pattern without
    // 'p' is "i s s i", here we can clearly see that 'i' (a suffix) is already present in the string as prefix
    //so the next comparison can be from tempArray[indexOf('p') -1] => 1 => character 's'. The understanding is that
    // if the string matching fails at character p, that means that the repeated suffix shd be passed already
    private int[] formTempArray(char[] pattern){
        int j=0;
        int[] temp = new int[pattern.length];
        
        for(int i=1; i< pattern.length;){
            if(pattern[j] == pattern[i]){
                temp[i] = j+1;
                i++;
                j++;
            }else if(j != 0){
                j = temp[j-1];
            }else{
                temp[i] = 0;
                i++;
            }
            
        }
        return temp;
    }
    
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        if(needle.length() > haystack.length()) return -1;
        
        char[] input = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int[] temp = formTempArray(pattern);
        
        int i = 0, j = 0;
        
        while(i < input.length && j < pattern.length){
            //if both the characters match just proceed
            if(input[i] ==  pattern[j]){
                i++;
                j++;
            }else if(j != 0){
                //if they donot match and j is not 0, then start the comparison
                //from the value of temp[j-1]
                j = temp[j-1];
            }else{
                //if they donot match and j ==0, then just increment i in the input
                i++;
            }
        }
        
        //j would have been ++'d, so we just give the different of i-length of pattern
        return (j== pattern.length)?i-pattern.length:-1;
        
    }
    
}