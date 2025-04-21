class Solution {
    int n;
    int m;
    int[][] direct = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    cnt++;
                    dfs(i,j, visited, grid);
                } else {
                    visited[i][j] = true;
                }
            }
        }
        return cnt;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        visited[i][j] = true;
        for(int[] d: direct) {
            int nextI = i+d[0];
            int nextJ = j+d[1];
            if(nextI >=0 && nextJ >=0 && nextI <n && nextJ <m && grid[nextI][nextJ] =='1' && visited[nextI][nextJ] == false) {
                dfs(nextI, nextJ, visited, grid);
            }
        }
    }
 }