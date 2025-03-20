class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        //그래프를 구분하기 위해 
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int[] minPath = new int[n];
        Arrays.fill(minPath, -1);
        for (int[] edge : edges) {
            int s = edge[0];
            int t = edge[1];
            int w = edge[2];
            int sRoot = findRoot(parent, s);
            int tRoot = findRoot(parent, t);

            minPath[tRoot] &= w;

            //그래프가 연결된 경우 가중치 설정 및 루트 통일
            if (sRoot != tRoot) {
                minPath[tRoot] &= minPath[sRoot];
                parent[sRoot] = tRoot;
            }
        }

        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0];
            int t = query[i][1];
            //그래프가 연결되지 않은 경우
            if (findRoot(parent, s) != findRoot(parent, t)) {
                res[i] = -1;
            } else {
                res[i] = minPath[findRoot(parent, s)];
            }
        }
        return res;
    }

    private int findRoot(int[] parent, int node) {
        if(parent[node] != node) {
            parent[node] = findRoot(parent, parent[node]);
        }
        return parent[node];
    }
}