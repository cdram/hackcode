import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;






class Priority{

	public static PriorityQueue<Integer> q = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
		public int compare(Integer a, Integer b){
			if(a >b ){
				return 1;
			}else if(a == b ){
			return 0;
			}else{
			return -1;
			}
		}
	});
	
	
	public static void insert(int val){
		q.add(val);			
	}
	
	public static void main(String args[]){
		int[]  arr = {10,23,44,1,2,65,33,69,90,11};
		for(int i=0;i<arr.length;i++){
			insert(arr[i]);	
		}
		
		
		while(q.size() > 0){
			System.out.println(q.poll());
		}
	
	}
	
	




}