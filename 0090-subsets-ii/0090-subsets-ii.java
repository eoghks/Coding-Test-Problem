class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solution(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void solution(int st, int[] nums, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for(int i=st; i<nums.length; i++) {
            if(i>st && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            solution(i+1, nums, list, res);
            list.remove(list.size()-1);
        }
    }
}