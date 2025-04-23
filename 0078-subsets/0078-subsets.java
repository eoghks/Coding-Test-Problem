class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solution(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void solution(int[] nums, int st, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList(list));
        for(int i=st; i<nums.length; i++) {
            list.add(nums[i]);
            solution(nums, i+1, list, res);
            list.remove(list.size()-1);
        }
    }
}