import java.io.*;

class Node{
	public int data;
	public Node next; 
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	
	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	
	
	public void displayNode(){
		System.out.println("The Node Data => " + data);
	}	
}


class LinkedList{
	Node first;
	Node last;
	
	public LinkedList(){
		first = null;
		last = null;		
	}
	
	public void insertLast(int data){
		Node node = new Node(data);
		if(first == null){
			first = node;
			last = first;
		}else{
			Node temp = first;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
			last = node;	         				
		}					
	}
	
	
	public void deleteFirst(){
		if(first.next == null){
			last = null;
		}else{
			first = first.next;
		}
	}
	
	public void display(){
		Node current = first;		
		System.out.println("==============> Start Print <==============");
		while(current != null){
			System.out.println(current.data);
		    current = current.next;
		}
		System.out.println("==============> End   Print <==============");
	}
		
}


class Queue{	
	LinkedList ll;
	
	public Queue(){
		ll = new LinkedList();			
	}
	
	public void enqueue(int data){
		ll.insertLast(data);			
	}
	
	public void dequeue(){
		ll.deleteFirst();
	}
	
	public void display(){
		ll.display();
	}
}


class QueueApp{
	public static void main(String args[]){
		Queue q = new Queue();
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.display();
		q.dequeue();
		q.dequeue();
		q.display();
		// LinkedList l = new LinkedList();
		// l.insertLast(4);
		// l.display();
	}
}






