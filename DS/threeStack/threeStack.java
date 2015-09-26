import java.io.*;


class StackNode{
	public int previous;
	public int data;
	
	public StackNode(int p, int d){
		previous = p;
		data = d;
	}
}

class ThreeStack{
	int stackSize = 300;
	int indexUsed = 0;
	int[] stackPointer = {-1,-1,-1};
	StackNode[] buffer = new StackNode[stackSize * 3];
	
	public void push(int stackNum, int data){
		int lastIndex = stackPointer[stackNum]; //store the location of the top item of the stack
		stackPointer[stackNum] = indexUsed;	//update the location in the stack-pointer array for that particular stack to posses the value of the new entry's location	
		buffer[stackPointer[stackNum]] = new StackNode(lastIndex, data); //create a new StackNode with the previous pointer pointing lastIndex. If this lastIndex is -1 then this is the last element   						 
		indexUsed = indexUsed + 1;
	}
	
	
	public int pop(int stackNum){
		int previous = buffer[stackPointer[stackNum]].previous;
		int data = buffer[stackPointer[stackNum]].data;
		
		stackPointer[stackNum] = previous;
		buffer[previous] = null;
		indexUsed--;
		return data;						
	}
	
	public int peek(int stackNum){
		return buffer[stackPointer[stackNum]].data;
	}
	
	public boolean isEmpty(int stackNum){
		return if stackPointer[stackNum] == -1;			
	}
	
	
}