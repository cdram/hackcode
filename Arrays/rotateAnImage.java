/***
	You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).

	Follow up:
	Could you do this in-place?
***/


public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length > 0 && matrix.length == matrix[0].length){
            int n = matrix.length;
            for(int i=0;i<n/2;i++){
                for(int j=i;j<n-1-i;j++){
                    int temp = matrix[i][j];
                    //here the n-1-j => the row shd change within the same loop, so we stick to j o rows and i cols
                    //ex: 3,0 2,0 ...
                    matrix[i][j] = matrix[n-1-j][i];
                    //here the n-1-i => the row shd remain constant , but the cols shd change
                    //ex: 3,3, 3,2, ...
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    //here the row shd change withing the same loop
                    //ex: 0,3 1,3 2,3 ...
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = temp;
                }
            }
            
        }           
    }
}