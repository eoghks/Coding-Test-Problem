class Solution {
    /* Use Union Find
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<n; i++) {
            int rootI = find(i);
            for(int j= i+1; j<n; j++) {
                if(isConnected[i][j] == 1 && rootI != find(j)) {
                    union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int p: parent) {
            set.add(find(p));
        }
        return set.size();
    }

    private int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        parent[rootY] = rootX;
    }*/
    // Use DFS
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i=0; i<n; i++) {
            if(visited[i] == false) {
                res++;
                dfs(i, visited, isConnected);
            }
        }
        return res;
    }
    private void dfs(int i, boolean[] visited, int[][] isConnected) {
        visited[i] = true;
        for(int j = 0; j<visited.length; j++) {
            if(isConnected[i][j] == 1 && visited[j] == false) {
                dfs(j, visited, isConnected);
            }
        }
    }
}