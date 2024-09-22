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
                //이미 전에서 한번 확인한 경우와 같기 때문에 제외한다.
                //만약 [1,2,2,2,2,2]와 target이 주어질때
                //현재 idx =2이고, i는 3이라 가정하자.
                //이미 전에 i가 2일때 2를 넣고 한바퀴를 돌았다. 즉 뒤에 2,2,2,2로 만들 수 잇는 모든 경우에수는 확인햇다.
                //i가 3이되면 2를 넣고 2,2,2를 가지고 만들수 있는 모든 경우의 수를 확인한다.
                //즉, 이미 더큰 집합에서 경우의 수를 다확인하였기 때문에 중복해서 확인할 필요가 없다.
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