import java.io.*;
import java.util.*;

class Node{
	int data;
	Node above, below;
	
	public Node(int data){
		this.data = data;
		this.above = null;
		this.below = null;	
	}		
}


class Stack{
	int capacity;
	int size = 0;
	Node top, bottom;
	
	
	public Stack(int capacity){
		this.capacity = capacity;
		this.top = null;
		this.bottom = null;
	}
	
	public boolean isFull(){
		return capacity == size;
	}
	
	public void join(Node above, Node below){
		if(below != null) below.above = above;
		if(above != null) above.below = below;
	}
	
	public boolean push(int data){
		if(size >= capacity) return false;
		size++;
		Node node = new Node(data);
		
		if(size == 1) bottom = node;
		join(node, top);
		top = node;
		return true;				
	}
	
	public int pop(){
		Node t = top;
		top = top.below;
		size--;
		return t.data;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int removeBottom(){
		Node t = bottom;
		bottom = bottom.above;
		if(bottom != null) bottom.below = null;
		size--;
		return t.data;
	}
	
	public int size(){
		return size;
	}
}




class SetOfStacks{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity){
		this.capacity = capacity;		
	}
	
	public Stack getLastStack(){
		if(stacks.size() == 0){
			stacks.add(new Stack(capacity));			
		}
		return stacks.get(stacks.size() -1);
	}
	
	public void push(int data){
		Stack lastStack = getLastStack();
		if(lastStack.size() >= capacity){
			Stack newStack = new Stack(capacity);
			newStack.push(data);
			stacks.add(newStack);
		}else{
			lastStack.push(data);
		}					
	}
	
	public int pop(){
		Stack lastStack = getLastStack();
		int data = lastStack.pop();
		if(lastStack.isEmpty()){
			stacks.remove(stacks.size()-1);
		}		
		return data;
	}
	
	
	public int popAt(int stackNum){
		return shiftLocations(stackNum, true);
	}
	
	public int sizeOf(int stackNum){
		return stacks.get(stackNum).size();
	}
	
	public int shiftLocations(int stackNum, boolean removeFromTop){
		Stack stack = stacks.get(stackNum);
		int removedItem;
		
		if(removeFromTop){
			removedItem = stack.pop();
		}else{
			removedItem = stack.removeBottom();
		}
		
		if(stack.isEmpty()){
			stacks.remove(stackNum);
		}else if(stacks.size() > stackNum + 1){
			int value = shiftLocations(stackNum + 1, false);
			stack.push(value);	
		}
		return removedItem;				
	}
		
}


class StackSet{
	public static void main(String args[]){
		SetOfStacks sos= new SetOfStacks(3);
		sos.push(3);
		sos.push(2);
		sos.push(1);
		sos.push(6);
		sos.push(5);
		sos.push(4);
		sos.push(9);
		sos.push(8);
		sos.push(7);
		
		
		System.out.println("Size of Stack 0 => " + sos.sizeOf(0));
		System.out.println("Size of Stack 1 => " + sos.sizeOf(1));
		System.out.println("Size of Stack 2 => " + sos.sizeOf(2));							
		
		sos.pop();
		
		System.out.println("\nSize of Stack 0 => " + sos.sizeOf(0));
		System.out.println("Size of Stack 1 => " + sos.sizeOf(1));
		System.out.println("Size of Stack 2 => " + sos.sizeOf(2));
		
		sos.popAt(1);									
		
		System.out.println("\nSize of Stack 0 => " + sos.sizeOf(0));
		System.out.println("Size of Stack 1 => " + sos.sizeOf(1));
		System.out.println("Size of Stack 2 => " + sos.sizeOf(2));
		
		sos.popAt(0);		
		
		System.out.println("\nSize of Stack 0 => " + sos.sizeOf(0));
		System.out.println("Size of Stack 1 => " + sos.sizeOf(1));
		System.out.println("Size of Stack 2 => " + sos.sizeOf(2));
		
		
		
		
				
	}
}