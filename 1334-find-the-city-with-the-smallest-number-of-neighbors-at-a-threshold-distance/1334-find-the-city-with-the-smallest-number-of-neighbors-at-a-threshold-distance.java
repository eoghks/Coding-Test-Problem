class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        int res = 0;
        int min = n;
        for(int i=0; i<n; i++) {
            Arrays.fill(dis[i], 10001);
            dis[i][i] = 0;
        }
        
        for(int[] edge: edges)
            dis[edge[0]][edge[1]] = dis[edge[1]][edge[0]] = edge[2];
        
        for(int mid=0; mid <n; mid++) {
            for(int st=0; st<n; st++) {
                for(int end=0; end<n; end++) {
                    dis[st][end] = Math.min(dis[st][end], dis[st][mid] + dis[mid][end]);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            int cnt =0;
            for(int j=0; j<n; j++) {
                if(dis[i][j] <= distanceThreshold)
                    cnt++;
            }
            if(cnt <= min) {
                res = i;
                min = cnt;
            }
        }
        return res;
    }
}