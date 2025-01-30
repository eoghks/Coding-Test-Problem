class Solution {
    boolean[] vis;
    public int magnificentSets(int n, int[][] edges) {
        int res = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> components = new HashMap<>();
        vis = new boolean[n+1];
        
        //graph 만들기
        for(int node = 1; node<=n; node++) {
            graph.put(node, new ArrayList<>());
        }

        for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        //dfs를 활용하여 spanning tree를 만듬
        int component = 1;
        for(int node = 1; node<=n; node++) {
            if(vis[node])
                continue;
            vis[node] = true;
            components.put(component, new ArrayList<>());
            dfs(component++, node, graph, components);   
        }

        //각 spanning tree 별로 group을 나누기
        int[] componentsMaxTravel = new int[component];
        for(int comp = 1; comp < component; comp++) {
            //각 spanning tree의 node별로 그룹을 나눌때 최대 그룹수를 구하기
            for (int compNode : components.get(comp)) {
                int compRes = bfs(compNode, graph);
                if(compRes == -1) 
                    return -1;
                componentsMaxTravel[comp] = Math.max(componentsMaxTravel[comp], compRes);
            }
            res += componentsMaxTravel[comp];
        }

        return res;
    }

    //dfs 코드
    private void dfs(int component, int node, Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> components) {
        components.get(component).add(node);
        for (int neighbor : graph.get(node)) {
            if(vis[neighbor]) 
                continue;
            vis[neighbor] = true;
            dfs(component, neighbor, graph, components);
        }
    }

    //bfs코드
     private int bfs(int node, Map<Integer, List<Integer>> graph) {
        int res = 0;
        boolean[] visited = new boolean[graph.size()+1];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> curLevel = new HashSet<>();
        
        queue.offer(node);
        visited[node] = true;
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            Set<Integer> nextLevel = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int curNode = queue.poll();
                for(int neighbor : graph.get(curNode)) {
                    if(curLevel.contains(neighbor)) 
                        return -1;
                    if(visited[neighbor]) 
                        continue;
                    nextLevel.add(neighbor);
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }

            curLevel = nextLevel;
            res++;
        }
        
        return res;
    }
}