/***
	Implement wildcard pattern matching with support for '?' and '*'.

	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
***/
public class Solution {
    public boolean isMatch(String s, String p) {
        int sCurrent = 0, sEnd = s.length()-1;
        int pCurrent = 0, pEnd = p.length()-1;
        int sPreserve = -1, pPreserve = -1;
        
        while(sCurrent < s.length()){
            if((pCurrent < p.length()) && (s.charAt(sCurrent) == p.charAt(pCurrent) || p.charAt(pCurrent) == '?')){
                sCurrent++;
                pCurrent++;
            }else if(pCurrent < p.length() && p.charAt(pCurrent) == '*'){
                pPreserve = pCurrent;
                sPreserve = sCurrent;
                pCurrent = pCurrent +1;
            }else if(pPreserve != -1){
                pCurrent = pPreserve + 1;
                sCurrent = sPreserve +1;
                sPreserve++;
            }else{
                return false;
            }
        }
        
        while(pCurrent < p.length() && p.charAt(pCurrent) == '*') pCurrent = pCurrent +1;
        return  (pCurrent > pEnd);
    }
}