class Solution {
    /*Use BFS
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;
        HashMap<Integer, Set<Integer>> stopMap = new HashMap<>();

        for(int i=0; i<routes.length; i++) {
            for(int stop: routes[i]) {
                stopMap.putIfAbsent(stop, new HashSet<>());
                stopMap.get(stop).add(i);
            }
        }

        if(stopMap.containsKey(source) == false) {
            return -1;
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        for(int bus: stopMap.get(source)) {
            visited.add(bus);
            q.add(bus);
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int bus = q.poll();
                for(int stop: routes[bus]) {
                    if(stop == target) {
                        return cnt;
                    }
                    for(int nextBus: stopMap.get(stop)) {
                        if(visited.contains(nextBus) == false) {
                            q.add(nextBus);
                            visited.add(nextBus);
                        }
                    }
                }
            }
            cnt++; 
        }

        return -1;
    }
    */
    //Use Bellman ford
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;

        int maxStop = -1;
        for (int[] route : routes) {
            for (int stop : route) {
                maxStop = Math.max(maxStop, stop);
            }
        }
        if (maxStop < target || maxStop < source) {
            return -1;
        }
        int n = routes.length;
        int[] minBusesToReach = new int[maxStop + 1];
        Arrays.fill(minBusesToReach, n + 1);
        minBusesToReach[source] = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int[] route : routes) {
                int min = n + 1;
                for (int stop : route) {
                    min = Math.min(min, minBusesToReach[stop]);
                }
                min++;
                for (int stop : route) {
                    if (minBusesToReach[stop] > min) {
                        minBusesToReach[stop] = min;
                        flag = true;
                    }
                }
            }
        }
        return (minBusesToReach[target] < n + 1 ? minBusesToReach[target] : -1);
    }
}