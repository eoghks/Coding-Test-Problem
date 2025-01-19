class Solution {
    int[][] dir = {{-1,0}, {0,-1}, {1, 0}, {0,1}};
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean [][] visited = new boolean[m][n];

        //왼쪽 오른쪽 끝 
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
        }

        //위 아래 끝 
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new int[]{heightMap[0][i], 0, i});
            pq.offer(new int[]{heightMap[m - 1][i], m - 1, i});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0];
            int r = cur[1];
            int c = cur[2];

            //상하좌우 체크
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                //방문하지 않은 경우에만 확인
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    res += Math.max(0, h - heightMap[nr][nc]);
                    pq.offer(new int[]{Math.max(h, heightMap[nr][nc]), nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return res;
    }
}