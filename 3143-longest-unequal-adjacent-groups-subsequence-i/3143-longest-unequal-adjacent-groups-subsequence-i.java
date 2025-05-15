class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        solution(0, -1, words, groups, res);
        return res;
    }

    private void solution(int i, int prev, String[] words, int[] groups, List<String> res){
        if(i == words.length) 
            return;
        if(prev != groups[i]){
            res.add(words[i]);
        }
        solution(i+1, groups[i], words, groups, res);
    }
}