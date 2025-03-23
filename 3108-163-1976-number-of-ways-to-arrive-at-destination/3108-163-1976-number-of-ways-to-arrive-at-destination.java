class Solution {
    //다익스트라 + DP
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});
        int MOD = 1_000_000_007;

        //0번째 node에서 i번째 node까지의 최소 거리를 기록
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        //최소 값으로 올 수 잇는 방법의 수를 기록
        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int node = (int) cur[1];

            if (d > dist[node]) 
                continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int time = neighbor[1];

                if (dist[node] + time < dist[nextNode]) {
                    dist[nextNode] = dist[node] + time;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{dist[nextNode], nextNode});
                } else if (dist[node] + time == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}