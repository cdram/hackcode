import java.io.*;
import java.util.*;




class Sort{

  public static void main(String args[]){
    Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> r = new Stack<Integer>();
	s.push(8);s.push(2);s.push(4);s.push(5);s.push(7);s.push(3);s.push(1);s.push(9);
	
	while(!s.isEmpty()){
		int tmp = s.pop();
		while(!r.isEmpty() && r.peek() > tmp){
			s.push(r.pop());
		}
		r.push(tmp);		
	}
	
	System.out.println(r);	
  }

}
