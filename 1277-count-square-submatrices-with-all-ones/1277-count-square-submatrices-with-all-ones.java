class Solution {
    /*
        자기 자신이 오른쪽 아래를 기준으로 만들어지는 정사각형의 갯수를 구한다.
        0 1 1 1    0 1 1 1    0 1 1 1
        1 1 1 1 -> 1 1 2 2 -> 1 1 2 2 이된다. 
        0 1 1 1    0 1 1 1    0 1 2 3  
    */
    public int countSquares(int[][] matrix) {
        int result = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j= 0; j < matrix[0].length; j++) {
                if(matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
                }
                result += matrix[i][j];
            }
        }
        return result;
    }
}