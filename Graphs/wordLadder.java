import java.util.*;
import java.io.*;




class GraphNode{
	String word = null;
	List<GraphNode> children = null;
	int level;
	
	public GraphNode(String word, int level){
		this.word = word;
		this.level = level;
		children = new ArrayList<>();
	}

	
	public void addChild(String word){
		GraphNode node = new GraphNode(word,this.level+1);
		children.add(node);
	}		
	
}


class WordLadder{
	
	
	private static GraphNode formGraph(GraphNode node, Set<String> wordList){				
		String startWord = node.word;			
		char[] arr = startWord.toCharArray();
		for(int i=0;i<startWord.length();i++){
			char temp = arr[i];
			for(char c ='a';c<='z';c++){
				if(arr[i]!=c){
					arr[i] = c;
				}
				
				String childWord = new String(arr);
				if(wordList.contains(childWord) && !childWord.equalsIgnoreCase(startWord)){			
					node.addChild(childWord);
				}	
				arr[i] = temp;			
			}				
		}
		return node;	
	}
	
	
	
	public static void main(String[] args){		
		Set<String> wordList = new HashSet<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");		
		String targetWord = "cog";		
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		GraphNode root = new GraphNode("hit", 1);
		queue.add(root);

		Boolean flag = false;			
		while(!queue.isEmpty()){
			GraphNode node = formGraph(queue.poll(), wordList);
			for(GraphNode child: node.children){
				if(child.word.equalsIgnoreCase(targetWord)){
					System.out.println("Distance => " + child.level);
					flag = true;
					break;
				}
				queue.add(child);
			}
			if(flag) break;
		}
		
		if(!flag) System.out.println("Target Word NOT FOUND!");


	}
	
}