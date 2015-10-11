public class Solution {
    
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int[] result = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<Integer>();
        int  i = 0;
        //loop through the window for the first time
        while(i<k){
            //if there is any element lesser than current ith element at the last
            //remove it and then add the index
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]){
                q.removeLast();
            }
            q.addLast(i++);
        }
        
        //update the result array with the first result
        result[i-k]=nums[q.peekFirst()];
        
        while(i<nums.length){
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            //remove the old element from the top if it still exists
            if(!q.isEmpty() && q.getFirst() <= i-k){
                q.removeFirst();
            }
            i++;
            result[i-k] = nums[q.peekFirst()];
        }
        
        return result;
    }
}