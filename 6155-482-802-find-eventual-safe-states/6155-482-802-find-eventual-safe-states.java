class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        int[] in = new int[n];
        for(int i = 0; i < n; i++) {
            for(int g: graph[i]) {
                list.get(g).add(i);
                in[i]++;
            }
        }

        Queue<Integer> pq = new LinkedList<>();
        boolean visit[] = new boolean[n];
        for(int i=0; i<n; i++) {
            if(in[i] == 0)
                pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int val = pq.poll();
            visit[val] = true;
            for(int i: list.get(val)) {
                in[i]--;
                if(in[i] == 0)
                    pq.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(visit[i])
            {
                res.add(i);
            }
        }

        return res;
    }
}