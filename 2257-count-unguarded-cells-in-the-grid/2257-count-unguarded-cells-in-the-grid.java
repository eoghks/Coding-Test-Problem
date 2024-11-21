class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int cnt = m*n - guards.length - walls.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        char[][] grid= new char[m][n];

        for(int[] w: walls) {
            grid[w[0]][w[1]] = 'W';
        }
        
        for(int[] g: guards) {
            grid[g[0]][g[1]] = 'G';
        }
        
        for(int[] g: guards) {
            for(int[] dir: dirs) {
                int x = dir[0] + g[0];
                int y = dir[1] + g[1];
                while((x<0 || y<0 || x>=m || y>=n || grid[x][y] =='G' || grid[x][y] == 'W') == false) {
                    if(grid[x][y] != 'P')
                        cnt--;
                    grid[x][y] = 'P';
                    x+=dir[0];
                    y+=dir[1];
                }
            }
        }
        
        return cnt;
    }
}