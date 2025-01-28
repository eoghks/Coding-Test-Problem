class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] vis;
    int[][] g;
    int n;
    int m;
    public int findMaxFish(int[][] grid) {
        int res = 0;
        g = grid;
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] > 0 && vis[i][j] == false) {
                    res = Math.max(res, solution(i,j));
                }
            }
        }

        return res;
    }

    private int solution(int i, int j) {
        int sum = g[i][j];
        vis[i][j] = true;
        for(int[] d: dir) {
            int x = i+d[0];
            int y = j+d[1];
            if(x>=0 && x<n && y>=0 && y<m && g[x][y] > 0 && vis[x][y] == false) {
                sum += solution(x,y);
            }
        }
        return sum;
    }
}