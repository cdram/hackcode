/***
	Given two strings s and t, determine if they are isomorphic.

	Two strings are isomorphic if the characters in s can be replaced to get t.

	All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

	For example,
	Given "egg", "add", return true.

	Given "foo", "bar", return false.

	Given "paper", "title", return true.

	Note:
	You may assume both s and t have the same length.
***/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map =  new HashMap<>();
        if(s.length() != t.length()) return false;
        int  i = 0;
        
        for(Character c : s.toCharArray()){
            if(map.containsKey(c) && !map.get(c).equals(t.charAt(i)))return false;
            else if(!map.containsKey(c)){
                if(map.containsValue(t.charAt(i))) return false;
                map.put(c, t.charAt(i));
            }
            i++;
        }
        
        return true;
    }

}