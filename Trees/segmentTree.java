import java.io.*;
import java.util.*;



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
	
	private int queryHelper(int node, int start, int end, int qStart, int qEnd){
		if(qStart > end || qEnd < start) return -1;
		
		if(qStart <= start && qEnd >= end){
			return segment[node];
		}
		
		int half = (start+end)/2;
		System.out.println("Node => " + node);
		int leftMax = queryHelper(2*node, start, half, qStart, qEnd);
		int rightMax = queryHelper(2*node+1, half+1, end, qStart, qEnd);
		
		if(leftMax == -1) return rightMax;
		if(rightMax == -1) return leftMax;
		
		System.out.println("Start => " + start + " End => " + end);
		System.out.println("LeftMax => " + leftMax + " RightMax => " + rightMax);
		
		return (leftMax>rightMax)?leftMax:rightMax;		
	}
	
	public int query(int start, int end){
		return queryHelper(1, 0, input.length, start, end);
	}
	
	public void printSegmentTree(){
		System.out.println(Arrays.toString(segment));
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
		System.out.println(sTree.query(2,4));
		// System.out.println(sTree.query(0,5));
		// System.out.println(sTree.query(1,3));
			
		
	}
	
	
	
}