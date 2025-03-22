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

    private int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2) 
            return;

        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
}
