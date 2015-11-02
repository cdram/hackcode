/***
	Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
***/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <=1) return s.length();
        HashSet<Character> set = new HashSet<>();
        int i=0, j=0, len = Integer.MIN_VALUE;
        
        while(i < s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                len = Math.max(len, set.size());
            }else{
                set.remove(s.charAt(j));
                j++;
            }    
        }
        return len;
        
    }
}