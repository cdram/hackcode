public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        
        dp[0][0] = grid[0][0];
        
        for(int i = 1;i<cols;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        
        for(int j = 1;j<rows;j++){
            dp[j][0] = dp[j-1][0]+grid[j][0];
        }
        
       for(int i=1; i<rows; i++){
        for(int j=1; j<cols; j++){
            
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            
        }
    }
        
        return dp[rows-1][cols-1];
    }
}