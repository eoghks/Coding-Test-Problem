class Solution {
    /* Bellan ford
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0; i<=k; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for(int j=0; j<flights.length; j++) {
                int[] flight = flights[j];
                if(dist[flight[0]] != Integer.MAX_VALUE && temp[flight[1]] > dist[flight[0]] + flight[2]) {
                    temp[flight[1]] = dist[flight[0]] + flight[2];
                }
            }
            dist = temp; 
        }
        return dist[dst] == Integer.MAX_VALUE? -1: dist[dst];
     }*/
     //다익스트라
    private class Flight {
        int dest;
        int cost;

        public Flight(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    class Node{
        int city;
        int cost;
        int stops;

        public Node(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Flight>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int c = flight[2];
            graph.get(u).add(new Flight(v, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node(src, 0, 0));

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.city == dst) 
                return cur.cost;
            //visited가 stops보다 작다는 것은 이미 한번 방문했던 도시라는 의미이고
            //pq에 의해 더짧은 동선으로 이미 방문했다는 것이 보장된다.
            //따라서 굳이 방문할 필요가 없다.
            if (cur.stops > k || cur.stops > visited[cur.city]) 
                continue;

            visited[cur.city] = cur.stops;

            for (Flight f : graph.get(cur.city)) {
                pq.offer(new Node(f.dest, cur.cost + f.cost, cur.stops + 1));
            }
        }

        return -1;
     }
}