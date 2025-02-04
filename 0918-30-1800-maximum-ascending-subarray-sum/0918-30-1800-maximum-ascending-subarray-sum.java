class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0]; 
        int cur = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                cur+=nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}