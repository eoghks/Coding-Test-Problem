class Solution {
    int n;
    int m;
    int[][] dir = {{1, 0}, {0,1}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        int[] x = {0, n-1};
        int[] y = {0, m-1};
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j: y) {
                if(board[i][j] == 'O' && visited[i][j] == false) {
                    dfs(i, j, visited, board);
                }
            }
        }

         for(int j=0; j<m; j++) {
            for(int i: x) {
                if(board[i][j] == 'O' && visited[i][j] == false) {
                    dfs(i, j, visited, board);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] ='X';
                }
            }
        }
    }
    private void dfs(int i, int j, boolean[][] visited, char[][] board) {
        if(i<0 || i>=n || j<0 || j>=m) {
            return;
        }
        if(board[i][j] == 'X' || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        for(int[] d: dir) {
            dfs(i+d[0], j+d[1], visited, board);
        }
    }
}