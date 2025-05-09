class Solution {
    private List<Integer>[] init(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for (int id = 0; id < n; id++) {
            graph[id] = new ArrayList<Integer>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        return graph;
    }
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] graph = init(n, edges);
        
        long[] sum = new long[n];
        findScores(-1, 0, graph, values, sum);
        
        int count = 0;
        for (long score : sum) {
            if (score % k == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    private long findScores(int prev, int cur, List<Integer>[] graph, int[] values, long[] sum) {
        sum[cur] = values[cur];
        
        for (int next : graph[cur]) {
            if (next == prev) {
                continue;
            }
            
            sum[cur] += findScores(cur, next, graph, values, sum);
        }
        
        return sum[cur];
    }

}