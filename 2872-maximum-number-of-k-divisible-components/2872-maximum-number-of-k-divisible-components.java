class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] graph = buildGraph(n, edges);
        
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
    
    private long findScores(int prev, int curr, List<Integer>[] graph, int[] values, long[] sum) {
        sum[curr] = values[curr];
        
        for (int next : graph[curr]) {
            if (next == prev) {
                continue;
            }
            
            sum[curr] += findScores(curr, next, graph, values, sum);
        }
        
        return sum[curr];
    }
    
    private List<Integer>[] buildGraph(int n, int[][] edges) {
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
}