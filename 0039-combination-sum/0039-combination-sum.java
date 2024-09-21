class Solution {
    List<List<Integer>> res;
    List<Integer> temp;
    int[] can;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        can = candidates;
        solution(target, 0);
        return res;
    }
    
    public void solution(int target, int idx) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } 
        
        for(int i=idx; i<can.length; i++) {
            if(target-can[i] >= 0) {
                temp.add(can[i]);
                solution(target-can[i], i);
                temp.remove(temp.size()-1);
            } else
                break;
        }        
    }
}