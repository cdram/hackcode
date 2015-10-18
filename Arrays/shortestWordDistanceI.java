/***
	Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

	For example,
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

	Given word1 = “coding”, word2 = “practice”, return 3.
	Given word1 = "makes", word2 = "coding", return 1.

	Note:
	You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
***/
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int wordIndex1 = -1;
        int wordIndex2 = -1;
        int counter = Integer.MAX_VALUE;
        int i=-1;
        
        for(String word: words){
            i++;
            if(word.equals(word1)) wordIndex1 = i;
            if(word.equals(word2)) wordIndex2 = i;
            if(wordIndex1 != -1 && wordIndex2 != -1){
                counter = Math.min(counter, Math.abs(wordIndex2-wordIndex1));
            }
        }
        return counter;
    }
}