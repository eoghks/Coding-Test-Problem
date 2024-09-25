class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        solution(new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void solution(List<Integer> list, int[] nums, int idx) {
        res.add(new ArrayList<>(list));
        if(idx==nums.length) 
            return;
        
        for(int i = idx; i<nums.length; i++) {
            list.add(nums[i]);
            solution(list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}