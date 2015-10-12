/***
	Given a digit string, return all possible letter combinations that the number could represent.
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
***/

public class Solution {
    Map<Character, String> map = new HashMap<Character,String>();     
    
    //DFS on the String
    private List<String> combinations(List<String> list, String digits, StringBuilder sb, int counter){
        //if the counter is greater the the digits length then add the StringBuilder string as an entry
        if(counter >= digits.length()) {
            list.add(sb.toString());
            return list;
        }
        
        //get the values-string associated with a particular key stroke    
        String temp = map.get(digits.charAt(counter));
        //increment the counter (so temp => contain values-string of 2 and counter will be pointing
        //to 3, when the input string is "23").
        counter++;
        
        //loop over values-string
        for(int i=0;i<temp.length();i++){
            sb.append(temp.charAt(i));
            //DFS over the next keys combinations
            list = combinations(list, digits, sb, counter);
            //delete the last character from the SB as its already loaded into the list
            sb.deleteCharAt(sb.length()-1);
        }
        return list;
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0) return new ArrayList<String>();
        
        //load the map with values
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        List<String> list =  new ArrayList<>();
        return combinations(list, digits, new StringBuilder(), 0);
    }
    
    
    
}