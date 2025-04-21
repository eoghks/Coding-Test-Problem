class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh =0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int cnt = 0;
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                for(int[] d: dir) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if(nx >=0 && nx<n && ny >=0 && ny <m && grid[nx][ny] ==1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            cnt++;
        }
        return fresh == 0 ? cnt : -1;
    }
}