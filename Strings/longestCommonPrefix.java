/***
	Write a function to find the longest common prefix string amongst an array of strings.

***/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return new String();
        if(strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length-1];
        for(int i=0;i<start.length();i++){
            if(end.length() > i && start.charAt(i) == end.charAt(i)){
                sb.append(start.charAt(i));
            }else{
                return sb.toString();
            }
        }
        
        return sb.toString();
    }
}