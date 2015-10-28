/***
  Return the Maximum Threats for a queen in the chess board
  If the Chess Boards follows N-Queens Principle, then the maximum threat will be 0.
***/
    static boolean move(int[][] grid, int start, int end, int i, int j){
        //check for array bounds
        if(start < 0 || end < 0 || start > grid.length-1 || end > grid.length-1) return false;
        //if queen present return threat
        if(grid[start][end] ==1) return true;
        //recursively move in the same direction, until we hit a queen or boundary
        return move(grid, start + i, end + j, i ,j);
    }

    static int maxThreats(int[] a) {
       if(a.length == 0) return 0;
       int [][] grid = new int[a.length][a.length];
       int maxThreat = Integer.MIN_INT;


       //initialize the grid with queen positions
       for(int i =0;i<a.length;i++){
           grid[i][a[i]-1] = 1;
       }

       for(int i =0;i<a.length;i++){
          int threat = 0;
           int start = i;
           int end = a[i]-1;
           //move-up
           threat += move(grid, start-1, end, -1, 0)?1:0;
           //move-down
           threat += move(grid, start+1, end, 1, 0)?1:0;
           //move-left
           threat += move(grid, start, end-1, 0, -1)?1:0;
           //move-right
           threat += move(grid, start, end+1, 0, 1)?1:0;
           //move diag-left-up
           threat += move(grid, start-1, end-1, -1, -1)?1:0;
           //move diag-right-up
           threat += move(grid, start-1, end+1, -1, 1)?1:0;
           //move diag-left-down
           threat += move(grid, start+1, end-1, 1, -1)?1:0;
           //move diag-right-down
           threat += move(grid, start+1, end+1, 1, 1)?1:0;
           maxThreat = Math.max(maxThreat, threat);
       }

       return maxThreat;
    }
