/***
	Implement a trie with insert, search, and startsWith methods.
***/

class TrieNode {
    String value; // value stored in the trie
    boolean flag; // indicates whether this is a completed node
    Map<Character, TrieNode> children = null; //map to store the children
    
    // Initialize your data structure here.
    public TrieNode() {
        value = null;
        children =  new HashMap<Character, TrieNode>();
        flag = false;
    }
    
    public TrieNode(String value) {
        this.value = value;
        children =  new HashMap<Character, TrieNode>(); 
        flag = false;
    }
    
    public void add(Character c){
        String val;
        if(this.value == null){ //for root node, as it has no value!
            val = String.valueOf(c);
        }else{ //for other nodes
            val = this.value + c;
        }
        this.children.put(c, new TrieNode(val));
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.add(c);
            }
            node = node.children.get(c);
        }
        node.flag = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return node.flag;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(Character c : prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");