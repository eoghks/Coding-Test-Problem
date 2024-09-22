class Solution {
    
    List<List<Integer>> res ;
    List<Integer> temp;
    int[] candidate;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        candidate = candidates;
        solution(target, 0);
        return res;
    }
    
    public void solution(int target, int idx) {
        if(target == 0 ) {
            if(res.contains(temp) == false)
                res.add(new ArrayList<>(temp));
            return;
        } 
            
        for(int i = idx; i<candidate.length; i++) {
            if(target >= candidate[i]) {
                if(i > idx && candidate[i] == candidate[i-1])
                    continue;
                temp.add(candidate[i]);
                solution(target-candidate[i], i+1);
                temp.remove(temp.size()-1);
            } else
                break;
        }
    }
}