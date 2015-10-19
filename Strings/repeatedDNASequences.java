/***
	All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

	Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

	For example,

	Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

	Return:
	["AAAAACCCCC", "CCCCCAAAAA"].
***/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String str = "";
        
        for(int i=0;(i+9) < s.length(); i++){
            str = s.substring(i, i+10);
            if(map.containsKey(str)) map.put(str, map.get(str)+1);
            else map.put(str,1);
        }
        
        for(String key :  map.keySet()){
            if(map.get(key) > 1) list.add(key);
        }
        
        return list;
    }
}