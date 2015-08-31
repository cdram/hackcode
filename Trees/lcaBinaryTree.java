Node findLCA(Node root, Node node1, Node node2){
	
	if(root == null || root == node1 || root ==node2) return root;
	
	Node left = findLCA(root.left, node1, node2);
	Node right= findLCA(root.right, node1, node2);
	
	return (left!=null&&right!=null)?root:(left!=null)left:right;	
}