/***
	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].

	Return true because "leetcode" can be segmented as "leet code".
***/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] bool =  new boolean[s.length()+1];
        bool[0] = true;
        
        for(int i =0 ;i<s.length();i++){
            
            if(!bool[i]) continue;
            
            for(String str : wordDict){
                int len = str.length();
                int strLen = i+len;
                if(strLen > s.length()) continue;
                if(bool[strLen]) continue;
                if(s.substring(i, strLen).equals(str)) bool[strLen] = true;
            }
        }
        return bool[s.length()];
    }
}