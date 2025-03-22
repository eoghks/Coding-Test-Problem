class Solution {
    int[] parent;
    int[] rank;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Map<Integer, Set<Integer>> vertex = new HashMap<>();
        Map<Integer, Integer> edge = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            vertex.computeIfAbsent(root, k -> new HashSet<>()).add(i);
        }

        for (int[] e : edges) {
            int root = find(e[0]);
            edge.put(root, edge.getOrDefault(root, 0) + 1);
        }

        int cnt = 0;
         for (int root : vertex.keySet()) {
            int num = vertex.get(root).size();
            int expect = num * (num - 1) / 2;

            if (edge.getOrDefault(root, 0) == expect) {
                cnt++;
            }
        }
        return cnt;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) 
            return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
