/***
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:

	"((()))", "(()())", "(())()", "()(())", "()()()"
***/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        return depthFirstSearch(list, n, n, "");    
    }
    
    public List<String> depthFirstSearch(List<String> list, int left, int right , String temp){
        if(left > right) return list;
        
        if(left==0&&right == 0) {
            list.add(temp);
        }
        
        if(left > 0){
            list = depthFirstSearch(list, left-1, right, temp + "(");
        }
        
        if(right > 0){
            list = depthFirstSearch(list, left, right-1, temp + ")");
        }
        return list;
    }
}