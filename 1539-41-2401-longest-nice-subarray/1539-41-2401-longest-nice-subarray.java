class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        int left = 0;
        int bit = 0;

        for(int right = 0; right < n; right++) {
            while((bit & nums[right]) != 0) {
                bit ^= nums[left];
                left++;
            }

            bit|=nums[right];
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}