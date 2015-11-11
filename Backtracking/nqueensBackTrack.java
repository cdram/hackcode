/***
	The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
***/
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        //form a helper column array
        //ith position in this array is the ith row, and the value at ith position 
        //is the column used for that row
        int [] cols = new int[n];
        Arrays.fill(cols, -1);
        //perform DFS
        dfs(output, 0, cols);
        return output;
    }
    
    public void dfs(List<List<String>> list, int row, int[] cols){
        //if the row == column length, then we have successfully filled the board
        if(row == cols.length){
            //print the board
            list.add(printBoard(cols));
            return;
        }
        
        //loop over all the cols for this particular row
        for(int i=0;i<cols.length;i++){
            if(isValid(row, i, cols)){
                //if the row, i(cols) works out fine then select it and perform DFS for the Next Row
                cols[row] = i;
                dfs(list, row+1, cols);
            }
        }
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
    
    //printing the entire board
    public List<String> printBoard(int[] cols){
        List<String> list = new ArrayList<>();
        for(int i=0;i<cols.length;i++){
            char[] arr = new char[cols.length];
            Arrays.fill(arr, '.');
            arr[cols[i]] = 'Q';                
            list.add(new String(arr));
        }        
        return list;
    }
}