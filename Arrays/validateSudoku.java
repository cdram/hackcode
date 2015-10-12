public class Solution {
    
    private boolean validateRowsAndColumns(char[][] board){
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        
        for(int  i=0;i<9;i++){
            for(int j = 0; j< 9;j++){
                if(board[i][j] != '.'){
                    int val = (int)board[i][j]-'1';
                    System.out.println("i => "+ i +" j=> " + j +" val => " + val);
                    if(val >=0 && val <=8 && !rows[i][val] && !cols[j][val] && !blocks[i-i%3+j/3][val]) {
                        rows[i][val] = cols[j][val] = true;
                        blocks[i-i%3+j/3][val] = true;
                    }else return false;
                    
                }
            }
        }
        
        return true;
    }
    
    
    
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0 || board.length != 9 || board[0].length != 9) return false;
        return validateRowsAndColumns(board);    
    }
}