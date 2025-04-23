class Solution {
    int[][] dir = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    int max = 0;
    int m;
    int n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxGold = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0) {
                    max = Math.max(dfs(i, j, grid), max);
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0) {
            return 0;
        }
        int cur = grid[i][j];
        grid[i][j] =0;
        int localMax = cur;
        for(int[] d: dir) {
            localMax = Math.max(localMax, cur+dfs(i+d[0], j+d[1], grid));
        }

        grid[i][j] = cur;
        return localMax;
    }
}