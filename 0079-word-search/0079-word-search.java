class Solution {
    int m;
    int n;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        char[] chars = word.toCharArray();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(i,j, 0, board, chars))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int len, char[][] board, char[] chars) {
        if(i<0 || j<0 || i>=m || j>=n) {
            return false;
        }
        if(board[i][j] != chars[len]) {
            return false;
        }
        if(len == chars.length-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        for(int[] d: dir) {
            if(dfs(i+d[0], j+d[1], len+1, board, chars) == true) {
                board[i][j] = temp;
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}