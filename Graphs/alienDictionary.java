/***
	There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

	For example,
	Given the following words in dictionary,

	[
	  "wrt",
	  "wrf",
	  "er",
	  "ett",
	  "rftt"
	]
	The correct order is: "wertf".

	Note:
	You may assume all letters are in lowercase.
	If the order is invalid, return an empty string.
	There may be multiple valid order of letters, return any one of them is fine.
***/
class Node{
     Character data;
     Node next;
    
    public Node(Character data){
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    
    LinkedHashSet<Character> lexico = new LinkedHashSet<Character>();
    Set<Character> visited = null;
    
    public Map<Character, Set<Character>> formMap(String[] words){
        Map<Character, Set<Character>> map = new HashMap<>();
        for(String word: words){
           lexico.add(word.charAt(0));
            for(int i=1;i<word.length();i++){
                Character ith = word.charAt(i);    
                for(int j = 0;j<i;j++){
                    Character jth = word.charAt(j);    
                    if(!map.containsKey(jth)) map.put(jth, new HashSet<Character>());
                    if(ith != jth) map.get(jth).add(ith);
                }
            }
        }
         return map;       
    }
    
    public Node isLooped(Map<Character, Set<Character>> adjMap, Character curr, Node node){
        if(visited.contains(curr)) return node;
        

        node.next = new Node(curr);
        node =  node.next;
        visited.add(curr);
        
        Set<Character> children = adjMap.get(curr);
        if(children != null){
            for(Character child: children){
                node = isLooped(adjMap, child, node);
            }    
        }
        return node;
    }
    
    
    public String alienOrder(String[] words) {
        if(words.length == 0) return "";        
        Map<Character, Set<Character>> adjMap = formMap(words);
        visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        for(Character c : lexico){
            if(!visited.contains(c)) {
                Node node = new Node(null);
                isLooped(adjMap, c, node);
                q.add(node.next);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Node n = q.poll();
            sb.append(n.data);
            if(n.next != null) q.add(n.next);
        }
        // System.out.println(sb.toString());
        return new String(sb);
    }
}