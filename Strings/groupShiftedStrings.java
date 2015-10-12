/***
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.
***/

import java.util.LinkedHashMap;

public class Solution {
    
    private String getCode(String s){
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for(int i=1;i<s.length();i++){
            temp = ((int)s.charAt(i)-(int)s.charAt(i-1))+26;
            temp = temp%26;
            sb.append(temp);
        }
        return new String(sb);
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> l = new ArrayList<>();
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        Arrays.sort(strings);
        for(String s : strings){
            String code = getCode(s);
            if(!map.containsKey(code)) map.put(code, new ArrayList<String>());
            map.get(code).add(s);
        }
        
        for(String key : map.keySet()){
            l.add(map.get(key));     
        }
        return l;
    }
}