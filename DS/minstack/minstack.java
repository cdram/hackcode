import java.io.*;


class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		next = null;
	}
	
	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}


class LinkedList{
	Node first;
	Node last;
	Node lastButOne;		
	
	
	public LinkedList(){
		first = null;
		last = null;
		lastButOne = null;
	}
	
	public void insertAtLast(int data){
		Node node = new Node(data);
		if(first == null){
			first  = node; 
			last = first;
			lastButOne = first;
		}else{
			Node temp = first;
			while(temp.next != null){				
				temp = temp.next;
			}			
			temp.next = node;
			lastButOne = temp;
			last = node;			
		}
	}
	
	public void insertAtStart(int data){
		Node node = new Node(data);
		if(first == null){
			first = node;
			last = first;
		}else{
			node.next = first;
			first = node;
		}			
	}	
	
	public int deleteFirst(){
		int data = first.data;		
		if(first.next == null){
			first = null;
			last = null;
		}else{
			first = first.next;			
		}
		return data;
	}
	
	public int peek(){
		if(first != null){
			return first.data;
		}else{
			return -1;
		}
	}
	
	public boolean isEmpty(){
		return (first == null)?true:false;
	}
	
}


class MinStack{
	LinkedList lList = null;
	LinkedList minList = null;
	
	public MinStack(){
		lList = new LinkedList();
		minList = new LinkedList();
	}
	
	public void push(int data){
		lList.insertAtStart(data);
		if(minList.isEmpty() || minList.peek() >= data){
			minList.insertAtStart(data);
		}
	}
	
	
	public int pop(){
		int data = lList.deleteFirst();
		if(data == minList.peek()){
			minList.deleteFirst();
		}
		return data;
				
	}
	
	public int min(){
		if(minList.isEmpty()){
			return -1;
		}else{
			return minList.peek();
		}
	}		

}



class StackApp{
	public static void main(String args[]){
		MinStack stack = new MinStack();
		stack.push(11);
		stack.push(8);
		stack.push(10);
		stack.push(14);
		stack.push(9);
		stack.push(8);
		
		System.out.println("Min in Stack after all pushes => " + stack.min());		
		System.out.println("Min in Stack after all pop "+ stack.pop() + " => " +stack.min());
		System.out.println("Min in Stack after all pop "+ stack.pop() + " => " +stack.min());
		System.out.println("Min in Stack after all pop "+ stack.pop() + " => " +stack.min());
		System.out.println("Min in Stack after all pop "+ stack.pop() + " => " +stack.min());
		System.out.println("Min in Stack after all pop "+ stack.pop() + " => " +stack.min());
        System.out.println("Min in Stack after all pop "+ stack.pop() + " => " +stack.min());
				
	}
}