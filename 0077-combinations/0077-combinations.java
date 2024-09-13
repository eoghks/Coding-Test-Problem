class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        solution(n, k , 1, res, new ArrayList<>());
        return res;
    }
    
    public void solution(int n, int k, int idx, List<List<Integer>> res, List<Integer> cur) {
        if(cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=idx; i<=n; i++) {
            cur.add(i);
            solution(n,k, i+1, res, cur);
            cur.remove(cur.size()-1);
        }
    }
}