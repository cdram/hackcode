import java.io.*;
import java.util.*;



class MyQueue{
	Stack<Integer> s1 = null;
	Stack<Integer> s2 = null;
	
	
	
	public MyQueue(){
		s1= new Stack<Integer>();
		s2= new Stack<Integer>();		
	}
	
	public void enqueue(int data){
		s1.push(data);
	}
	
	public int dequeue(){
		if(!s2.isEmpty()) return s2.pop();		
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	public int peek(){
		if(!s2.isEmpty()) return s2.peek();		
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		return s2.peek();
		
	}	
	
}


class QApp{
	public static void main(String args[]){
		MyQueue q = new MyQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.peek());
		q.dequeue();
		System.out.println(q.peek());
		
	}
}

