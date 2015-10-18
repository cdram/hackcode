/***
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Hide Tags
***/

public class WordDistance {
    HashMap<String, List<Integer>> map = null;
    
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        int i = 0;
        for(String word : words){
            if(map.containsKey(word)){
                map.get(word).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(word, list);
            }
            i++;
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int val = Integer.MAX_VALUE;
        for(int i=0, j=0; i< l1.size() && j < l2.size();){
            int v1 = l1.get(i);
            int v2 = l2.get(j);
            val = Math.min(val, Math.abs(l1.get(i)-l2.get(j)));
            if(v1>v2)j++;
            else i++;
        }
        return val;
    }
} 

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");