class Solution {
    int n;
    int m;
    int[][] direct = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    dfs(i,j, grid);
                }
            }
        }
        return cnt;
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i<0 || i>=n || j<0 || j>=m){
            return;
        }
        if(grid[i][j]=='1'){
            grid[i][j]='#';
            for(int[] d: direct) {
                dfs(i+d[0], j+d[1], grid);
            }
        }
    }
 }