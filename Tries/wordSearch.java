/***
	Given a 2D board and a list of words from the dictionary, find all words in the board.

	Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

	For example,
	Given words = ["oath","pea","eat","rain"] and board =

	[
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
	]
	Return ["eat","oath"].
	Note:
	You may assume that all inputs are consist of lowercase letters a-z.


	This problem is also known as Boggle Search!
	This problem also falls under the Graph Traversa Category.
***/


enum SearchResult { NOT_FOUND, PREFIX_FOUND, WORD_FOUND};

class TrieNode{
    String value;
    HashMap<Character, TrieNode> children = null;
    Boolean flag;
    
    public TrieNode(){
        value = null;
        children = new HashMap<>();
        flag = Boolean.FALSE;
    }
    
    public TrieNode(String value){
        this.value = value;
        children = new HashMap<>();
        flag = Boolean.FALSE;
    }
    
    public void add(Character c){
        String val = "";
        if(this.value == null){
            val = String.valueOf(c);
        }else{
            val = this.value + String.valueOf(c);
        }
        this.children.put(c, new TrieNode(val));
    }
}

class Trie{
    TrieNode root = null;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void addWord(String word){
        TrieNode node = root;
        for(Character c: word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.add(c);
            }
            node= node.children.get(c);
        }
        node.flag = true;
    }
    
    public void addWords(String[] words){
        for(String word :  words){
            addWord(word);
        }
    }
    
    public TrieNode getRoot(){
        return root;
    }
    
    public SearchResult search(String word){
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.children.containsKey(c)) return SearchResult.NOT_FOUND;
            node = node.children.get(c);
        }
        return (node.flag)?SearchResult.WORD_FOUND:SearchResult.PREFIX_FOUND;
    }
    
}

public class Solution {
    
    public void dfs(Trie trie, Set<String> set, int i, int j, char[][] board, String word, boolean[][] visited){
        if(i<0 || j<0 || i>board.length-1 || j> board[0].length-1 || visited[i][j]) return;
        
        //get the current stream of the word
        word += board[i][j];
        
        //for a particular path we take in the graph, we make sure we dont revisit them in the following recurrences
        visited[i][j] = true;
        
        //search the trie for the word
        SearchResult result = trie.search(word);
        
        //if considering the word as a prefix fails, then there is no use to proceed, so we terminate
        if(result == SearchResult.NOT_FOUND){ 
            //reset visited to false
            visited[i][j] = false;
            return;
        }//if the word itself was found, then add it to the set
        else if(result == SearchResult.WORD_FOUND) set.add(word);
        
        //now perform DFS
        dfs(trie, set, i-1, j, board, word, visited);
        dfs(trie, set, i+1, j, board, word, visited);
        dfs(trie, set, i, j-1, board, word, visited);
        dfs(trie, set, i, j+1, board, word, visited);                
        
        //reset visited to false
        visited[i][j] = false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0 || words.length == 0 || board[0].length == 0) return new ArrayList<String>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> set = new HashSet<>();
            
        //create a trie with all of the input words   
        Trie trie = new Trie();
        trie.addWords(words);
        
        //perform DFS from every point in the board
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(trie, set, i, j, board, "", visited);    
            }
        }        
        
        //return the list
        return new ArrayList<String>(set);
    }
}