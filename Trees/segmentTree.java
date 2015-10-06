import java.io.*;
import java.util.*;

//Segment Trees are used to store values of an interval

class SegmentTree{
	
	int[] input = null;
	int[] segment = null;	
	
	public SegmentTree(int[] input){
		this.input = input;
		this.segment = new int[(int)(2* Math.pow(2,Math.ceil((Math.log(input.length) / Math.log(2)))))-1];
		Arrays.fill(segment, 0);		
	}
	
	public void build(int node, int left, int right){
		if(left == right){
			segment[node] = input[left];
		}else{
			build(2*node, left, (left+right)/2);
			build((2*node)+1, ((left+right)/2) +1, right);
			int leftValue = segment[2*node];
			int rightValue = segment[(2*node)+1];
			segment[node] = (leftValue >= rightValue)?leftValue:rightValue;
		}
	}
	
	public void updateHelper(int nodeToUpdate, int valueToUpdate, int node, int left, int right){
		if(left == right){
			segment[left] = input[left];
			if(nodeToUpdate == left) segment[node] = input[left] = valueToUpdate;
		}else{
			updateHelper(nodeToUpdate, valueToUpdate, 2*node, left, (left+right)/2);
			updateHelper(nodeToUpdate, valueToUpdate, (2*node)+1, ((left+right)/2)+1, right);
			int leftValue = segment[2*node];
			int rightValue = segment[(2*node)+1];
			segment[node] = (leftValue >= rightValue)?leftValue:rightValue;
		}
		
	}
	
	public void update(int nodeToUpdate, int valueToUpdate){
		updateHelper(nodeToUpdate, valueToUpdate, 1,0,input.length-1);
	}
	
	private int queryHelper(int node, int start, int end, int qStart, int qEnd){
		System.out.println("Node => " + node);
		System.out.println("Start => " + start + " End => " + end);
		if(qStart > end || qEnd < start) {
			System.out.println("Out of Bounds => " + start +" : " + end);
			return -1;
		}
		
		if(qStart <= start && qEnd >= end){
			System.out.println("Within Bounds => "  + start +" : " + end);
			return segment[node];
		}
		
		int half = (start+end)/2;
		int leftMax = queryHelper(2*node, start, half, qStart, qEnd);
		int rightMax = queryHelper(2*node+1, half+1, end, qStart, qEnd);
				
		System.out.println("LeftMax => " + leftMax + " RightMax => " + rightMax);
		
		if(leftMax == -1) return rightMax;
		if(rightMax == -1) return leftMax;				
		return (leftMax>rightMax)?leftMax:rightMax;		
	}
	
	public int query(int start, int end){
		return queryHelper(1, 0, input.length-1, start, end);
	}
	
	public void printSegmentTree(){
		System.out.println(Arrays.toString(segment));
	}

	public void printInputArray(){
		System.out.println(Arrays.toString(input));
	}
	
	
	public static void main(String[] args){
		int[] arr = new int[6];
		Random random = new Random();
		for(int i=0;i<arr.length;i++){
			arr[i] = random.nextInt(100);
		}
		
		SegmentTree sTree = new SegmentTree(arr);
		System.out.println(Arrays.toString(arr));
		sTree.build(1,0,arr.length-1);
		sTree.printSegmentTree();	
		System.out.format("Max Number between the range %d - %d : %d \n", 2,4,sTree.query(2,4));
		sTree.update(3,arr[3]+1220);
		sTree.printInputArray();
		sTree.printSegmentTree();			
		System.out.format("Max Number between the range %d - %d : %d \n", 2,4,sTree.query(2,4));
			
		
	}
	
	
	
}