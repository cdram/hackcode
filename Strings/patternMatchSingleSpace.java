/***
	Given a pattern and a string str, find if str follows the same pattern.

	Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

	Examples:
	pattern = "abba", str = "dog cat cat dog" should return true.
	pattern = "abba", str = "dog cat cat fish" should return false.
	pattern = "aaaa", str = "dog cat cat dog" should return false.
	pattern = "abba", str = "dog dog dog dog" should return false.
	Notes:
	You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
***/


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map =  new HashMap<>();
        String[]arr = str.split(" ");
        if(pattern.length() != arr.length) return false;
        int  i = 0;
        
        for(Character c : pattern.toCharArray()){
            if(map.containsKey(c) && !map.get(c).equals(arr[i]))return false;
            else if(!map.containsKey(c)){
                if(map.containsValue(arr[i])) return false;
                map.put(c, arr[i]);
            }
            i++;
        }
        
        return true;
    }
}