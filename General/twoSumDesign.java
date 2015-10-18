/***
	Design and implement a TwoSum class. It should support the following operations: add and find.
	add - Add the number to an internal data structure.
	find - Find if there exists any pair of numbers which sum is equal to the value.
	For example,
	add(1); add(3); add(5);
	find(4) -> true
	find(7) -> false
***/
public class TwoSum {
    
    //this map stores the incoming integer as key and the number of 
    //its occurances as the value
    Map<Integer, Integer> map= new HashMap<Integer, Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number)) map.put(number, map.get(number)+1);
	    else map.put(number,1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    int diff = -1;
	    boolean flag = false;
	    boolean cond = false;
	    //loop over all the keys
	    for(Integer num : map.keySet()){
	        //difference between number and the requested value
	        diff = value-num;
	        //if the above difference is equal to the current num, then update flag as true
	        flag = (diff==num);
	        //if the diff between the current num and requested value == current num, then
	        //the map should contain more than one occurence of the current number
	        cond = (map.containsKey(diff) && flag && map.get(diff) > 1);
	        //if the diff between the current num and requested value != current num, then
	        //we just need to check whether the map contains the value
	        cond = cond || (map.containsKey(diff) && !flag);
	        if(cond) return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);