class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = queries.length;
        int[] res = new int[n];
        int[][] visited = new int[rows][cols];
        
        List<int[]> sortedQueries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedQueries.add(new int[]{queries[i], i});
        }
        sortedQueries.sort((a,b) -> a[0] - b[0]);

        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = 1;
        int cnt = 0;

         for (int[] q : sortedQueries) {
            int val = q[0];
            int idx = q[1];

            //pq를 이용하여 방문할 수 있는 노드 중 최저를 가져오기
            while (!pq.isEmpty() && pq.peek()[0] < val) {
                int[] cur = pq.poll();
                int row = cur[1];
                int col = cur[2];
                cnt++;

                //인접한 Node를 pq에 넣기
                for (int[] dir : dirs) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0) {
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = 1;
                    }
                }
            }
            res[idx] = cnt;
        }

        return res;
    }
}