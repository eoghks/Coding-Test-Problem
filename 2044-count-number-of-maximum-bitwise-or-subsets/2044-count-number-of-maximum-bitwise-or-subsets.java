class Solution {
    int target = 0;
    int res = 0;
    public int countMaxOrSubsets(int[] nums) {
        for(int num: nums)
            target = target|num;
        dfs(nums, 0, 0);
        return res;
    }
    
    public void dfs(int[] nums, int idx, int cur) {
        if(cur == target)
            res++;
        for(int i=idx; i<nums.length; i++) {
            dfs(nums, i+1, cur|nums[i]);
        }
    } 
}