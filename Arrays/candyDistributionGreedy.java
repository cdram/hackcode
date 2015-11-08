/***
	There are N children standing in a line. Each child is assigned a rating value.

	You are giving candies to these children subjected to the following requirements:

	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?
***/
public class Solution {
    public int candy(int[] ratings) {
        int[] storage = new int[ratings.length];
        Arrays.fill(storage, 1);
        
        for(int i= 1; i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                storage[i] = storage[i-1] + 1;
            }
            
        }
        
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                storage[i] = Math.max(storage[i], storage[i+1] + 1);    
            }
        }
        
        int candies = 0;
        for(int i : storage){
            candies += i;
        }
        
        return candies;
    }
}