class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for(int i=1; i<n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            if(find(x) == find(y)) {
                return edge;
            } else {
                union(x, y);
            }
        }
        return new int[0];
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
    }
}