class Solution {
    private class Pair{
        private int des;
        private double weight;
        public Pair(int des, double weight) {
            this.des =des;
            this.weight = weight;
        }
        public int getDes(){
            return des;
        }
        public double getWeight() {
            return weight;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            double w = succProb[i];
            map.get(v1).add(new Pair(v2, w));
            map.get(v2).add(new Pair(v1, w));
        }

        double[] pro = new double[n];
        pro[start_node] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(Pair::getWeight).reversed());
        pq.add(new Pair(start_node,1d));
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int v = cur.getDes();
            double w = cur.getWeight();

            if(w > pro[v]) {
                continue;
            }
            if(v == end_node) {
                return w;
            }
            for(Pair next: map.get(v)) {
                double nextW = w * next.getWeight();
                if(nextW > pro[next.getDes()]) {
                    pro[next.getDes()] = nextW;
                    pq.add(new Pair(next.getDes(), nextW));
                }
            }
        }
        return 0d;
    }
}