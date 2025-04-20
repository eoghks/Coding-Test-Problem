class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, graph, path, result);
        return result;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        path.add(node);
        if(node == graph.length -1) {
            result.add(new ArrayList<>(path));
        } else {
            //순환이 없기 때문에 따로 확인하지 않음
            for(int next: graph[node]) {
                dfs(next, graph, path, result);
            }
        }
        path.remove(path.size()-1);
    }
}