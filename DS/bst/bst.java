import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class BinarySearchTree{
	public Node root;
	Map map = new HashMap<Integer, List<Integer>>();
	
	public BinarySearchTree(int data){
		root = new Node(data);
	}
	
	public void insert(int data){
		Node node = new Node(data);
		insertHelper(root, node);
	}
	
	
	public Node insertHelper(Node currRoot, Node node){
		if(currRoot == null){
			currRoot = node;
			return currRoot;
		}else if(node.data < currRoot.data){
			currRoot.left = insertHelper(currRoot.left, node);
			return currRoot;
		}else if(node.data > currRoot.data){
			currRoot.right = insertHelper(currRoot.right, node);			
			return currRoot;
		}
		return null;
	}
	
	
	public void inOrder(Node currRoot){
		if(currRoot == null)
			return;
		inOrder(currRoot.left);		
		System.out.println(currRoot.data);
		inOrder(currRoot.right);
	}
	
	public void preOrder(Node currRoot){
		if(currRoot == null)
			return;
		System.out.println(currRoot.data);
		preOrder(currRoot.left);
		preOrder(currRoot.right);
	}
	
	public void postOrder(Node currRoot){
		if(currRoot == null)
			return;
		postOrder(currRoot.left);
		postOrder(currRoot.right);
		System.out.println(currRoot.data);
	}
	
	public int getMin(){
		Node curr = root;
		while(curr.left != null){
			curr = curr.left;
		}
		return curr.data;
	}
	
	public int getMax(){
		Node curr = root;
		while(curr.right != null){
			curr = curr.right;
		}
		return curr.data;
	}
	
	private void formHDMap(Node root, int hd){
		if(root == null)
			return;
		
		if(map.containsKey(hd)){
			((List)map.get(hd)).add(root.data);
		}else{
			List list = new ArrayList<Integer>();
			list.add(root.data);						
			map.put(hd, list);
		}
		formHDMap(root.left, hd - 1);
		formHDMap(root.right, hd + 1);						
	}
	
	public void printVertical(){
		formHDMap(root, 0);
		System.out.println(map);		
	}
    
    public void remove(int val){
        remove(root, val);
    }
    
    
    private Node remove(Node node, int val){
        if(node == null) return node;
        else if(node.data < val) node.right = remove(node.right, val);
        else if(node.data > val) node.left = remove(node.left, val);
        else if(node.left != null && node.right != null) {
            node.data = findMinimum(node.right).data;
            node.right = remove(node.right, node.data);
        }else{
            node= (node.left!=null)?node.left:node.right;
        }
        return node;
    }
	
    private Node findMinimum(Node node){
        if(node == null) return null;
        else if(node.left == null) return node;
        else return findMinimum(node.left);
    }
    
	
}

class BST{
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree(5);
		bst.insert(3);
		bst.insert(6);
		bst.insert(7);
		bst.insert(2);
		bst.insert(4);
        
		System.out.println("In Order");
		bst.inOrder(bst.root);
		System.out.println("\n\nPre Order");
		bst.preOrder(bst.root);
		System.out.println("\n\nPost Order");
		bst.postOrder(bst.root);
		System.out.println("\n\nMin Value");
		System.out.println(bst.getMin());
		System.out.println("\n\nMax Value");
		System.out.println(bst.getMax());
		System.out.println("\n\nVertical");
		bst.printVertical();
        
        System.out.println("\n\nRemoving 3");
        bst.remove(3);
        System.out.println("In Order");
        bst.inOrder(bst.root);
        System.out.println("Removing 6");
        bst.remove(6);
        System.out.println("In Order");
        bst.inOrder(bst.root);
				
	}
}