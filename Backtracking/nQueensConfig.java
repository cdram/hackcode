/***
	Follow up for N-Queens problem.

	Now, instead outputting board configurations, return the total number of distinct solutions.
***/
public class Solution {
    
    public int totalNQueens(int n) {
        //form a helper column array
        //ith position in this array is the ith row, and the value at ith position 
        //is the column used for that row
        int [] cols = new int[n];
        Arrays.fill(cols, -1);
        
        //perform DFS
        return dfs(0, cols, 0);
    }
    
    public int dfs(int row, int[] cols, int counter){
        //if the row == column length, then we have successfully filled the board
        if(row == cols.length){
            counter=counter+1;
            return counter;
        }
        
        //loop over all the cols for this particular row
        for(int i=0;i<cols.length;i++){
            if(isValid(row, i, cols)){
                //if the row, i(cols) works out fine then select it and perform DFS for the Next Row
                cols[row] = i;
                counter = dfs(row+1, cols, counter);
            }
        }
        return counter;
    }
    
    public boolean isValid(int row, int col, int[]cols){
        //we have to check whether the incoming row,col position will work out
        //for this lets loop over the cols array till the current row and check for abnormalities
        for(int i=0;i<row;i++){
            int k = i; //row position used
            int l = cols[i]; //col position used
            
            //checks for 3 conditions row==i => same row col ==l => same column
            //Math.abs(row-i) == Math.abs(col-l) => present in upper or lower diagnol
            if(row == i || col == l || Math.abs(row-i) == Math.abs(col-l)){
                return false;
            }
        }
        return true;
    }
}