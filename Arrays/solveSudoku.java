/***
	Write a program to solve a Sudoku puzzle by filling the empty cells.

	Empty cells are indicated by the character '.'.

	You may assume that there will be only one unique solution.
***/

public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    int val = ((int)board[i][j]) - ((int)'1');
                    if(val >=0 && val <=8 && !rows[i][val] && !cols[j][val] && !blocks[i-i%3+j/3][val]){
                        rows[i][val] = cols[j][val] = blocks[i-i%3+j/3][val] = true;
                    }
                }
            }
        }
        performDFS(board, rows, cols, blocks);
    }
    
    public boolean performDFS(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    int blockNum = i-i%3+j/3;
                    for(int k=0;k<9;k++){
                        if(!rows[i][k] && !cols[j][k] && !blocks[blockNum][k]){
                            rows[i][k] = cols[j][k]  = blocks[blockNum][k] = true;
                            board[i][j] = (char)(((int)'1') + k);
                            if(performDFS(board, rows, cols, blocks)) return true;
                            rows[i][k] = cols[j][k]  = blocks[blockNum][k] = false;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}