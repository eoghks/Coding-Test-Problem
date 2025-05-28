class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> list1 = buildList(edges1);
        List<List<Integer>> list2 = buildList(edges2);
        int m = list2.size();
        int maxiB = 0;
        for (int i = 0; i < m; i++) {
            maxiB = Math.max(maxiB, dfs(list2, i, -1, k - 1));
        }
        int n = list1.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(list1, i, -1, k) + maxiB;
        }
        return res;
    }

    private List<List<Integer>> buildList(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());
        for (int[] e : edges) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        return list;
    }

    private int dfs(List<List<Integer>> list, int u, int p, int k) {
        if (k < 0) return 0;
        int cnt = 1;
        for (int v : list.get(u)) {
            if (v != p) cnt += dfs(list, v, u, k - 1);
        }
        return cnt;
    }
}