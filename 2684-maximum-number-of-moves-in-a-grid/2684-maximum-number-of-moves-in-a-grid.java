class Solution {
    int[][] dp;
    int[] move = {-1, 0, 1};
    int n;
    int m;
    public int maxMoves(int[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        for(int i=0 ; i< m; i++) {
            res = Math.max(res, solution(grid, i, 0));
        }
        return res;
    }
    private int solution(int[][] grid, int i, int j) {
        if(dp[i][j] != -1)
            return dp[i][j];

        int res = 0;
        if(j+1 < n) {
            for(int k: move) {
                int row = i + k;
                if(row >= 0 && row < m && grid[i][j] < grid[row][j+1])
                    res = Math.max(res, 1 + solution(grid, row, j+1));
            }
        }
        dp[i][j] = res;
        return dp[i][j];
    }
}