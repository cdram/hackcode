public class Solution {
    
    private char[][] merge(char[][] grid, int i, int j){
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1 || grid[i][j]!='1') return grid;
        grid[i][j] = '0';
        merge(grid, i-1,j);
        merge(grid, i+1,j);
        merge(grid, i,j-1);
        merge(grid, i,j+1);
        return grid;
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        
        for(int i =0;i <rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    grid = merge(grid, i, j);    
                }
            }
        }
        
        return islands;   
        
    }
}