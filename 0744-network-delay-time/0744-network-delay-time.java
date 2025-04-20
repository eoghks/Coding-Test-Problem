class Solution {
    private class Pair{
        int weight;
        int des;

        public Pair(int weight, int des) {
            this.weight = weight;
            this.des = des;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] time: times) {
            map.get(time[0]).add(new Pair(time[2], time[1]));
        } 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] -b[0]);
        pq.add(new int[]{0,k});
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDis = cur[0];
            int curNode = cur[1];

            if(curDis > dist[curNode]) {
                continue;
            }

            for(Pair neighbor: map.get(curNode)) {
                int expectDis = curDis + neighbor.weight;
                if(expectDis < dist[neighbor.des]) {
                    dist[neighbor.des] = expectDis;
                    pq.offer(new int[]{expectDis, neighbor.des});
                }
            }
        }

        int res = 0;
        for(int i=1; i<=n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}