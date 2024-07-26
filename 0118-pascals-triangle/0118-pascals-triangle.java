class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        
        List<Integer> first = new ArrayList<>();
        first.add(1);
        answer.add(first);
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> prev = answer.get(i-1);
            List<Integer> cur = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(prev.get(j-1) + prev.get(j));
                }
            }
            answer.add(cur);
        }
        
        return answer;
    }
}