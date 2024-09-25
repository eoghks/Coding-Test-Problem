class Solution {
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(m <=1 || n <=1)
            return 0;
        return Math.min(row(grid, n, m), col(grid, n, m));
    }
    
    public int row(int[][] grid, int n, int m) {
        int cnt = 0;
        for(int i =0; i<n; i++) {
            for(int j=0; j<m/2; j++) {
                if(grid[i][j] != grid[i][m-j-1])
                    cnt++;
            }
        }
        System.out.println("row: "+cnt);
        return cnt;
    }
    
     public int col(int[][] grid, int n, int m) {
        int cnt = 0;
        for(int i =0; i<m; i++) {
            for(int j=0; j<n/2; j++) {
                if(grid[j][i] != grid[n-1-j][i])
                    cnt++;
            }
        }
                 System.out.println("col :" +cnt);
        return cnt;
    }
    
}