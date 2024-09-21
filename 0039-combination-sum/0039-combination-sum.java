class Solution {
    List<List<Integer>> res;
    List<Integer> temp;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        solution(candidates, target, 0, 0);
        return res;
    }
    
    public void solution(int[] candidates, int target, int idx, int cur) {
        if(cur == target) {
            res.add(new ArrayList<>(temp));
            return;
        } 
        
        for(int i=idx; i<candidates.length; i++) {
            if(cur+candidates[i] <= target) {
                temp.add(candidates[i]);
                solution(candidates, target, i, cur+candidates[i]);
                temp.remove(temp.size()-1);
            } else
                break;
        }        
    }
}